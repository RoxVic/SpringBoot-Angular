package tech.getarrays.employeemanager.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 3615109485119185878L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String email;
	private String jobTitle;
	private String phone;
	private String imageUrl;
	@Column(nullable = false, updatable = false)
	private String employeeCode;

	public Employee() {}

	public Employee(String name, String email, String jobTitle, String phone, String imageUrl, String employeeCode) {
		this.name = name;
		this.email = email;
		this.jobTitle  = jobTitle;
		this.phone = phone;
		this.imageUrl = imageUrl;
		this.employeeCode = employeeCode;
	}
}
