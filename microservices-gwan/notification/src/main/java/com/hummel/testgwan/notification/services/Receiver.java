package com.hummel.testgwan.notification.services;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Receiver {
	
	MailService service;
	
	@Bean
	Queue queue() {
		return new Queue("RegisterQueue", false);
	}

	@RabbitListener(queues = "RegisterQueue")
	public void processMessage(String email) {
		System.out.println("Rabbit getting message from Sender\n\n\n");
		System.out.println("EMAIL" + email);
		service.sendMail(email);
	}
}
