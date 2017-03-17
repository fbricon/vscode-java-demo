package com.redhat.vscode.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

@SpringBootApplication
public class DevoxxApplication implements InitializingBean {

	@Autowired
	private MessageRepository messageRepository; 

	@Override
	public void afterPropertiesSet() throws Exception {
	  //messageRepository.deleteAll();
	}


	@Bean
	public Converter<String, Message> messageConverter() {
		return new Converter<String, Message>() {
			@Override
			public Message convert(String id) {
				return messageRepository.findOne(id);
			}
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DevoxxApplication.class, args);
	}
}
