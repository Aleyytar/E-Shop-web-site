package shop.demo.business.abstracts.followerServices.companyFollowerServices;

import java.util.List;

import shop.demo.business.requests.followerRequests.companyFollowerRequests.AddCompanyFollowerRequest;
import shop.demo.business.responses.followerResponses.companyFollowerResponses.GetCompanyFollowersByCompanyResponse;
import shop.demo.business.responses.followerResponses.companyFollowerResponses.GetCustomerFollowingByCustomerResponse;
import shop.demo.business.responses.followerResponses.customerFollowerResponses.GetCompanyFollowingByCompanyResponse;

public interface CompanyFollowerService {
	
	List<GetCompanyFollowersByCompanyResponse> getCompanyFollowersByCompanyId(int companyId);
	List<GetCustomerFollowingByCustomerResponse> getCustomerFollowingByCustomerId(int customerId);
	void add(AddCompanyFollowerRequest addCompanyFollowerRequest);
	void delete(int id);

}
