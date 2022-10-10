package com.jeffnk.advoconnect.service;

import com.jeffnk.advoconnect.model.Company;
import com.jeffnk.advoconnect.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company findByCompanyId(long id){
        return companyRepository.findById(id);
    }
}
