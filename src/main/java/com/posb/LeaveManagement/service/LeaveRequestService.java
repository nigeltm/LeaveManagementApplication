package com.posb.LeaveManagement.service;

import com.posb.LeaveManagement.exception.ResourceNotFoundException;
import com.posb.LeaveManagement.model.LeaveRequest;
import com.posb.LeaveManagement.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {
	@Autowired
	private LeaveRequestRepository leaveRequestRepository;

	public LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
		this.leaveRequestRepository = leaveRequestRepository;
	}

	public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest){
		return leaveRequestRepository.save(leaveRequest);
	}

	public LeaveRequest updateLeaveRequest(LeaveRequest leaveRequest, Long id){
		//You can not update a leave request that has already been actioned by the next level
		if(leaveRequest.getStatus()!=0){
			throw new IllegalStateException("You can not update this request.");
		}
		return leaveRequestRepository.save(leaveRequest);
	}
	public LeaveRequest getLeaveRequest(Long id){
		return leaveRequestRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException(String.format("Leave request with id %s was not found.",id)));
	}

	public List<LeaveRequest> getAllLeaveRequests(){
			return leaveRequestRepository.findAll();
	}

	public void deleteLeaveRequest(Long id){
		leaveRequestRepository.deleteById(id);
	}

	//Non Supervisor staff cannot view colleagues` Leave Requests
	public List<LeaveRequest> getLeaveRequestByEcNumber(String ecNumber){
		return leaveRequestRepository.findAll();
	}

	//Section Heads should be able to view LeaveRequests for their section only
	public List<LeaveRequest> getLeaveRequestBySection(String section){
		return leaveRequestRepository.findAll();
	}
}
