package shop.demo.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.accountServices.CompanyService;
import shop.demo.business.requests.companyRequests.AddCompanyRequest;
import shop.demo.business.requests.companyRequests.UpdateCompanyRequest;
import shop.demo.business.responses.companyResponses.GetAllCompanyResponse;
import shop.demo.business.responses.companyResponses.GetCompanyEmailPasswordResponse;
import shop.demo.business.responses.companyResponses.GetCompanyResponse;

@RestController
@RequestMapping("/api/companies")
@AllArgsConstructor
@CrossOrigin
public class CompaniesController {

	private CompanyService companyService;
	
	@GetMapping("/getall")
	List<GetAllCompanyResponse> getAll(){
		
		return companyService.getAll();
		
	}
	
	@GetMapping("/getallactivecompanies")
	public List<GetAllCompanyResponse> getAllActiveCompanies(){
		
		return companyService.getAllActiveCompanies();
	}
	
	@GetMapping("/getcompanybyid/{id}")
	public GetCompanyResponse getCompanyById(@PathVariable int id) {
		
		return companyService.getCompanyById(id);
	}
	
	@GetMapping("/getcompanybyaccountemail/{email}")
	public GetCompanyEmailPasswordResponse getCompanyByAccountEmail(@PathVariable String email) {
		
		return companyService.getCompanyByAccountEmail(email);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	void add(@RequestBody @Valid AddCompanyRequest addCompanyRequest) {
		
		companyService.add(addCompanyRequest);
		
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateCompanyRequest updateCompanyRequest) {
		
		companyService.update(updateCompanyRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		
		companyService.delete(id);
	}
	
	@GetMapping("/checkcompany")
	public boolean checkCompanyEmailAndPasswordFields(String email, String password) {
		
		return companyService.checkCompanyEmailAndPasswordFields(email, password);
	}
}
