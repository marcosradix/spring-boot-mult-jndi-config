package br.com.workmade.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

//@Configuration //comentei pois não tenho o oracle
public class OracleDataSourceConfiguration {

	@Value("${spring.Oracle.datasource.jndi-name}")
	private String oracleJNDIName;

	@Bean(destroyMethod = "")
	public DataSource OracleDataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		return dataSourceLookup.getDataSource(oracleJNDIName);
	}

	@Bean()
	@Qualifier("oracleJdbcTemplate")
	public JdbcTemplate oracleJdbcTemplate() {
		return new JdbcTemplate(OracleDataSource());
	}
}