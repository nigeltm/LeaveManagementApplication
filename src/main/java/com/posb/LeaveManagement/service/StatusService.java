package com.posb.LeaveManagement.service;

import com.posb.LeaveManagement.model.Status;
import com.posb.LeaveManagement.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
	@Autowired
	private StatusRepository statusRepository;

	public StatusService(StatusRepository statusRepository) {
		this.statusRepository = statusRepository;
	}

	public List<Status> getAllStatuses(){
		return statusRepository.findAll();
	}
	public Status createStatus(Status status){
		return statusRepository.save(status);
	}
	public Status updateStatus(Status status, int id){
		return statusRepository.save(status);
	}

	public void deleteStatus(int id){
		statusRepository.deleteById(id);
	}
}
