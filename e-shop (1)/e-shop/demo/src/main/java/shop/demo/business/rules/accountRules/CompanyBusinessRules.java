package shop.demo.business.rules.accountRules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.core.utilities.exceptions.BusinessException;
import shop.demo.dataAccess.abstracts.CompanyRepository;
import shop.demo.dataAccess.abstracts.CustomerRepository;

@Service
@AllArgsConstructor
public class CompanyBusinessRules implements AccountBusinessRules {

	private CompanyRepository companyRepository;
	private CustomerRepository customerRepository;

	@Override
	public void existsEmailBefore(String email) {

		Boolean isCompanyEmailExists = companyRepository.existsCompanyByAccountEmail(email);
		Boolean isCustomerEmailExists = customerRepository.existsCustomerByAccountEmail(email);

		if (isCompanyEmailExists == true || isCustomerEmailExists == true ) {

			throw new BusinessException("Böyle bir email sistemde kayıtlı");

		}
	}

	@Override
	public void existsUsernameBefore(String username) {

		Boolean isExists = companyRepository.existsCompanyByAccountUsername(username);

		if (isExists == true) {

			throw new BusinessException("Böyle bir kullanıcı adı sistemde kayıtlı");

		}

	}

	@Override
	public void checkPasswordFields(String password, String confirmPassword) {
		
		if(password.equalsIgnoreCase(confirmPassword) == false) {
			
			throw new BusinessException("Şifreler uyuşmuyor");
			
		}
		

	}

}
