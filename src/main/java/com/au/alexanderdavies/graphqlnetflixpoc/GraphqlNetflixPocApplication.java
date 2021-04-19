package com.au.alexanderdavies.graphqlnetflixpoc;

import com.au.alexanderdavies.graphqlnetflixpoc.security.GraphQlFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class GraphqlNetflixPocApplication {

	@Autowired
	Environment env;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlNetflixPocApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean<>();
		registration.setFilter(new GraphQlFilter(env));
		registration.addUrlPatterns("/graphiql");
		return registration;
	}

}
