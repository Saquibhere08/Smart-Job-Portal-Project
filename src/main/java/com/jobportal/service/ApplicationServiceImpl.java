package com.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.entity.Application;
import com.jobportal.entity.Job;
import com.jobportal.entity.User;
import com.jobportal.repository.ApplicationRepository;
import com.jobportal.repository.JobRepository;
import com.jobportal.repository.UserRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Application saveApplication(Application application) {

        User user = userRepository
                .findById(application.getUser().getId())
                .orElse(null);

        Job job = jobRepository
                .findById(application.getJob().getId())
                .orElse(null);

        application.setUser(user);
        application.setJob(job);

        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

    @Override
    public Application updateApplication(Long id, Application application) {

        Application existingApplication =
                applicationRepository.findById(id).orElse(null);

        if (existingApplication != null) {

            User user = userRepository
                    .findById(application.getUser().getId())
                    .orElse(null);

            Job job = jobRepository
                    .findById(application.getJob().getId())
                    .orElse(null);

            existingApplication.setUser(user);
            existingApplication.setJob(job);
            existingApplication.setStatus(application.getStatus());

            return applicationRepository.save(existingApplication);
        }

        return null;
    }

    @Override
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public List<Application> getApplicationsByUser(Long userId) {
        return applicationRepository.findByUserId(userId);
    }

    @Override
    public List<Application> getApplicationsByJob(Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }
}