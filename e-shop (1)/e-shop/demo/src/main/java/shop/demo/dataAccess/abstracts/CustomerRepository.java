package shop.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shop.demo.entities.concretes.accounts.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	
	@Query("From Customer C Where C.account.status.id = 1 ")
	List<Customer> getAllActiveCustomers();
	Customer getCustomerByAccountEmail(String email);
	
	boolean existsCustomerByAccountEmail(String email);
	boolean existsCustomerByAccountUsername(String username);
	
	

}
