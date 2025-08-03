package com.Somya.task_scheduler_worker.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue jobQueue() {
        // This ensures the worker knows exactly what the "job.queue" should look like
        return new Queue("job.queue", false);
    }
}