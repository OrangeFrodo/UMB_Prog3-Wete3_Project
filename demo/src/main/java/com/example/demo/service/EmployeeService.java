package com.example.demo.service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    // Injecting to constructor
    @Autowired
    public EmployeeService(@Qualifier("fakeDao") EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public int addEmployee(Employee employee) {
        return employeeDao.insertEmployee(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeDao.selectAllEmployees();
    }

    public Optional<Employee> getEmployeeById(UUID id){
        return employeeDao.selectEmployeeById(id);
    }

    public int deleteEmployee(UUID id){
        return employeeDao.deleteEmployeeById(id);
    }

    public int updateEmployee(UUID id, Employee newEmployee){
        return employeeDao.updateEmployeeById(id, newEmployee);
    }
}
