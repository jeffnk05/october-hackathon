package com.jeffnk.advoconnect.controller;

import com.jeffnk.advoconnect.CompanyModelAssembler;
import com.jeffnk.advoconnect.model.Company;
import com.jeffnk.advoconnect.repository.CompanyRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/company")
public class CompanyRestController {

    private final CompanyRepository companyRepository;

    private final CompanyModelAssembler assembler;
    public CompanyRestController(CompanyRepository companyRepository, CompanyModelAssembler assembler) {
        this.companyRepository = companyRepository;
        this.assembler = assembler;
    }

    @GetMapping("/{id}")
    public EntityModel<Company> getCompanyDetails(@PathVariable long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company doesn't exist"));

        return assembler.toModel(company);
    }

    @GetMapping
    public CollectionModel<EntityModel<Company>> getCompanies() {
        List<EntityModel<Company>> companies = companyRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(companies,
                linkTo(methodOn(CompanyRestController.class).getCompanies()).withSelfRel());
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
