package com.ilyassov;

import com.ilyassov.config.ProductConfig;
import com.ilyassov.config.UserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@EnableAspectJAutoProxy
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@Import({ UserConfig.class, ProductConfig.class })
public class FinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalApplication.class, args);
    }

}
