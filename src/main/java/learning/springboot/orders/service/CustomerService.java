package learning.springboot.orders.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import learning.springboot.orders.domain.Address;
import learning.springboot.orders.domain.Customer;
import learning.springboot.orders.exception.CutomerAlreadyExistsException;
import learning.springboot.orders.repository.CustomerRepository;
import learning.springboot.orders.util.OrderUtil;

@Component
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> findAllCustomers() {
		Iterable<Customer> customerIterable = customerRepository.findAll();

		List<Customer> customerList = new ArrayList<Customer>();
		for (Customer cust : customerIterable) {
			customerList.add(cust);
		}
		return customerList;
	}

	public Customer createCustomer(Customer customer) throws CutomerAlreadyExistsException {
		
		Customer customerExisting = customerRepository.findByEmail(customer.getEmail());
		
		if(customerExisting!=null){
			throw new CutomerAlreadyExistsException("conflict");
		}
		customer.setId(OrderUtil.generateUUIDAsString());
		List<Address> addressList = customer.getAddressList();
		for(Address address : addressList){
			address.setId(OrderUtil.generateUUIDAsString());
			address.setCustomer(customer);
		}
		return customerRepository.save(customer);
	}

	
	


}
