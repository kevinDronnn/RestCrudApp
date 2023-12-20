package com.artem.springbootjpa.controller;

import com.artem.springbootjpa.entity.Employee;
import com.artem.springbootjpa.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable int id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id , @RequestBody Employee employee) {
        return employeeService.updateEmployee(id,employee);
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee was deleted, id=" + id;
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name){
        return employeeService.findAllByName(name);
    }

}
