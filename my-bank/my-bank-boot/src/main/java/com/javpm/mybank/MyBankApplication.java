package com.javpm.mybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@EnableR2dbcRepositories(considerNestedRepositories = true)
@SpringBootApplication
public class MyBankApplication {

  public static void main(String[] args) {
    SpringApplication.run(MyBankApplication.class, args);
  }
}