package com.posb.LeaveManagement.repository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@AllArgsConstructor
@DataJpaTest
class EmployeeRepositoryTest {
	@Autowired
	private EmployeeRepository employeeRepository;

}