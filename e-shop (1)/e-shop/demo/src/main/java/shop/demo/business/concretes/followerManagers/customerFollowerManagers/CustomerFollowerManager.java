package shop.demo.business.concretes.followerManagers.customerFollowerManagers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.followerServices.customerFollowerServices.CustomerFollowerService;
import shop.demo.business.requests.followerRequests.customerFollowerRequests.AddCustomerFollowerRequest;
import shop.demo.business.responses.followerResponses.customerFollowerResponses.GetCompanyFollowingByCompanyResponse;
import shop.demo.business.responses.followerResponses.customerFollowerResponses.GetCustomerFollowersByCustomerResponse;
import shop.demo.business.rules.followerRules.CustomerFollowerBusinessRules;
import shop.demo.core.utilities.mappers.ModelMapperService;
import shop.demo.dataAccess.abstracts.CustomerFollowerRepository;
import shop.demo.entities.concretes.accountFollowers.CustomerFollower;


@Service
@AllArgsConstructor
public class CustomerFollowerManager implements CustomerFollowerService {
	
	private CustomerFollowerRepository customerFollowerRepository;
	private ModelMapperService modelMapperService;
	private CustomerFollowerBusinessRules customerFollowerBusinessRules;

	@Override
	public List<GetCustomerFollowersByCustomerResponse> getCustomerFollowersByCustomerId(int customerId) {

		List<GetCustomerFollowersByCustomerResponse> customerFollowerResponseList = customerFollowerRepository.getCustomerFollowersByCustomerId(customerId)
				.stream().map(customerFollower -> modelMapperService.forResponse()
				.map(customerFollower, GetCustomerFollowersByCustomerResponse.class)).collect(Collectors.toList());
		
		return customerFollowerResponseList;
	}
	
	@Override
	public List<GetCompanyFollowingByCompanyResponse> getCompanyFollowingByCompanyId(int companyId) {
		
		List<GetCompanyFollowingByCompanyResponse> companyFollowingResponseList = customerFollowerRepository.getCustomerFollowerByCompanyId(companyId)
				.stream().map(customerFollower -> modelMapperService.forResponse()
				.map(customerFollower, GetCompanyFollowingByCompanyResponse.class)).collect(Collectors.toList());
	
		return companyFollowingResponseList;
	}

	@Override
	public void add(AddCustomerFollowerRequest addCustomerFollowerRequest) {
		
		customerFollowerBusinessRules.checkCustomerFollowedCompanyBefore(addCustomerFollowerRequest.getCustomerId(), addCustomerFollowerRequest.getCompanyId());
		
		CustomerFollower customerFollower = modelMapperService.forRequest().map(addCustomerFollowerRequest, CustomerFollower.class);
		customerFollower.setId(0);
		
		customerFollowerRepository.save(customerFollower);

	}

	@Override
	public void delete(int id) {
		
		customerFollowerRepository.deleteById(id);
		
	}
	
	

	

}
