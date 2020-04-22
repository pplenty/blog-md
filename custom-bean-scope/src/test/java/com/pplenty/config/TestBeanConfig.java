package com.pplenty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by yusik on 2020/04/21.
 */
@Configuration
public class TestBeanConfig {

    @Bean
    @Scope("twice")
    public A onlyTwice() {
        return new A();
    }

    static class A {
    }
}
