package com.au.alexanderdavies.graphqlnetflixpoc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContext implements ApplicationContextAware {
    public static ApplicationContext CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        CONTEXT = context;

    }

    public static Object getBean(String beanName) {
        return CONTEXT.getBean(beanName);
    }
}