package com.posb.LeaveManagement.service;

import com.posb.LeaveManagement.exception.ResourceNotFoundException;
import com.posb.LeaveManagement.model.ApprovalWorkflow;
import com.posb.LeaveManagement.repository.ApprovalWorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalWorkflowService {
	@Autowired
	private ApprovalWorkflowRepository approvalWorkflowRepository;

	public ApprovalWorkflowService(ApprovalWorkflowRepository approvalWorkflowRepository) {
		this.approvalWorkflowRepository = approvalWorkflowRepository;
	}

	public List<ApprovalWorkflow> getApprovalWorkflows(){
		return approvalWorkflowRepository.findAll();
	}

	public ApprovalWorkflow getApprovalWorkflow(Long id){

		return approvalWorkflowRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException(String.format("Approval Workflow with id %s was not found.",id)));
	}

	public  ApprovalWorkflow createApprovalWorkflow(ApprovalWorkflow approvalWorkflow){
		return approvalWorkflowRepository.save(approvalWorkflow);
	}

	public  ApprovalWorkflow updateApprovalWorkflow(ApprovalWorkflow approvalWorkflow, Long id){
		return approvalWorkflowRepository.save(approvalWorkflow);
	}
	public void deleteApprovalWorkflow(Long id){
		approvalWorkflowRepository.deleteById(id);
	}
}
