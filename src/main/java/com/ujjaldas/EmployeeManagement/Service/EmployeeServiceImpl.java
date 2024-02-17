package com.ujjaldas.EmployeeManagement.Service;

import java.util.List;

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

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> searchEmployeesByFirstName(String firstName) {
        return employeeRepository.findByFirstNameContainingIgnoreCase(firstName);
    }

    @Override
    public List<Employee> getAllEmployeesSorted(String order) {
        if (order.equalsIgnoreCase("asc")) {
            return employeeRepository.findAllByOrderByFirstNameAsc();
        } else {
            return employeeRepository.findAllByOrderByFirstNameDesc();
        }
    }
}
