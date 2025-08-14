package com.mytests.spring.springenvironmentpostprocessortest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
class TestService {

    private final Environment environment;
    @Value("${my.props.second.test3:default}")
    private String test3;
    @Value("${my.props.second.test4:default}")
    private String test4;
    @Value("${my.props.third.test5:default}")
    private String test5;
    @Value("${my.props.third.test6:default}")
    private String test6;
    @Value("${my.props.forth.test7:default}")
    private String test7;
    @Value("${my.props.forth.test8:default}")
    private String test8;
    @Value("${my.props.fifth.test9:default}")
    private String test9;
    @Value("${my.props.fifth.test10:default}")
    private String test10;

    @Value("${replaced.key}")
    private String replacedKey;

    @Value("${my.props.last.test1}")
            private String test11;
    @Value("${my.props.last.test2}")
            private String test12;
    @Value("${my.props.external}")
    private String external;

    TestService(Environment environment) {
        this.environment = environment;
    }

    public void displayProperties() {
        System.out.println("====== Actual Properties: =====");
        String test1 = Optional.ofNullable(environment.getProperty("my.props.first.test1")).orElse("default");
        String test2 = Optional.ofNullable(environment.getProperty("my.props.first.test2")).orElse("default");
        System.out.println("test1: " + test1);
        System.out.println("test2: " + test2);
        System.out.println("test3: " + test3);
        System.out.println("test4: " + test4);
        System.out.println("test5: " + test5);
        System.out.println("test6: " + test6);
        System.out.println("test7: " + test7);
        System.out.println("test8: " + test8);
        System.out.println("test9: " + test9);
        System.out.println("test10: " + test10);
        System.out.println("replaced.key: " + replacedKey);
        System.out.println("add last test1: " + test11);
        System.out.println("add last test2: " + test12);
        System.out.println("external: " + external);
        System.out.println("===================");
    }

    ;
}
