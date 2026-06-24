package com.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.entity.Job;
import com.jobportal.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Job updateJob(Long id, Job job) {

        Job existingJob = jobRepository.findById(id).orElse(null);

        if (existingJob != null) {

            existingJob.setTitle(job.getTitle());
            existingJob.setCompanyName(job.getCompanyName());
            existingJob.setLocation(job.getLocation());
            existingJob.setSalary(job.getSalary());
            existingJob.setDescription(job.getDescription());

            return jobRepository.save(existingJob);
        }

        return null;
    }

    @Override
    public String deleteJob(Long id) {

        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return "Job Deleted Successfully";
        }

        return "Job Not Found";
    }
}