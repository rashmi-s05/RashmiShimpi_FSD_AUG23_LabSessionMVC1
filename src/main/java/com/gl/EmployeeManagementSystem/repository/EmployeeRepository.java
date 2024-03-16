package com.gl.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gl.EmployeeManagementSystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
