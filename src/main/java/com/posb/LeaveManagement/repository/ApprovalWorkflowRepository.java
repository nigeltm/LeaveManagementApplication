package com.posb.LeaveManagement.repository;

import com.posb.LeaveManagement.model.ApprovalWorkflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalWorkflowRepository extends JpaRepository<ApprovalWorkflow,Long> {
}
