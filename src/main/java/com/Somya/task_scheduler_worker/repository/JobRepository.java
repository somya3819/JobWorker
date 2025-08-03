package com.Somya.task_scheduler_worker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Somya.task_scheduler_worker.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    // This interface remains empty
}