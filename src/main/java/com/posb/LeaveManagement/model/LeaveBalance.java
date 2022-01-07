package com.posb.LeaveManagement.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="leave_balance")
public class LeaveBalance {
	@Id
	@SequenceGenerator(name = "leave_balance_sequence", sequenceName = "leave_balance_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leave_balance_sequence")
	private Long id;
	//FK from Employee
	private String ecNumber;
	@NotNull
	@Column(name="rate")
	private Long leaveDaysAccumulationRate;
	private Long daysAccumulated;
	private Long daysTaken;
	private Long leaveDaysBalance;
}
