package com.cadcli.test_compasso;

import com.cadcli.test_compasso.entity.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.cadcli.test_compasso.entity")
public class TestCompassoApplication {

	public static void main(String... args) {

		SpringApplication application = new SpringApplication(TestCompassoApplication.class);
		application.setAddCommandLineProperties(false);
		application.run(args);
	}


}

