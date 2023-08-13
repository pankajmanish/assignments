package com.assignment.controllers;

import com.assignment.entities.Employee;
import com.assignment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(employee));
    }

    @GetMapping("/{employeeID}")
    public ResponseEntity<Employee> getEmployee(@RequestBody Long employeeID){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.get(employeeID));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @RequestMapping("/company/{companyId}")
    public ResponseEntity<List<Employee>> getEmployeesByCompany(@PathVariable("companyId") Long companyId){
        System.out.println("inside getEmployees by Company : " + companyId.toString());
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeesByCompany(companyId));
    }
}
