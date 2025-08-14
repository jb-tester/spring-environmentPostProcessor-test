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
            Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("external.properties"));
            environment.getPropertySources().addFirst(new org.springframework.core.env.PropertiesPropertySource("externalProperties", properties));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load external properties", e);
        }
    }
}