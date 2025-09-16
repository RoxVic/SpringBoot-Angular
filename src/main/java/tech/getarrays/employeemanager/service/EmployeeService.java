package tech.getarrays.employeemanager.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.getarrays.employeemanager.assembler.EmployeeAssembler;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.model.dto.EmployeeDTO;
import tech.getarrays.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeDTO addEmployee(EmployeeDTO dto) {
		dto.setEmployeeCode(UUID.randomUUID().toString());
		Employee entity = employeeRepository.save(EmployeeAssembler.toEntity(dto));
		return EmployeeAssembler.toDTO(entity);
	}

	public List<EmployeeDTO> findAllEmployee(){
		List<Employee> lista = employeeRepository.findAll();
		return EmployeeAssembler.toListDTO(lista);
	}

	public EmployeeDTO updateEmployee(EmployeeDTO dto) {
		Employee entity = employeeRepository.save(EmployeeAssembler.toEntity(dto));
		return EmployeeAssembler.toDTO(entity);
	}

	public EmployeeDTO findEmployeeById(Long id) {

		return EmployeeAssembler.toDTO(
		    employeeRepository.findById(id)
		        .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"))
		);
	}

	public void deleteEmploye(Long id) {
		employeeRepository.deleteById(id);
	}
}
