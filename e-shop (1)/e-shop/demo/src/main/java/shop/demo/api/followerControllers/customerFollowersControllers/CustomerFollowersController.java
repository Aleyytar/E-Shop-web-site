package shop.demo.api.followerControllers.customerFollowersControllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.followerServices.customerFollowerServices.CustomerFollowerService;
import shop.demo.business.requests.followerRequests.customerFollowerRequests.AddCustomerFollowerRequest;
import shop.demo.business.responses.followerResponses.customerFollowerResponses.GetCompanyFollowingByCompanyResponse;
import shop.demo.business.responses.followerResponses.customerFollowerResponses.GetCustomerFollowersByCustomerResponse;

@RestController
@RequestMapping("/api/customerfollowers")
@AllArgsConstructor
@CrossOrigin
public class CustomerFollowersController {
	
	private CustomerFollowerService customerFollowerService;

	@GetMapping("/getcustomerfollowersbycustomerid/{customerId}")
	public List<GetCustomerFollowersByCustomerResponse> getCustomerFollowersByCustomerId(@PathVariable int customerId){
		
		return customerFollowerService.getCustomerFollowersByCustomerId(customerId);
	}
	
	@GetMapping("/getcompanyfollowingbycompanyid/{companyId}")
	public List<GetCompanyFollowingByCompanyResponse> getCompanyFollowingByCompanyId(@PathVariable int companyId) {
		
		return customerFollowerService.getCompanyFollowingByCompanyId(companyId);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody AddCustomerFollowerRequest addCustomerFollowerRequest) {
		
		customerFollowerService.add(addCustomerFollowerRequest);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		
		customerFollowerService.delete(id);
		
	}
}
