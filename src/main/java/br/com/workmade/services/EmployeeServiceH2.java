package br.com.workmade.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.com.workmade.model.EmployeeModel;
import br.com.workmade.repository.EmployeeRowMapper;

@Component
public class EmployeeServiceH2 {
	@Autowired
	@Qualifier("h2JdbcTemplate")
	private JdbcTemplate h2JDBCTemplate;

	public List<EmployeeModel> getAllEmployees() {
		List<EmployeeModel> employees;
		String sql = "SHOW DATABASES LIKE 'test'";
		employees = h2JDBCTemplate.query(sql, new EmployeeRowMapper());
		return employees;
	}
	
}