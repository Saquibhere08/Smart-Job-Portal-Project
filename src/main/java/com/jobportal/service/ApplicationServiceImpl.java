package com.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.entity.Application;
import com.jobportal.repository.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Application saveApplication(Application application) {
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
    public Application updateApplication(Long id,
                                         Application application) {

        Application existingApplication =
                applicationRepository.findById(id).orElse(null);

        if (existingApplication != null) {

            existingApplication.setUserId(application.getUserId());
            existingApplication.setJobId(application.getJobId());
            existingApplication.setStatus(application.getStatus());

            return applicationRepository.save(existingApplication);
        }

        return null;
    }

    @Override
    public String deleteApplication(Long id) {

        if (applicationRepository.existsById(id)) {
            applicationRepository.deleteById(id);
            return "Application Deleted Successfully";
        }

        return "Application Not Found";
    }
}