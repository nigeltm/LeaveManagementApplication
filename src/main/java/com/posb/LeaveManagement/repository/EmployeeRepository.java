package com.posb.LeaveManagement.repository;

import com.posb.LeaveManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	@Query( value = "SELECT CASE WHEN COUNT(ec_number) > 0 THEN 'true' ELSE 'false' END FROM staff  WHERE ec_number = ?1",
			nativeQuery = true)
 Boolean selectExistsEcNumber(String ecNumber);
}
