package com.hummel.testgwan.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hummel.testgwan.common.models.Customer;
import com.hummel.testgwan.customer.services.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class CustomerController {
	
	private final CustomerService service;

	@PostMapping(path = "/register")
	public ResponseEntity<?> register(@RequestBody Customer customer) {
		Customer output = service.register(customer);
		return output == null ? new ResponseEntity<>(null, HttpStatus.NO_CONTENT) : new ResponseEntity<>(output, HttpStatus.CREATED);
	}
}



