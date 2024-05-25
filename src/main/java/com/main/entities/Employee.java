package com.main.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	@NotNull(message="Name do not null")
	private String name;
	private String contactNo;
	private String email;
	@NotNull(message="Username do not null")
	private String userName;
	@NotNull(message="Password do not null")
	private String password;
	private String status="V";
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="department_id")
	private Department department;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", contactNo=" + contactNo + ", email=" + email
				+ ", userName=" + userName + ", password=" + password + ", status=" + status + ", department="
				+ department + "]";
	}

	public Employee(Long employeeId, @NotNull(message = "Name do not null") String name, String contactNo, String email,
			@NotNull(message = "Username do not null") String userName,
			@NotNull(message = "Password do not null") String password, String status, Department department) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.contactNo = contactNo;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.department = department;
	}
	
}
