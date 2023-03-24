package com.david.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.Customer.Entity.Customer;

public interface ICustomer extends JpaRepository<Customer, Long>{


}
