package com.hummel.testgwan.customer.services;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.hummel.testgwan.common.models.Customer;


import lombok.RequiredArgsConstructor;

@Component
@Lazy
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Sender {

	private final RabbitMessagingTemplate messager;
	
	@Bean
	Queue queue() {
		return new Queue("RegisterQueue", false);
	}

	public void send(Customer customer) {
		System.out.println("Sender Sending email");
		messager.convertAndSend("RegisterQueue", customer.getEmail());
	}

}
