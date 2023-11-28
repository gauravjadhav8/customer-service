package com.gaurav.customer.service.service;

import java.util.List;

import com.gaurav.customer.service.entities.CustomerEntity;
import com.gaurav.customer.service.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.customer.service.exception.CustomerException;

@Service
public class CustomerDataService {
	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerEntity> getListOfAllCustomers() {
		return this.customerRepository.findAll();
	}

	public CustomerEntity getCustomerById(final Long id) {
		return this.customerRepository.findById(id).orElseThrow(() -> new CustomerException("Customer not found with id: " + id));
	}

	public CustomerEntity createNewCustomer(final CustomerEntity c) {
		return this.customerRepository.save(c);
	}

	public CustomerEntity updateCustomer(final Long id, final CustomerEntity c) {
		if (!this.customerRepository.existsById(id)) {
			throw new CustomerException("Customer not found with id: " + id);
		}
		c.setId(id);
		return this.customerRepository.save(c);
	}

	public void deleteCustomer(final Long id) {
		if (!this.customerRepository.existsById(id)) {
			throw new CustomerException("Customer not found with id: " + id);
		}
		this.customerRepository.deleteById(id);
	}
}