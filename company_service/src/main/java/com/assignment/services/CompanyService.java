package com.assignment.services;

import com.assignment.entities.Company;
import java.util.List;

public interface CompanyService {
    Company create(Company company);
    List<Company> getAll();

    Company getCompany(Long id);

}
