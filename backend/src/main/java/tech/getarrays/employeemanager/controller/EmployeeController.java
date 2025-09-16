package tech.getarrays.employeemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.getarrays.employeemanager.model.dto.EmployeeDTO;
import tech.getarrays.employeemanager.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/all")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
		List<EmployeeDTO> employees =  employeeService.findAllEmployee();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id){
		EmployeeDTO employee =  employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employee){
		EmployeeDTO newEmployee =  employeeService.addEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employee){
		EmployeeDTO updateEmployee =  employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletEmployee(@PathVariable("id") Long id){
		employeeService.deleteEmploye(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
