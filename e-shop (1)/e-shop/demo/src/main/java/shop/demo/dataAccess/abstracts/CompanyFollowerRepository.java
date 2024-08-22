package shop.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shop.demo.entities.concretes.accountFollowers.CompanyFollower;

public interface CompanyFollowerRepository extends JpaRepository<CompanyFollower, Integer> {
	
	List<CompanyFollower> getCompanyFollowersByCompanyId(int companyId);
	
	//Customer'ın takip ettikleri
	List<CompanyFollower> getCompanyFollowerByCustomerId(int customerId);
	
	@Query("From CompanyFollower CF WHERE CF.company.Id = :companyId AND CF.customer.Id = :customerId   ")
	CompanyFollower checkCustomerFollowedCompanyBefore(int companyId,int customerId);
	
	
}
