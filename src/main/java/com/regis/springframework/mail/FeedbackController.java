package com.regis.springframework.mail;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class FeedbackController {
	
	@PostConstruct
	public void sendFeedback() throws Exception {
		// Create a mail sender
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(465);
		mailSender.setUsername("regisyamamoto@gmail.com");
		mailSender.setPassword("Ada;Bab1843");
		
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.ssl.enable", "true");
		mailSender.setJavaMailProperties(properties);
		
		// Create an mail instance
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("regisyamamoto@gmail.com");
		mailMessage.setTo("regisyamamoto@gmail.com");
		mailMessage.setSubject("Teste Assunto");
		mailMessage.setText("Teste de mensagem.");
		
		// Send email
		mailSender.send(mailMessage);
	}

}
