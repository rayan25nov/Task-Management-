package com.personal.task_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
		System.out.println("Server is running on " + 8080);
	}

}

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ApplicationListener;
// import org.springframework.boot.context.event.ApplicationReadyEvent;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// @SpringBootApplication
// public class TaskManagementApplication {

//     private static final Logger logger = LoggerFactory.getLogger(TaskManagementApplication.class);

//     public static void main(String[] args) {
//         SpringApplication app = new SpringApplication(TaskManagementApplication.class);
//         app.addListeners((ApplicationListener<ApplicationReadyEvent>) event -> {
//             int port = event.getApplicationContext().getEnvironment().getProperty("server.port", Integer.class, 8080);
//             logger.info("Server is running on port {}", port);
//         });
//         app.run(args);
//     }
// }

