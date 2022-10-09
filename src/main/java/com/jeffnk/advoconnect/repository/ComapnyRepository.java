package com.jeffnk.advoconnect.repository;

import com.jeffnk.advoconnect.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComapnyRepository extends CrudRepository<Company, Long> {
}
