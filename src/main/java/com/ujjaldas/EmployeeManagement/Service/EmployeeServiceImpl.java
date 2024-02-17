package com.ujjaldas.EmployeeManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujjaldas.EmployeeManagement.Entity.Employee;
import com.ujjaldas.EmployeeManagement.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
