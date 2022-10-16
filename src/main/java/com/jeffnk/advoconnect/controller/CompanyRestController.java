package com.jeffnk.advoconnect.controller;

import com.jeffnk.advoconnect.model.Company;
import com.jeffnk.advoconnect.repository.CompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyRestController {

    private final CompanyRepository companyRepository;

    public CompanyRestController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/{id}")
    public Company getCompanyDetails(@PathVariable long id) {
        return companyRepository.findById(id);
    }

    @GetMapping
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyRepository.deleteById(id);
    }
}
