package com.example.demo.dao;

import com.example.demo.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Operations allowed
public interface EmployeeDao {
    int insertEmployee(UUID id, Employee employee);

    default int insertEmployee(Employee employee){
        UUID id = UUID.randomUUID();
        return insertEmployee(id, employee);
    }

    List<Employee> selectAllEmployees();

    // Methods
    Optional<Employee> selectEmployeeById(UUID id);
    int deleteEmployeeById(UUID id);
    int updateEmployeeById(UUID id, Employee employee);
}
