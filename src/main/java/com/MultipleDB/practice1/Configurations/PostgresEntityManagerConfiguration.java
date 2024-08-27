package com.MultipleDB.practice1.Configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages =  "com.MultipleDB.practice1.Repo",
entityManagerFactoryRef = "postgresEntityManagerBeanFactory",
transactionManagerRef ="transactionManager" )

public class PostgresEntityManagerConfiguration {

		@Bean
		LocalContainerEntityManagerFactoryBean postgresEntityManagerBeanFactory( @Qualifier("postgresSource") DataSource ds) {
			
			LocalContainerEntityManagerFactoryBean fact = new LocalContainerEntityManagerFactoryBean();
			HibernateJpaVendorAdapter dialect = new HibernateJpaVendorAdapter();
			dialect.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
			dialect.setGenerateDdl(true);
			dialect.setShowSql(true);
			
			dialect.setDatabase(Database.POSTGRESQL);
			fact.setDataSource(ds);
			fact.setJpaVendorAdapter(dialect);
			fact.setPackagesToScan("com.MultipleDB.practice1.Entity");
			return fact;	
		}
		
		@Bean
		PlatformTransactionManager transactionManager(@Qualifier("postgresEntityManagerBeanFactory")LocalContainerEntityManagerFactoryBean emfb) {
			return new JpaTransactionManager(emfb.getObject());
		}
		
}
