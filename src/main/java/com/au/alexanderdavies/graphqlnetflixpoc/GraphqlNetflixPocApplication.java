package com.au.alexanderdavies.graphqlnetflixpoc;

import com.au.alexanderdavies.graphqlnetflixpoc.security.GraphQlFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlNetflixPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlNetflixPocApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean<>();
		registration.setFilter(new GraphQlFilter());
		registration.addUrlPatterns("/graphiql");
		return registration;
	}

}
