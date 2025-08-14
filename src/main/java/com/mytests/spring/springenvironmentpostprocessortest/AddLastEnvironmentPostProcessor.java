package com.mytests.spring.springenvironmentpostprocessortest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

public class AddLastEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Map<String, Object> customProperties = new HashMap<>();
        customProperties.put("my.props.last.test1", "value from AddLastEnvironmentPostProcessor");
        customProperties.put("my.props.last.test2", "value from AddLastEnvironmentPostProcessor");
        
        MapPropertySource propertySource = new MapPropertySource("customLastPropertySource", customProperties);
        environment.getPropertySources().addLast(propertySource);
    }
}