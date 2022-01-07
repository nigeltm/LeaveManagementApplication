package com.posb.LeaveManagement.service;

import com.posb.LeaveManagement.exception.ResourceNotFoundException;
import com.posb.LeaveManagement.model.Workflow;
import com.posb.LeaveManagement.repository.WorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowService {
	@Autowired
	private WorkflowRepository workflowRepository;

	public WorkflowService(WorkflowRepository workflowRepository) {
		this.workflowRepository = workflowRepository;
	}

	public Workflow createWorkFlow(Workflow workflow){
		return workflowRepository.save(workflow);
	}

	public Workflow getWorkflow(Long id){

		return workflowRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException(String.format("Workflow with id %s was not found.",id)));
	}

	public Workflow updateWorkflow(Workflow workflow, Long id){
		return  workflowRepository.save(workflow);
	}
	public void deleteWorkflow(Long id){
		workflowRepository.deleteById(id);
	}
}
