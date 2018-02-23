package com.kelltontech.service.web.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kelltontech.service.repository.CompanyRepository;
import com.kelltontech.service.repository.entities.Company;
import com.kelltontech.service.repository.entities.Contact;
import com.kelltontech.service.repository.entities.Product;

@RestController
public class DemoController {

	@Autowired
	CompanyRepository companyRepo;

	@RequestMapping(value = "/sample/data", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getApplicationDetails() {

		// clear database
		System.out.println("==========Delete all company entities==========");
		companyRepo.deleteAll();

		// save Documents to MongoDB
		System.out.println("==========Save list of company entities==========");
		companyRepo.save(Arrays.asList(
				// Apple company & products
				new Company(1, "Apple",

						// list of products
						Arrays.asList(new Product("A-123", "Iphone 7", "Price: 649.00 USD & FREE shipping"),
								new Product("A-456", "IPadPro", "Price: 417.67 USD & FREE shipping")),

						// contact
						new Contact("Cupertino, CA 95014", "1-408-996-1010")),

				// Samsung company & products
				new Company(2, "Samsung",

						// list of products
						Arrays.asList(new Product("S-012", "GalaxyJ7", "Price: 219.00 USD & FREE shipping"),
								new Product("S-456", "GalaxyTabA", "Price: 299.99 USD & FREE shipping")),

						// contact
						new Contact("Seocho District, Seoul, South Korea", "+82-2-2053-3000"))));
		// initial List Companies variable
		List<Company> companies = null;

		// fetch all documents
		System.out.println("==========Fetch aLL companies:==========");
		companies = companyRepo.findAll();
		companies.forEach(System.out::println);

		// find Company by name
		/*
		 * System.out.println("==========Find a company by name:=========="); companies
		 * = companyRepo.findByName("Samsung"); companies.forEach(System.out::println);
		 */

		// find Company by address
		System.out.println("==========Find a company by address:==========");
		companies = companyRepo.findByAddress("Cupertino, CA 95014");
		companies.forEach(System.out::println);

		return null;

	}

}
