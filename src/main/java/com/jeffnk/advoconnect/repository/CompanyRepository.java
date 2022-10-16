package com.jeffnk.advoconnect.repository;

import com.jeffnk.advoconnect.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    public Company findById(long id);
}
