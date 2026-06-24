package com.jobportal.service;

import java.util.List;
import com.jobportal.entity.Job;

public interface JobService {

    Job saveJob(Job job);

    List<Job> getAllJobs();

    Job getJobById(Long id);

    Job updateJob(Long id, Job job);

    String deleteJob(Long id);
}