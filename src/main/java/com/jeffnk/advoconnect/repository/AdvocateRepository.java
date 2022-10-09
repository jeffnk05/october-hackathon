package com.jeffnk.advoconnect.repository;

import com.jeffnk.advoconnect.model.Advocate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvocateRepository extends CrudRepository<Advocate, Long> {
}
