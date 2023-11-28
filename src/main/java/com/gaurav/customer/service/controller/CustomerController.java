package com.gaurav.customer.service.controller;

import java.util.List;

import com.gaurav.customer.service.entities.CustomerEntity;
import com.gaurav.customer.service.service.CustomerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping(value = "/customers")
@Api(tags = {"Customer"}, value = "CRUD on Customer API", description = "CRUD on CustomerEntity")
public class CustomerController {

	@Autowired
	private CustomerDataService customerDataService;

	@GetMapping
	public List<CustomerEntity> getListOfAllCustomers() {
		return this.customerDataService.getListOfAllCustomers();
	}

	@GetMapping("/{id}")
	public CustomerEntity getCustomerById(@PathVariable final Long id) {
		return this.customerDataService.getCustomerById(id);
	}

	@PostMapping
	public CustomerEntity createNewCustomer(@RequestBody final CustomerEntity customer) {
		return this.customerDataService.createNewCustomer(customer);
	}

	@PutMapping("/{id}")
	public CustomerEntity updateExistingCustomer(@PathVariable final Long id, @RequestBody final CustomerEntity customer) {
		return this.customerDataService.updateCustomer(id, customer);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable final Long id) {
		this.customerDataService.deleteCustomer(id);
		return ResponseEntity.noContent().build();
	}
}