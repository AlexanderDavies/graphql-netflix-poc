package com.au.alexanderdavies.graphqlnetflixpoc.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Order(1)
public class GraphQlFilter implements Filter {

    private static final String LOCAL_ADMIN = "LOCAL_ADMIN";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                boolean isValid = authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(LOCAL_ADMIN));

                if(isValid) {
                    chain.doFilter(request, response);
                } else {
                    throw new IOException("user does not have permission to access this route");
                }

    }

}
