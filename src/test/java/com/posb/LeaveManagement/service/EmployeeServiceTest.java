package com.posb.LeaveManagement.service;

import com.posb.LeaveManagement.exception.BadRequestException;
import com.posb.LeaveManagement.model.Employee;
import com.posb.LeaveManagement.repository.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
	@Mock private EmployeeRepository employeeRepository;
	private EmployeeService underTest;

	@BeforeEach
	void setUp(){
		underTest = new EmployeeService(employeeRepository);
	}


	@Test
	void addEmployee() {
		//Given
		Employee employee = new Employee("Nigel", "Mafukidze", "947787V", "Systems Developer", "nmafukidze@posb.co.zw", "password", "Causeway", "IT", true);
		//When
		underTest.addEmployee(employee);
		//THEN
		ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
		verify(employeeRepository).save(employeeArgumentCaptor.capture());
		Employee capturedEmployee = employeeArgumentCaptor.getValue();
		assertThat(capturedEmployee).isEqualTo(employee);
	}

	@Test
	void willThrowWhenEcNumberIsTaken() {
		//Given
		Employee employee = new Employee("Nigel", "Mafukidze", "947787V", "Systems Developer", "nmafukidze@posb.co.zw", "password", "Causeway", "IT", true);
		//When
		//THEN
		underTest.addEmployee(employee);
		given(employeeRepository.selectExistsEcNumber(employee.getEcNumber())).willReturn(true);
		assertThatThrownBy(()->underTest.addEmployee(employee))
				.isInstanceOf(BadRequestException.class)
				.hasMessageContaining("Ec number already exists");
	}

	@Test
	void updateEmployee() {
	}

	@Test
	void getEmployee() {
	}

	@Test
	void canGetAllEmployees() {
		//when
		underTest.getAllEmployees();
		//then
		verify(employeeRepository).findAll();
	}
}