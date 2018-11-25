package br.com.workmade.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.workmade.model.Cargos;
import br.com.workmade.repository.CargosRowMapper;


@Component
public class EmployeeServiceMySql {
	@Autowired
	@Qualifier("mySQLJdbcTemplate")
	private JdbcTemplate mySqlJDBCTemplate;

	public List<Cargos> getAllEmployees() {
		List<Cargos> employees;
		String sql = "SELECT * FROM CARGOS";
		employees = mySqlJDBCTemplate.query(sql, new CargosRowMapper());
		return employees;
	}
	
	   @Transactional 
	   public int insert(String someValue, Integer someOtherValue) {
	      return mySqlJDBCTemplate.update("INSERT INTO cargos(nome, id_departamento_fk) VALUES(?,?)", someValue, someOtherValue);
	   }
}