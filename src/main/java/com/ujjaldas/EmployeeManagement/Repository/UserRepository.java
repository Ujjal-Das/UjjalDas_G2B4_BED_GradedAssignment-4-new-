package com.ujjaldas.EmployeeManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ujjaldas.EmployeeManagement.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}