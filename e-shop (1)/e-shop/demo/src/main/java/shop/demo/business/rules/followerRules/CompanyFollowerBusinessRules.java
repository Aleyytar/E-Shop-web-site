package shop.demo.business.rules.followerRules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.core.utilities.exceptions.BusinessException;
import shop.demo.dataAccess.abstracts.CompanyFollowerRepository;
import shop.demo.entities.concretes.accountFollowers.CompanyFollower;

@Service
@AllArgsConstructor
public class CompanyFollowerBusinessRules {
	
	private CompanyFollowerRepository companyFollowerRepository;
	
	public void checkCompanyFollowedCustomerBefore(int companyId,int customerId) {
		
		CompanyFollower companyFollower = companyFollowerRepository.checkCustomerFollowedCompanyBefore(companyId, customerId);
		
		if(companyFollower != null) {
			
			throw new BusinessException("Bu şirketi zaten takip etmektesiniz");
			
		}
		
	}

}
