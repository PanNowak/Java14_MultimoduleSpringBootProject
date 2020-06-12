package com.github.pannowak.repojpa;

import com.github.pannowak.springconfigurationprovider.SpringApplicationProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:repo-application.properties")
public class RepoJpaApplication implements SpringApplicationProvider {

    public static void main(String[] args) {
        SpringApplication.run(RepoJpaApplication.class, args);
    }
}
