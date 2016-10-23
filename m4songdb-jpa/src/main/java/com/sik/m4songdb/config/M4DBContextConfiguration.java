/**
 * 
 */
package com.sik.m4songdb.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.sik.m4songdb.repo.M4SongRepository;

/**
 * @author sik
 *
 */
@Configuration
@EnableJpaRepositories(basePackageClasses = M4SongRepository.class)
public class M4DBContextConfiguration {

	public static final String ENTITY_MANAGER = "m4EntityManagerFactory";
	public static final String TRANSACTION_MANAGER = "m4TransactionManager";
	
	@Autowired
	@Qualifier("m4DataSource")
	private DataSource ds;
	
	@Autowired
	@Qualifier("m4HibernateResource")
	private Resource propResource;
	
	@Bean(name = ENTITY_MANAGER)
	public LocalContainerEntityManagerFactoryBean rwEntityManager() throws IOException {
		final Properties props = new Properties();
		props.load(this.propResource.getInputStream());
		
		final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(this.ds);
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setJpaProperties(props);
		factoryBean.setJpaDialect(new HibernateJpaDialect());
		//factoryBean.setPackagesToScan("com.sik.m4songdb.jpa");
		
		return factoryBean;
	}
	
	@Bean(name = TRANSACTION_MANAGER)
	public PlatformTransactionManager txManager() throws IOException {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(rwEntityManager().getObject());
		
		return transactionManager;
	}
}
