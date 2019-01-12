package com.cadcli.test_compasso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.cadcli.test_compasso.entity")
public class TestCompassoApplication {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(TestCompassoApplication.class);
		application.setAddCommandLineProperties(false);
		application.run(args);
	}

}

