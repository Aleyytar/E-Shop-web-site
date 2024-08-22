package shop.demo.business.rules.followerRules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.core.utilities.exceptions.BusinessException;
import shop.demo.dataAccess.abstracts.CustomerFollowerRepository;
import shop.demo.entities.concretes.accountFollowers.CustomerFollower;

@Service
@AllArgsConstructor
public class CustomerFollowerBusinessRules {
	
	private CustomerFollowerRepository customerFollowerRepository;
	
	public void checkCustomerFollowedCompanyBefore(int customerId,int companyId) {
		
		CustomerFollower customerFollower = customerFollowerRepository.checkCustomerFollowedCompanyBefore(customerId, companyId); 
		
		if(customerFollower != null) {
			
			throw new BusinessException("Bu müşteriyi zaten takip etmektesiniz");
		}
		
		
	}

}
