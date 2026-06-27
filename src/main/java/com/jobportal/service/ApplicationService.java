package com.jobportal.service;

import java.util.List;

import com.jobportal.entity.Application;

public interface ApplicationService {

    Application saveApplication(Application application);

    List<Application> getAllApplications();

    Application getApplicationById(Long id);

    Application updateApplication(Long id, Application application);

    void deleteApplication(Long id);

    List<Application> getApplicationsByUser(Long userId);

    List<Application> getApplicationsByJob(Long jobId);
}