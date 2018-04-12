package com.senecasoap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senecasoap.entity.Customer;
import com.senecasoap.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public void saveNewCustomer(Customer customer){
		customerRepository.save(customer);
	}
	
	public boolean getCustomerID(Long id){
		try {
			customerRepository.findOne(id).getCustomerId();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
		
	}

}
