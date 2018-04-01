package org.itstep.config;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataBaseConfig {

	@Autowired
	JpaVendorAdapter jpaVendorAdapter;

	@Bean
	public DataSource dataSource() {

		HikariConfig config = new HikariConfig();

		HikariDataSource ds;

		config.setJdbcUrl("jdbc:h2:~/sunday_timetable");
		config.setUsername("alex");
		config.setPassword("12345");
		config.setDriverClassName("");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		ds = new HikariDataSource(config);

		return ds.getDataSource();
	}

	@Bean
	public EntityManager entityManager() {
		return entityManagerFactory().createEntityManager();
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource());
		lef.setJpaVendorAdapter(jpaVendorAdapter);
		lef.setPackagesToScan("org.itstep.*");
		return lef.getObject();
	}

	private Properties jpaProperties() {
		Properties prop = new Properties();
		return null;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}
}
