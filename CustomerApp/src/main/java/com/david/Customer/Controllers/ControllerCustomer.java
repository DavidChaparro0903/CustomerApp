package com.david.Customer.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.david.Customer.Entity.Customer;
import com.david.Customer.Implementation.CustomerImplementation;
import com.david.Customer.dao.CreateCustomer;

@RestController
@RequestMapping("/customer")
public class ControllerCustomer {

	@Autowired
	private CustomerImplementation customer;

	@GetMapping()
	public List<Customer> getListCustomer() {
		return customer.getListCustomer();
	}

	@PostMapping()
	public void addCustomer(@RequestBody CreateCustomer customerAdd) {
		Customer customerAux = new Customer();
		customerAux.setName(customerAdd.getName());
		customerAux.setPhone(customerAdd.getPhone());
		customer.addCustomer(customerAux);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomer(@PathVariable Long id) {
		Customer customerAux = customer.getById(id);
		if (customerAux != null) {
			return ResponseEntity.ok(customerAux);
		}
		return ResponseEntity.ofNullable(null);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable Long id, @RequestBody CreateCustomer input) {
		Customer customerAux = customer.getById(id);
		if (customerAux != null) {
			customerAux.setName(input.getName());
			customerAux.setPhone(input.getPhone());
			customer.addCustomer(customerAux);
			return ResponseEntity.ok(input);
		}
		return ResponseEntity.ofNullable(null);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Customer customerAux = customer.getById(id);
		if(customerAux != null) {
			customer.deleteById(id);
			return ResponseEntity.ok(true);
		}
		return ResponseEntity.ofNullable(null);
	}

}
