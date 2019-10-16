package com.hummel.testgwan.customer.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hummel.testgwan.common.models.Customer;
import com.hummel.testgwan.common.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@Lazy
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerService {
	
	private final CustomerRepository customerRespository;
	private final Sender sender;

	public Customer register(Customer customer) {
		
		System.out.println("Starting the register");
		
		Optional<Customer> existingCustomer = customerRespository.findByName(customer.getName());
		
		if (existingCustomer.isPresent()) {
			throw new RuntimeException("is already exists");
		} else {
			System.out.println("Saving Customer");
			customerRespository.save(customer);
			sender.send(customer);
		}
		
		return customer;
	}
}