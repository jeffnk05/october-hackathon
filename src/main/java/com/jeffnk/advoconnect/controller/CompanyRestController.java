package com.jeffnk.advoconnect.controller;

import com.jeffnk.advoconnect.model.Company;
import com.jeffnk.advoconnect.repository.CompanyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
