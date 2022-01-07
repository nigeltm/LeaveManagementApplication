package com.posb.LeaveManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="workflow")
public class Workflow {
	@Id
	@SequenceGenerator(name = "workflow", sequenceName = "workflow")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workflow")
	private Long id;
	private String requestType;
	//FK from Department
	private String section;
	private int step;
}
