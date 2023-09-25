package com.example.demo;

import java.util.Optional;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example.service","com.example.controller"})
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
public class ManageUsersAppApplication 
{
	


	public static void main(String[] args) {

		SpringApplication.run(ManageUsersAppApplication.class, args);
	}

	  
	  @Bean
	  public DataSource getDataSource() {
		  return DataSourceBuilder.create().url("jdbc:oracle:thin:@localhost:1521/orclpdb")
				  .username("jr")
				  .password("pass")
				  .build();
		  
	  }

}
