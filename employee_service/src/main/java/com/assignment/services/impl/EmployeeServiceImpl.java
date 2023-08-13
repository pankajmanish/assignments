package com.assignment.services.impl;

import com.assignment.entities.Employee;
import com.assignment.exceptions.ResourceNotFoundException;
import com.assignment.repositories.EmployeeRepository;
import com.assignment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee get(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee with given id not found!"));
    }

    @Override
    public List<Employee> getEmployeesByCompany(long companyId) {
        return employeeRepository.findAll().stream().filter(employee -> employee.getCompanyId().equals(companyId)).collect(Collectors.toList());
    }
}
