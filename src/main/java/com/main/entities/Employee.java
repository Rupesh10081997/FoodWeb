package com.main.entities;

import com.main.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Employee  extends AbstractEntity{
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
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="department_id")
	private Department department;
}
