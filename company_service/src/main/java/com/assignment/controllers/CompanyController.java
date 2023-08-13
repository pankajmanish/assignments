package com.assignment.controllers;

import com.assignment.entities.Company;
import com.assignment.services.CompanyService;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompany(@PathVariable Long companyId)
    {
        Company company = companyService.getCompany(companyId);

        try {
            List employeeList = this.restTemplate.getForObject("http://localhost:8082/employee/company/" + company.getCompanyId().toString(), List.class);
            company.setEmployeeList(employeeList);
        }
        catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(company);
        }

        return ResponseEntity.ok(company);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAll()
    {
        List<Company> companies = companyService.getAll();
        return ResponseEntity.ok(companies);
        //return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompany(companyId));
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company)
    {
        Company company1 = companyService.create(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(company1);
    }

}
