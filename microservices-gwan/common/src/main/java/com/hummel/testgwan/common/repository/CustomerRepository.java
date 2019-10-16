package com.hummel.testgwan.common.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hummel.testgwan.common.models.Customer;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Optional<Customer> findByName(@Param("name") String name);
}