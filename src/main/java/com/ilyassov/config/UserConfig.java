package com.ilyassov.config;

import com.ilyassov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

import java.sql.SQLException;

@Configuration
@PropertySource("classpath:application.properties")
public class UserConfig {
    private final UserService userService;

    @Autowired
    public UserConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean(initMethod = "", destroyMethod = "")
    public void getUsers() throws SQLException {
        userService.getUsers().forEach(users -> System.out.println(users.toString()));
    }
}
