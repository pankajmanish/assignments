package com.assignment.services.impl;

import com.assignment.entities.Company;
import com.assignment.exceptions.ResourceNotFoundException;
import com.assignment.repositories.CompanyRepository;
import com.assignment.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public Company create(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company with given id not found"));
    }
}
