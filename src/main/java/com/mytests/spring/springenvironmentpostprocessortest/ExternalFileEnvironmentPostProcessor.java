package com.mytests.spring.springenvironmentpostprocessortest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class ExternalFileEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        try {
            // if the externalProperties source has the lowest priority, the external.properties file doesn't get the inlays for the overridded property:
            //Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("external.properties"));
            // if the externalProperties source has the highest priority, the application.properties file gets the inlays for the overridded property correctly:
            Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("external.properties"));
            environment.getPropertySources().addFirst(new org.springframework.core.env.PropertiesPropertySource("externalProperties", properties));
            environment.getPropertySources().addLast(new org.springframework.core.env.PropertiesPropertySource("externalProperties", properties));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load external properties", e);
        }
    }
}