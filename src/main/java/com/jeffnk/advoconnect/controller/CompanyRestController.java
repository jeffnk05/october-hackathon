package com.jeffnk.advoconnect.controller;

import com.jeffnk.advoconnect.model.Company;
import com.jeffnk.advoconnect.repository.CompanyRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyRestController {

    private final CompanyRepository companyRepository;

    public CompanyRestController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/{id}")
    public EntityModel<Company> getCompanyDetails(@PathVariable long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company doesn't exist"));

        return EntityModel.of(company,
                linkTo(methodOn(CompanyRestController.class).getCompanyDetails(id)).withSelfRel(),
                linkTo(methodOn(CompanyRestController.class).getCompanies()).withRel("companies"));
    }

    @GetMapping
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @PutMapping("/{id}")
    public Company updateCompany(@RequestBody Company newCompany, @PathVariable Long id) {
        return companyRepository.findById(id)
                .map(company -> {
                    company.setName(newCompany.getName());
                    company.setLogo(newCompany.getLogo());
                    company.setSummary(newCompany.getSummary());
                    return companyRepository.save(company);
                })
                .orElseGet(() -> companyRepository.save(newCompany));
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyRepository.deleteById(id);
    }
}
