package shop.demo.business.concretes.followerManagers.companyFollowerManagers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.followerServices.companyFollowerServices.CompanyFollowerService;
import shop.demo.business.requests.followerRequests.companyFollowerRequests.AddCompanyFollowerRequest;
import shop.demo.business.responses.followerResponses.companyFollowerResponses.GetCompanyFollowersByCompanyResponse;
import shop.demo.business.responses.followerResponses.companyFollowerResponses.GetCustomerFollowingByCustomerResponse;
import shop.demo.business.rules.followerRules.CompanyFollowerBusinessRules;
import shop.demo.core.utilities.mappers.ModelMapperService;
import shop.demo.dataAccess.abstracts.CompanyFollowerRepository;
import shop.demo.entities.concretes.accountFollowers.CompanyFollower;

@Service
@AllArgsConstructor
public class CompanyFollowerManager implements CompanyFollowerService {
	
	private CompanyFollowerRepository companyFollowerRepository;
	private ModelMapperService modelMapperService;
	private CompanyFollowerBusinessRules companyFollowerBusinessRules;

	@Override
	public List<GetCompanyFollowersByCompanyResponse> getCompanyFollowersByCompanyId(int companyId) {

		List<GetCompanyFollowersByCompanyResponse> companyFollowerResponseList = companyFollowerRepository.getCompanyFollowersByCompanyId(companyId)
				.stream().map(companyFollower -> modelMapperService.forResponse()
				.map(companyFollower, GetCompanyFollowersByCompanyResponse.class)).collect(Collectors.toList());
		
		return companyFollowerResponseList;
		
	}
	
	@Override
	public List<GetCustomerFollowingByCustomerResponse> getCustomerFollowingByCustomerId(int customerId) {
		
		List<GetCustomerFollowingByCustomerResponse> customerFollowingResponseList = companyFollowerRepository.getCompanyFollowerByCustomerId(customerId)
				.stream().map(customerFollower -> modelMapperService.forResponse()
				.map(customerFollower, GetCustomerFollowingByCustomerResponse.class)).collect(Collectors.toList());
	
		return customerFollowingResponseList;
	}

	@Override
	public void add(AddCompanyFollowerRequest addCompanyFollowerRequest) {
		
		companyFollowerBusinessRules.checkCompanyFollowedCustomerBefore(addCompanyFollowerRequest.getCompanyId(), addCompanyFollowerRequest.getCustomerId());
		
		CompanyFollower companyFollower = modelMapperService.forRequest().map(addCompanyFollowerRequest, CompanyFollower.class);
		companyFollower.setId(0);
		
		companyFollowerRepository.save(companyFollower);

	}

	@Override
	public void delete(int id) {
		System.out.println(id);
		companyFollowerRepository.deleteById(id);
		
		
	}

	

	

}
