package com.nttdata.nttdatacentersspringt4RBP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages={"Repository"})
@EntityScan(basePackages="Model")
@ComponentScan({"Controller","Service"})
@SpringBootApplication
public class NttdatacentersSpringT4RbpApplication {

	public static void main(String[] args) {
		SpringApplication.run(NttdatacentersSpringT4RbpApplication.class, args);
	}

}
