/**
 * 
 */
package com.sik.m4songdb.test;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.sik.m4songdb.config.M4DBContextConfiguration;
import com.sik.m4songdb.repo.M4SongRepository;

/**
 * @author sik
 *
 */
@Configuration
@Import(M4DBContextConfiguration.class)
public class TestSongServiceContextConfiguration {
	@Bean
	public Resource m4HibernateResource() {
		return new ClassPathResource("hibernate.properties");
	}
	
	@Bean
	public DataSource m4Datasource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
	}
		
	
}
