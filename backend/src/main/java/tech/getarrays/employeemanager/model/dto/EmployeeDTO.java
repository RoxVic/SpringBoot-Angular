package tech.getarrays.employeemanager.model.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
	private Long id;
	private String name;
	private String email;
	private String jobTitle;
	private String phone;
	private String imageUrl;
	private String employeeCode;

}
