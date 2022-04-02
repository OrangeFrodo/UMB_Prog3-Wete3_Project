package com.example.demo.api;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// HTTP METHODS
@RequestMapping("/api/v1/employee")
@RestController
@CrossOrigin("*")   // Not a good way
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmloyees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping(path = "{id}")
    public Employee getEmployeeById(@PathVariable("id") UUID id){
        return employeeService.getEmployeeById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEmployeeById(@PathVariable("id") UUID id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "{id}")
    public void updateEmployee(
            @PathVariable("id") UUID id,
            @RequestBody Employee employeeToUpdate){
        employeeService.updateEmployee(id, employeeToUpdate);
    }
}
