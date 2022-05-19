package com.ilyassov.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class ProductConfig {
    @PostConstruct
    public void springPostConstruct() {
        System.out.println("Product post construct");
    }

    @PreDestroy
    public void springPreDestroy() {
        System.out.println("Product pre destroy");
    }
}
