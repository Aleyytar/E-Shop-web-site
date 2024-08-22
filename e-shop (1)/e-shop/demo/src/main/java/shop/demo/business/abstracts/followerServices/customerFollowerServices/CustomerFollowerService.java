package shop.demo.business.abstracts.followerServices.customerFollowerServices;

import java.util.List;

import shop.demo.business.requests.followerRequests.customerFollowerRequests.AddCustomerFollowerRequest;
import shop.demo.business.responses.followerResponses.customerFollowerResponses.GetCompanyFollowingByCompanyResponse;
import shop.demo.business.responses.followerResponses.customerFollowerResponses.GetCustomerFollowersByCustomerResponse;

public interface CustomerFollowerService {
	
	List<GetCustomerFollowersByCustomerResponse> getCustomerFollowersByCustomerId(int customerId);
	List<GetCompanyFollowingByCompanyResponse> getCompanyFollowingByCompanyId(int companyId);
	void add(AddCustomerFollowerRequest addCustomerFollowerRequest);
	void delete(int id);
}
