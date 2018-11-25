package br.com.workmade.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.com.workmade.model.EmployeeModel;
import br.com.workmade.repository.EmployeeRowMapper;

@Component
public class EmployeeServiceOracleXE {
	@Autowired
	@Qualifier("oracleJdbcTemplate")
	private JdbcTemplate oracleJdbcTemplate;

	public List<EmployeeModel> getAllEmployees() {
		List<EmployeeModel> employees;
		String sql = "Select * from Employee";
		employees = oracleJdbcTemplate.query(sql, new EmployeeRowMapper());
		return employees;
	}
}