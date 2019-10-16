package com.hummel.testgwan.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

import com.hummel.testgwan.common.models.Customer;
import com.hummel.testgwan.common.repository.CustomerRepository;

@SpringBootApplication
@EntityScan({"com.hummel.testgwan.common.models"})
@ComponentScan({"com.hummel.testgwan.services", "com.hummel.testgwan.controller"})
@EnableJpaRepositories({"com.hummel.testgwan.common.repository"})
public class CustomerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CustomerRepository repo) {
		return (event) -> {
			repo.save(new Customer("Adam", "adam@boot.com"));
			repo.save(new Customer("John", "john@boot.com"));
			repo.save(new Customer("Smith", "smith@boot.com"));
			repo.save(new Customer("Edgar", "edgar@boot.com"));
			repo.save(new Customer("Martin", "martin@boot.com"));
			repo.save(new Customer("Tom", "tom@boot.com"));
			repo.save(new Customer("Sean", "sean@boot.com"));
		};
	}

}
