package com.MultipleDB.practice1.Configurations;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DbConfig {
	
		

		@ConfigurationProperties("spring.postgres.datasource")
		@Bean
		DataSourceProperties postgresDB() {
			
			return new DataSourceProperties();
		}
		
		
		@Bean
		DataSource postgresSource() {
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setUsername(postgresDB().getUsername());
			ds.setUrl(postgresDB().getUrl());
			ds.setPassword(postgresDB().getPassword());
			ds.setDriverClassName("org.postgresql.Driver");

		
//			ds.setDriverClassName(postgresDB().getDriverClassName());
			return ds;

		}
		
		@ConfigurationProperties("spring.mysql.datasource")
		@Bean
		DataSourceProperties mysqlDb() {
			
			return new DataSourceProperties();
		}
		
		@Bean
		DataSource mySQLSource() {	
			return mysqlDb().initializeDataSourceBuilder().build();
		}
		
}
