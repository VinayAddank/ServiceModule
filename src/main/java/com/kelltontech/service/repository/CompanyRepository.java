package com.kelltontech.service.repository;

import org.springframework.stereotype.Repository;

import com.kelltontech.service.repository.entities.Company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Spring Data MongoDB repository for the Company entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {

	// @Autowired
	// private Company company;

	// @Query
	// List<Company> findByName(String cname);

	@Query("{'contact.address': ?0}")
	List<Company> findByAddress(String address);
}
