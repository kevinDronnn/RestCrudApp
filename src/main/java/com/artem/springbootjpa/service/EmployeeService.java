package com.artem.springbootjpa.service;


import com.artem.springbootjpa.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Optional<Employee> getEmployeeById(int id);
    public void deleteEmployee(int id);
    public Employee updateEmployee(int id ,Employee employee);
    public List<Employee> findAllByName(String name);
}
