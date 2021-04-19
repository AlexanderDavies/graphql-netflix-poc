package com.au.alexanderdavies.graphqlnetflixpoc.security;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

@Order(0)
public class GraphQlFilter implements Filter {

    private Environment env;

    private static final String LOCAL = "local";

    @Autowired
    public GraphQlFilter(Environment env) {
        this.env = env;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (Arrays.asList(env.getActiveProfiles()).contains(LOCAL)) {
            chain.doFilter(request, response);
        } else {
            throw new IOException("resource not found");
        }
    }

}
