package com.example.demo.dao;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// This class needs to be injected to other classes
@Repository("fakeDao") // Multiple implementations
public class FakeEmployeeAccessService implements EmployeeDao{

    private static List<Employee> DB = new ArrayList<>();

    @Override
    public int insertEmployee(UUID id, Employee employee) {
        DB.add(new Employee(id, employee.getName(), employee.getWorkOurs(), employee.getProject()));
        return 1;
    }

    @Override
    public List<Employee> selectAllEmployees() {
        return DB;
    }

    // Search if employee is in database
    @Override
    public Optional<Employee> selectEmployeeById(UUID id) {
        return DB.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteEmployeeById(UUID id) {
        Optional<Employee> employeeMaybe = selectEmployeeById(id);
        if (employeeMaybe.isEmpty()){
            return 0;
        }
        DB.remove(employeeMaybe.get());
        return 1;
    }

    @Override
    public int updateEmployeeById(UUID id, Employee employee) {
        return selectEmployeeById(id)
                .map(employee1 -> {
                    int indexOfEmployeeToUpdate = DB.indexOf(employee1);
                    if (indexOfEmployeeToUpdate >= 0) {
                        DB.set(indexOfEmployeeToUpdate, new Employee(id, employee.getName(), employee.getWorkOurs(), employee.getProject()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
