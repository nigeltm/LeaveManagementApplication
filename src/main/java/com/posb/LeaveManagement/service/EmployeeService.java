package com.posb.LeaveManagement.service;

import com.posb.LeaveManagement.exception.BadRequestException;
import com.posb.LeaveManagement.exception.ResourceNotFoundException;
import com.posb.LeaveManagement.model.Employee;
import com.posb.LeaveManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee addEmployee(Employee employee){
		Boolean ecNumberExists = employeeRepository.selectExistsEcNumber(employee.getEcNumber());
		if(ecNumberExists && (ecNumberExists!=null)){
			throw new BadRequestException("Ec number "+ employee.getEcNumber()+" already registered.");
		}
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee, Long id){
		return employeeRepository.save(employee);
	}


public Employee getEmployee(Long id){
		return employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException(
						String.format("Employee with id %s was not found",id)));
	}

	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}

}
