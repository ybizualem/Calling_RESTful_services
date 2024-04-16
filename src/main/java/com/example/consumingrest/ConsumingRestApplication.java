package com.example.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	@Value("${quoters_base_url}")
	private String quotersBaseUrl;

	@Bean
	@Profile("!test")
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote1 = restTemplate.getForObject(quotersBaseUrl + "/api/1", Quote.class);
            log.info(quote1.toString());
			Quote quote2 = restTemplate.getForObject(quotersBaseUrl + "/api/2", Quote.class);
			log.info(quote2.toString());
			Quote quote3 = restTemplate.getForObject(quotersBaseUrl + "/api/3", Quote.class);
			log.info(quote3.toString());
			Quote quote4 = restTemplate.getForObject(quotersBaseUrl + "/api/4", Quote.class);
			log.info(quote4.toString());
			Quote quoteRandom = restTemplate.getForObject(quotersBaseUrl + "/api/random", Quote.class);
			log.info(quoteRandom.toString());
		};
	}
}