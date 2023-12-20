package com.artem.springbootjpa.service;

import com.artem.springbootjpa.dao.EmployeeRepository;
import com.artem.springbootjpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(int id , Employee employee) {
        Employee emp = employeeRepository.getReferenceById(id);
        emp.setDepartment(employee.getDepartment());
        emp.setName(employee.getName());
        emp.setSurname(employee.getSurname());
        emp.setSalary(employee.getSalary());
        return employeeRepository.save(emp);
    }
    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> employees = employeeRepository.findAllByName(name);
        return employees;
    }
}
