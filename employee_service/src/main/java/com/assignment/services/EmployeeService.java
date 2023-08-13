package com.assignment.services;

import com.assignment.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);
    List<Employee> getAll();
    Employee get(Long employeeId);
    List<Employee> getEmployeesByCompany(long companyId);


}
