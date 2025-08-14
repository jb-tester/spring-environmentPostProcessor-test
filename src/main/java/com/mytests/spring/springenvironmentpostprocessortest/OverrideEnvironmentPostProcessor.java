package com.mytests.spring.springenvironmentpostprocessortest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class OverrideEnvironmentPostProcessor implements EnvironmentPostProcessor {

    /*
    // override the specific property source, providing a new value for the specified key
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        PropertySource<?> propertySource = environment.getPropertySources().get("Config resource 'class path resource [application.properties]' via location 'optional:classpath:/'");
        if (propertySource != null) {
            environment.getPropertySources().replace("Config resource 'class path resource [application.properties]' via location 'optional:classpath:/'", new PropertySource<Object>("overridePropertySource") {
                @Override
                public Object getProperty(String name) {
                    if ("replaced.key".equals(name)) {
                        return "replaced value from OverrideEnvironmentPostProcessor";
                    }
                    return propertySource.getProperty(name);
                }
            });
        }}
*/
    // try to find all property sources that contain the specified key and replace them,  providing the different value for this key
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        MutablePropertySources propertySources = environment.getPropertySources();
        for (PropertySource<?> propertySource : propertySources) {
            String propertySourceName = propertySource.getName();
            // we need to filter-out the configurationProperties property source here to avoid SOE
            if (!propertySourceName.equals("configurationProperties") && propertySource.containsProperty("replaced.key")){

                propertySources.replace(propertySourceName, new PropertySource<Object>("overridePropertySource") {
                    @Override
                    public Object getProperty(String name) {
                        if ("replaced.key".equals(name)) {
                            return "replaced value from OverrideEnvironmentPostProcessor";
                        }
                        return propertySource.getProperty(name);
                    }
                });
            }
        }
        }

    }
