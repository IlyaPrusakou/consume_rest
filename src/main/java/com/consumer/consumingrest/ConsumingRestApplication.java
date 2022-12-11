package com.consumer.consumingrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestApplication {

	private static  final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);


	public static void main(String[] args) {
		log.info("11111111111111111Start");
		SpringApplication.run(ConsumingRestApplication.class, args);
		log.info("after run");
	};

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			log.info("before request");
			Quote quote = restTemplate.getForObject("http://localhost:8080/api/random", Quote.class);
			log.info("after request");
			log.info(quote.toString());
			log.info("the end");
		};
	}

}
