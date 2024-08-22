package shop.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shop.demo.entities.concretes.accounts.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	boolean existsCompanyByAccountEmail(String email);
	boolean existsCompanyByAccountUsername(String username);
	
	@Query("FROM Company C Where C.account.status.id = 1")
	List<Company> getAllActiveCompanies();
	
	@Query("FROM Company C Where C.account.email = :email AND C.account.password = :password")
	Company checkCompanyEmailAndPasswordFields(String email,String password);
	
	Company getCompanyByAccountEmail(String email);

}
 