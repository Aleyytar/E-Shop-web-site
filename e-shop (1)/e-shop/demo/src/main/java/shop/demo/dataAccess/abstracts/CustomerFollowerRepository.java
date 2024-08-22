package shop.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shop.demo.entities.concretes.accountFollowers.CustomerFollower;

public interface CustomerFollowerRepository extends JpaRepository<CustomerFollower, Integer> {
	
	
	List<CustomerFollower> getCustomerFollowersByCustomerId(int customerId);
	
	//Company'nin takip ettikleri
	List<CustomerFollower> getCustomerFollowerByCompanyId(int companyId);
	
	@Query("From CustomerFollower CF WHERE CF.customer.Id = :customerId AND CF.company.Id = :companyId ")
	CustomerFollower checkCustomerFollowedCompanyBefore(int customerId,int companyId);

}
