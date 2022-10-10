package com.jeffnk.advoconnect.controller;

import com.jeffnk.advoconnect.model.Company;
import com.jeffnk.advoconnect.service.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyRestController {

    private final CompanyService companyService;

    public CompanyRestController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{id}")
    public Company getCompanyDetails(@PathVariable long id) {
        return companyService.findByCompanyId(id);
    }

}
