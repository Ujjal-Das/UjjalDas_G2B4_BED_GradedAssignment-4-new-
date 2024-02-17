package com.ujjaldas.EmployeeManagement.Service;

import java.util.List;

import com.ujjaldas.EmployeeManagement.Entity.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee employee);
	List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee employee);
    boolean deleteEmployee(Long id);
    List<Employee> searchEmployeesByFirstName(String firstName);
    List<Employee> getAllEmployeesSorted(String order);

}