package com.david.Customer.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.Customer.Entity.Customer;
import com.david.Customer.Repository.ICustomer;

@Service
public class CustomerImplementation{
	
	
	@Autowired
	private ICustomer customer;
	
	
	
	public void addCustomer(Customer customerex) {
		this.customer.save(customerex);
	}
	
	
	public List<Customer> getListCustomer(){
		return this.customer.findAll();
	}
	


	public Customer getById(Long id) {
		return this.customer.findById(id).orElse(null);
	}

	

	public void deleteById(Long id) {
		this.customer.deleteById(id);
		
	}
	



}
