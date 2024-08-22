package shop.demo.api.followerControllers.companyFollowersControllers;

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
import shop.demo.business.abstracts.followerServices.companyFollowerServices.CompanyFollowerService;
import shop.demo.business.requests.followerRequests.companyFollowerRequests.AddCompanyFollowerRequest;
import shop.demo.business.responses.followerResponses.companyFollowerResponses.GetCompanyFollowersByCompanyResponse;
import shop.demo.business.responses.followerResponses.companyFollowerResponses.GetCustomerFollowingByCustomerResponse;

@RestController
@RequestMapping("/api/companyfollowers")
@AllArgsConstructor
@CrossOrigin
public class CompanyFollowersController {

	private CompanyFollowerService companyFollowerService;
	
	
	@GetMapping("/getCompanyFollowersByCompany/{companyId}")
	public List<GetCompanyFollowersByCompanyResponse> getCompanyFollowersByCompanyId(@PathVariable int companyId){
		
		return companyFollowerService.getCompanyFollowersByCompanyId(companyId);
		
	}
	
	@GetMapping("/getcustomerfollowingbycustomer/{customerId}")
	public List<GetCustomerFollowingByCustomerResponse> getCustomerFollowingByCustomerId(@PathVariable int customerId) {
		
		return companyFollowerService.getCustomerFollowingByCustomerId(customerId);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody AddCompanyFollowerRequest addCompanyFollowerRequest) {
		
		companyFollowerService.add(addCompanyFollowerRequest);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		companyFollowerService.delete(id);
	}
	
}
