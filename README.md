# Task Scheduler Worker
Hello again! This is the second major component of my Distributed Task Scheduler project: The Worker.

If the task-scheduler-api project is the "Office Manager" that takes orders, then this project is the dedicated, hardworking "Mailman" who actually gets the work done.

# The Other 50% of the Project
This Worker service, combined with the automated Scheduler in the API server, represents the completion of the core functionality. While the first half of the project was about accepting and queuing tasks, this half is all about asynchronously processing them. This is what makes the system truly "distributed" and scalable.

# What's Its Job?
The Worker has a very simple and focused responsibility:

Listen: It constantly keeps an eye on the job.queue in our RabbitMQ message broker.

Receive: As soon as a new message (containing a Job ID) appears in the queue, the Worker immediately picks it up.

Process: It then "pretends" to do the work associated with that job. In a real-world application, this is where you would put the code to actually send an email, generate a report, or process a video.

Repeat: After finishing one job, it goes right back to listening for the next one.

This architecture is incredibly powerful because we can run multiple instances of this Worker. If we have 10,000 jobs to process, we can simply start 10 "Mailmen" to clear the queue 10 times faster, without ever slowing down the main API server.

# The Magic Behind It: @RabbitListener
The core of this entire service is a single, powerful annotation from Spring AMQP: @RabbitListener(queues = "job.queue").

This one line of code turns a simple Java method into a dedicated, multi-threaded message consumer. It handles all the complex parts of connecting to RabbitMQ, waiting for messages, and processing them reliably.

# Tech I'm Using
The tech stack is very similar to the API server, as it needs to connect to the same systems.

Language & Framework: Java 17, Spring Boot 3

Messaging: Spring AMQP for RabbitMQ

Database: Spring Data JPA with PostgreSQL (to potentially fetch more job details)

Build Tool: Maven

# How to Run This Worker
The Worker cannot run alone; it needs the task-scheduler-api and the other services to be running.

# Prerequisites:

Java 17 (JDK)

Docker Desktop

# Steps:

Start Dependencies: Make sure your PostgreSQL and RabbitMQ containers are running in Docker.

Start the API Server: Run the task-scheduler-api application first.

Run the Worker: In a separate terminal, run this task-scheduler-worker application.

Once both applications are running, use the dashboard.html or Postman to create a new job. You will see the API server queue the job, and you'll see the console of this Worker application print a "MAILMAN RECEIVED A LETTER!" message almost instantly.
