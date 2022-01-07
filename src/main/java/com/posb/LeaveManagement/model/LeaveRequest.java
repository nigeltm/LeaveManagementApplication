package com.posb.LeaveManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="leave_request")
public class LeaveRequest {
	@Id
	@SequenceGenerator(name = "leave_request_sequence", sequenceName = "leave_request_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leave_request_sequence")
	private Long id;
	//FK From Employee
	@OneToOne(targetEntity = Employee.class)
	private String ecNumber;
	@Enumerated(EnumType.STRING)
	private LeaveType leaveType;
	private String daysFrom;
	private String daysTo;
	//To be calculated automatically after accounting for weekends and public holidays
	private int daysTaken;
	private String reason;
	private String contactAddress;
	private String phoneNumber;
	//Auditing, Auto-populated
	private Date createdAt;
	private int status;
	private String section;
	private String recommendedBy;
	private Date recommendedDate;
	private String approvedBy;
	private Date approvedDate;
	private String actionedBy;
	private Date actionedDate;
}