package shop.demo.business.rules.accountRules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.core.utilities.exceptions.BusinessException;
import shop.demo.dataAccess.abstracts.CustomerRepository;

@Service
@AllArgsConstructor
public class CustomerBusinessRules implements AccountBusinessRules{
	
	private CustomerRepository customerRepository;
	
	
	@Override
	public void checkPasswordFields(String password, String confirmPassword) {
		
		if(password.equalsIgnoreCase(confirmPassword) == false) {
			
			throw new BusinessException("Şifreler uyuşmuyor");
		}
		
	}

	@Override
	public void existsEmailBefore(String email) {
		
		Boolean isExists = customerRepository.existsCustomerByAccountEmail(email);
		
		if(isExists == true) {
			
			throw new BusinessException("Böyle bir email sistemde kayıtlı");
		}
		
	}

	@Override
	public void existsUsernameBefore(String username) {
		
		Boolean isExists = customerRepository.existsCustomerByAccountUsername(username);
		
		if(isExists == true) {
			
			throw new BusinessException("Böyle bir kullanıcı adı sistemde kayıtlı");
		}
		
	}

}
