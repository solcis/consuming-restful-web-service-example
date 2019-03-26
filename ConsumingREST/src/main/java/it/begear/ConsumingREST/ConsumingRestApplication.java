package it.begear.ConsumingREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

	// RestTemplate will convert incoming JSON data into Quote, contents of the Quote object will be logged to the console
	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class);
	}
	
	// RestTemplate will convert incoming JSON data into Quote, contents of the Quote object will be logged to the console
	// RestTemplateBuilder is injected by Spring
	// if used to create RestTemplate you benefit from autoconfiguration that happens in Spring Boot with message converters and request factories
	// extract RestTemplate into @Bean to make it easier to test (can be mocked easily that way)
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	// executed by Spring Boot on startup
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info(quote.toString());
		};
	}

}
