package learning.springboot.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import learning.springboot.orders.domain.Customer;
import learning.springboot.orders.exception.CutomerAlreadyExistsException;
import learning.springboot.orders.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomersController {
	
	@Autowired
	private CustomerService customerService;
	
	@ResponseBody
	@GetMapping
	public List<Customer> getAllCustomers(){
		return customerService.findAllCustomers();
	}
	
	@ResponseBody
	@PostMapping
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
		Customer customerRepsonse;
		try {
			customerRepsonse = customerService.createCustomer(customer);
		} catch (CutomerAlreadyExistsException ex) {
			learning.springboot.model.Error error = new learning.springboot.model.Error();
			error.setCode(HttpStatus.CONFLICT.name());
			error.setMessage("conflict occured");
			error.setDetails(ex.getMessage());
			return  ResponseEntity.status(HttpStatus.CONFLICT).body(error);
		}
		return  ResponseEntity.status(HttpStatus.CREATED).body(customerRepsonse);
	}

}
