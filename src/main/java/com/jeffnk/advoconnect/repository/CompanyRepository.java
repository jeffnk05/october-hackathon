package com.jeffnk.advoconnect.repository;

import com.jeffnk.advoconnect.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    public Company findById(long id);
}
