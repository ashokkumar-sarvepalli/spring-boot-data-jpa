package learning.springboot.orders.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import learning.springboot.orders.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,String>{
	
	@Query
	public Customer findByEmail(String email);

}
