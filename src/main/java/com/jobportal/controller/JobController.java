package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jobportal.entity.Job;
import com.jobportal.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    // CREATE
    @PostMapping
    public Job saveJob(@RequestBody Job job) {
        return jobService.saveJob(job);
    }

    // GET ALL
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id,
                         @RequestBody Job job) {
        return jobService.updateJob(id, job);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        return jobService.deleteJob(id);
    }
}