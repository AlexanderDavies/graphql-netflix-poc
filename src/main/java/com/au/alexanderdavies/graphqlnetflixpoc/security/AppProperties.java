package com.au.alexanderdavies.graphqlnetflixpoc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {
    @Autowired
    Environment env;

    private static final String USER_NAME = "user_name";
    private static final String USER_PASSWORD = "user_password";
    private static final String ADMIN_NAME = "admin_name";
    private static final String ADMIN_PASSWORD = "admin_password";

    public String getUserName() {
        return env.getProperty(USER_NAME);
    }

    public String getUserPassword() {
        return env.getProperty(USER_PASSWORD);
    }

    public String getAdminName() {
        return env.getProperty(ADMIN_NAME);
    }

    public String getAdminPassword() {
        return env.getProperty(ADMIN_PASSWORD);
    }
}
