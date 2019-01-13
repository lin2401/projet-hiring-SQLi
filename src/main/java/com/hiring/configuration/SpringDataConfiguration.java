package com.hiring.configuration;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan("com.hiring")
@PropertySource("classpath:application.properties")

public class SpringDataConfiguration {

	@Value("${db.password}")
	private String PropertyNameDatabasePassword;

	@Value("${db.driver}")
	private String PropertyNameDatabaseDriver;

	@Value("${db.url}")
	private String PropertyNameDatabaseUrl;

	@Value("${db.username}")
	private String PropertyNameDatabaseUsername;

	@Value("${hibernate.dialect}")
	private String PropertyNameHibernateDialect;

	@Value("${hibernate.show_sql}")
	private String PropertyNameHibernateShowSql;

	@Value("${entitymanager.packages.to.scan}")
	private String PropertyNameEntitymanagerPackagesToScan;

	@Resource
	private Environment env;

	// Base de donnée - Dialecte utilisée - C'est le point d'entrée à la base de
	// donnée
	// Informations sur la bdd / user / password et url
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.PropertyNameDatabaseDriver);

		dataSource.setUrl(this.PropertyNameDatabaseUrl);
		dataSource.setUsername(this.PropertyNameDatabaseUsername);
		dataSource.setPassword(this.PropertyNameDatabasePassword);

		return dataSource;
	}

	// C'est le générateur d'Entity Manager
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//		entityManagerFactoryBean.setDataSource(this.dataSource());
//		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
//		entityManagerFactoryBean
//				.setPackagesToScan(this.env.getRequiredProperty(this.PropertyNameEntitymanagerPackagesToScan));
//
//		entityManagerFactoryBean.setJpaProperties(this.hibProperties());
//
//		return entityManagerFactoryBean;
//	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(this.dataSource()); //
		sessionFactoryBean.setHibernateProperties(this.hibProperties()); // Les propriétes hibernate
		sessionFactoryBean.setPackagesToScan("com.hiring.entities"); // LE package des entites
		return sessionFactoryBean;
	}

	// Cela permet d'activer la fonction SHOW SQL => Ca permet pour chaque requête
	// HQL de montrer l'équivalent en SQL
	// Egalement, celà permet d'utiliser le dialecte Hibernate pour convertir le HQL
	// en SQL
	// C'est différent du driver qui permet d'établir la connexion alors que le
	// dialecte permet de faire la transcription.
	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(this.PropertyNameHibernateDialect, this.PropertyNameHibernateDialect);
		properties.put(this.PropertyNameHibernateShowSql, this.PropertyNameHibernateShowSql);
//		properties.put("hibernate.hbm2ddl.auto",
//				this.env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		return transactionManager;
	}

	// C'est
	@Bean
	public HibernateTemplate template() {
		HibernateTemplate template = new HibernateTemplate((SessionFactory) this.sessionFactory());
		return template;
	}

}
