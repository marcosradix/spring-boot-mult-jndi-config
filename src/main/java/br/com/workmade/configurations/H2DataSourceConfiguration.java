package br.com.workmade.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
public class H2DataSourceConfiguration {

	@Value("${spring.h2.datasource.jndi-name}")
	private String h2JNDIName;

	@Bean(destroyMethod = "")
	public DataSource OracleDataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		return dataSourceLookup.getDataSource(h2JNDIName);
	}

	@Bean()
	@Qualifier("h2JdbcTemplate")
	public JdbcTemplate oracleJdbcTemplate() {
		return new JdbcTemplate(OracleDataSource());
	}
}