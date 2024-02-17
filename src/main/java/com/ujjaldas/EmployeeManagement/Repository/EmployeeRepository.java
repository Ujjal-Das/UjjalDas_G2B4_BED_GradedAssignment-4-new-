package com.ujjaldas.EmployeeManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ujjaldas.EmployeeManagement.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
