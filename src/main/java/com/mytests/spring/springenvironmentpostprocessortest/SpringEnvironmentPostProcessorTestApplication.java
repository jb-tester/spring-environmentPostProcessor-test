package com.mytests.spring.springenvironmentpostprocessortest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringEnvironmentPostProcessorTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEnvironmentPostProcessorTestApplication.class, args);
    }
    @Bean
        public CommandLineRunner commandLineRunner(TestService testService) {
            return args -> {
                System.out.println("--------------------------------------");
                testService.displayProperties();
                System.out.println("--------------------------------------");
            };
        }
}
