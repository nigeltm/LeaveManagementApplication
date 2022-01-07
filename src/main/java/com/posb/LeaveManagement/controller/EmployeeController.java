package com.posb.LeaveManagement.controller;

import com.posb.LeaveManagement.model.Employee;
import com.posb.LeaveManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping()
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}


@GetMapping("/{id}")
public Employee getEmployeeById(@PathVariable("id") Long id){
	return employeeService.getEmployee(id);
}

	@PostMapping("/add")
	public Employee addEmployee(@Valid @RequestBody Employee employee){
		return employeeService.addEmployee(employee);
	}

	@PutMapping("/update/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id){
		return  employeeService.updateEmployee(employee,id);
	}

}
