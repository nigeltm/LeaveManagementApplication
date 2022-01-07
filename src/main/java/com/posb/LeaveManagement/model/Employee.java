package com.posb.LeaveManagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name="staff")
public class Employee {
	@Id
	@SequenceGenerator(name="staff_sequence",sequenceName = "staff_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "staff_sequence")
	private Long id;
	@NotNull(message = "First name field cannot be null.")
	private String firstName;
	@NotNull(message = "Last name field cannot be null.")
	private String lastName;
	@NotNull(message = "EC number field cannot be null.")
	private String ecNumber;
	@NotNull(message = "Designation field cannot be null.")
	private String designation;
	private String email;
	@Size(min = 5,max = 50, message = "Password length must be between 5 and 50 characters.")
	private String password;
	@NotNull(message = "Station field cannot be null.")
	private String station;
	//FK from Dept
	@NotNull(message = "Department field cannot be null.")
	private String department;
	private boolean isActive;

	public Employee(String firstName, String lastName, String ecNumber, String designation, String email, String password, String station, String department, boolean isActive) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ecNumber = ecNumber;
		this.designation = designation;
		this.email = email;
		this.password = password;
		this.station = station;
		this.department = department;
		this.isActive = isActive;
	}
}
