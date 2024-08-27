package com.MultipleDB.practice1.Configurations;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages =  "com.MultipleDB.practice1.ProductRepository",
entityManagerFactoryRef = "sqlEntityMaagerFactory", transactionManagerRef ="sqlTransactionManager")
public class mySqlEntityManagerConfiguration {

		@Bean
		LocalContainerEntityManagerFactoryBean sqlEntityMaagerFactory( @Qualifier("mySQLSource") DataSource ds) {
			
			LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
			emf.setDataSource(ds);
			emf.setPackagesToScan("com.MultipleDB.practice1.ProductEntity");
		
			emf.setPersistenceProvider(new HibernatePersistenceProvider());
			return emf;
			
		}
		
		@Bean
		PlatformTransactionManager sqlTransactionManager(@Qualifier("sqlEntityMaagerFactory") LocalContainerEntityManagerFactoryBean emfb) {
			return new JpaTransactionManager(emfb.getObject());
		}
}
