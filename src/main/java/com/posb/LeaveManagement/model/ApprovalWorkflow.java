package com.posb.LeaveManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="approval_workflow")
public class ApprovalWorkflow {
	@Id
	@SequenceGenerator(name = "approval_workflow_sequence", sequenceName = "approval_workflow_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "approval_workflow_sequence")
	private Long id;
	private String application;
	//FK from departments
	private String section;
	//FR from workflow
	private int step;
	//FK from staff
	private String permanentApprover;
	//FK from staff
	@Nullable
	private String delegatedApprover;
	private Date delegatedFrom;
	private Date delegatedTo;
}
