package shop.demo.business.abstracts.accountServices;

import java.util.List;

import shop.demo.business.abstracts.BaseService;
import shop.demo.business.requests.customerRequests.AddCustomerRequest;
import shop.demo.business.requests.customerRequests.UpdateCustomerRequest;
import shop.demo.business.responses.customerResponses.GetAllActiveCustomerResponse;
import shop.demo.business.responses.customerResponses.GetAllCustomerResponse;
import shop.demo.business.responses.customerResponses.GetCustomerEmailPasswordResponse;
import shop.demo.business.responses.customerResponses.GetCustomerResponse;

public interface CustomerService extends BaseService<AddCustomerRequest, UpdateCustomerRequest> {

	List<GetAllCustomerResponse> getAll();
	List<GetAllActiveCustomerResponse> getAllActiveCustomers();
	
	GetCustomerResponse getCustomerById(int id);
	GetCustomerEmailPasswordResponse getCustomerByAccountEmail(String email);
	
	
}
