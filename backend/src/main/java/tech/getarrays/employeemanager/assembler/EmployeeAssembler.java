package tech.getarrays.employeemanager.assembler;

import java.util.ArrayList;
import java.util.List;

import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.model.dto.EmployeeDTO;

public class EmployeeAssembler {
	public static Employee toEntity(EmployeeDTO dto) {
		Employee entity = new Employee();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setJobTitle(dto.getJobTitle());
		entity.setImageUrl(dto.getImageUrl());
		entity.setEmployeeCode(dto.getEmployeeCode());
		return entity;
	}

	public static EmployeeDTO toDTO(Employee entity) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		dto.setJobTitle(entity.getJobTitle());
		dto.setImageUrl(entity.getImageUrl());
		dto.setEmployeeCode(entity.getEmployeeCode());
		return dto;
	}

	public static List<EmployeeDTO> toListDTO(List<Employee> listaEntity){
		List<EmployeeDTO> listaDTO = new ArrayList<EmployeeDTO>();
		for(Employee entity: listaEntity) {
			listaDTO.add(toDTO(entity));
		}
		return listaDTO;
	}
}
