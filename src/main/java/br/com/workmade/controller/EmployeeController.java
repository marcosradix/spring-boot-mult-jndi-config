package br.com.workmade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.workmade.model.Cargos;
import br.com.workmade.model.EmployeeModel;
import br.com.workmade.services.EmployeeServiceH2;
import br.com.workmade.services.EmployeeServiceMySql;
import br.com.workmade.services.EmployeeServiceOracleXE;;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceMySql employeeServiceMySql;

	/*@Autowired
	private EmployeeServiceOracleXE employeeServiceOracle;*/
	
	@Autowired
	private EmployeeServiceH2 employeeServiceH2;

	@RequestMapping(value = "/mysql", method = RequestMethod.GET)
	public ResponseEntity<List<Cargos>> getEmployee() {
		return new ResponseEntity<>(employeeServiceMySql.getAllEmployees(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/mysql/insert", method = RequestMethod.POST)
	public ResponseEntity<Integer> insert(@RequestParam(name="someValue") String someValue,
			@RequestParam(name="someOtherValue") Integer someOtherValue) {
		return  ResponseEntity.ok().body(employeeServiceMySql.insert(someValue, someOtherValue));
	}

	/*@RequestMapping(value = "/oracle", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeModel>> getEmployeeOracle() {
		return new ResponseEntity<>(employeeServiceOracle.getAllEmployees(), HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/h2", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeModel>> getEmployeeH2() {
		return new ResponseEntity<>(employeeServiceH2.getAllEmployees(), HttpStatus.OK);
	}

}
