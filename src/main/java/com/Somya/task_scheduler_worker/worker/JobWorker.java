package com.Somya.task_scheduler_worker.worker;

import com.Somya.task_scheduler_worker.repository.JobRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component 
public class JobWorker {

    @Autowired
    private JobRepository jobRepository;

    @RabbitListener(queues = "job.queue")
    public void processJob(String jobId) {
        System.out.println("------------------------------------------");
        System.out.println("MAILMAN RECEIVED A LETTER! Job ID: " + jobId);
        System.out.println("I will now pretend to do the work...");

        // Optional: You can use the repository to get job details
        // jobRepository.findById(Long.parseLong(jobId)).ifPresent(job -> {
        //     System.out.println("Working on job: " + job.getTitle());
        // });

        System.out.println("Work finished for Job ID: " + jobId);
        System.out.println("------------------------------------------");
    }
}
