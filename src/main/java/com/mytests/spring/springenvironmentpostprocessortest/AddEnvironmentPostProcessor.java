package com.mytests.spring.springenvironmentpostprocessortest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class AddEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Map<String, Object> map = new HashMap<>();
        map.put("my.props.second.test3", "test3_value_from_env_properties_provider");
        map.put("my.props.second.test4", "test4_value_from_env_properties_provider");
        MapPropertySource propertySource1 = new MapPropertySource("PROPERTY_TEST_FIRST", Map.of("my.props.first.test1", "test1_value_from_env_properties_provider", "my.props.first.test2", "test2_value_from_env_properties_provider"));
        environment.getPropertySources().addFirst(
                propertySource1
        );
        environment.getPropertySources().addFirst(new MapPropertySource("PROPERTY_TEST_SECOND", map));

        environment.getPropertySources().addFirst(new MapPropertySource("PROPERTY_TEST_THIRD", Map.ofEntries(
                Map.entry("my.props.third.test5", "test5_value_from_env_properties_provider"),
                Map.entry("my.props.third.test6", "test6_value_from_env_properties_provider")
        )));
        environment.getPropertySources().addFirst(new MapPropertySource("PROPERTY_TEST_FORTH", new HashMap<String, Object>() {{
            put("my.props.forth.test7", "test7_value_from_env_properties_provider");
            put("my.props.forth.test8", "test8_value_from_env_properties_provider");
        }}));
        environment.getPropertySources().addFirst(new MapPropertySource("PROPERTY_TEST_FIFTH", Stream.of(new String[][] {
                {"my.props.fifth.test9", "test9_value_from_env_properties_provider"},
                {"my.props.fifth.test10", "test10_value_from_env_properties_provider"}
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]))));
    }
}
