package com.posb.LeaveManagement.repository;

import com.posb.LeaveManagement.model.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance,Long> {
}
