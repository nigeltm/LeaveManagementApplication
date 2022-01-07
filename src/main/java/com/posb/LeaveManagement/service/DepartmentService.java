package com.posb.LeaveManagement.service;

import com.posb.LeaveManagement.exception.ResourceNotFoundException;
import com.posb.LeaveManagement.model.Department;
import com.posb.LeaveManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

	@Autowired

	private DepartmentRepository departmentRepository;

	public List<Department> getAllDepartments(){
		return departmentRepository.findAll();
	}

	public Department getDepartment(Long id){

		return departmentRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException(String.format("Department with id %s was not found.",id)));
	}

	public Department addDepartment(Department department){
		return departmentRepository.save(department);
	}

	public Department updateDepartment(Department department, Long id){
		return departmentRepository.save(department);
	}

	public void deleteDepartment(Long id){
		departmentRepository.deleteById(id);
	}
}
