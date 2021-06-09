package net.thumbtack.school.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("Start application... \n");
		SpringApplication.run(Application.class, args);
		System.out.println("Stop application... \n");
	}

}
