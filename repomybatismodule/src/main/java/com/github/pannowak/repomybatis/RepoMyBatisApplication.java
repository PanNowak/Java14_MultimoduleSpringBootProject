package com.github.pannowak.repomybatis;

import com.github.pannowak.springconfigurationprovider.SpringApplicationProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication

@PropertySource("classpath:repo-application.properties")
public class RepoMyBatisApplication implements SpringApplicationProvider {

    public static void main(String[] args) {
        SpringApplication.run(RepoMyBatisApplication.class, args);
    }
}
