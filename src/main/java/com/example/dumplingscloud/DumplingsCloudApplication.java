package com.example.dumplingscloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories(basePackages = "com.example.dumplingscloud.core.repo")
public class DumplingsCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(DumplingsCloudApplication.class, args);
    }

}
