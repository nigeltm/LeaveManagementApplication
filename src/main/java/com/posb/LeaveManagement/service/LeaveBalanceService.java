package com.posb.LeaveManagement.service;

import com.posb.LeaveManagement.exception.ResourceNotFoundException;
import com.posb.LeaveManagement.model.LeaveBalance;
import com.posb.LeaveManagement.repository.LeaveBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveBalanceService {
	@Autowired
	private LeaveBalanceRepository leaveBalanceRepository;

	public LeaveBalanceService(LeaveBalanceRepository leaveBalanceRepository) {
		this.leaveBalanceRepository = leaveBalanceRepository;
	}

	public List<LeaveBalance> getAllLeaveBalances(){

		return leaveBalanceRepository.findAll();
	}

	public List<LeaveBalance> getLeaveBalancesByEcNumber(String ecNumber){
		return leaveBalanceRepository.findAll();
	}

	public LeaveBalance addLeaveBalance(LeaveBalance leaveBalance){

		return leaveBalanceRepository.save(leaveBalance);
	}

	public LeaveBalance updateLeaveBalance(LeaveBalance leaveBalance,String ecNumber,Long id){
		return leaveBalanceRepository.save(leaveBalance);
	}

	public LeaveBalance getLeaveBalance(Long id){
		return leaveBalanceRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException(String.format("Leave balance for id %s was not found",id)));
	}

	public void deleteLeaveBalance(Long id){
		leaveBalanceRepository.deleteById(id);
	}
}
