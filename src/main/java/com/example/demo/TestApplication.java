package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages={"org.lsi.dao", "org.lsi.entities","org.lsi.metier","org.lsi.services"})  //scanner les packages de l'app
@EntityScan("org.lsi.entities")
@EnableJpaRepositories("org.lsi.dao")
public class TestApplication {

public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		System.out.println("OK");
	}

}
