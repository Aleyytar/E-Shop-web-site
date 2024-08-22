package shop.demo.business.abstracts.accountServices;

import java.util.List;

import shop.demo.business.abstracts.BaseService;
import shop.demo.business.requests.companyRequests.AddCompanyRequest;
import shop.demo.business.requests.companyRequests.UpdateCompanyRequest;
import shop.demo.business.responses.companyResponses.GetAllCompanyResponse;
import shop.demo.business.responses.companyResponses.GetCompanyEmailPasswordResponse;
import shop.demo.business.responses.companyResponses.GetCompanyResponse;

public interface CompanyService extends BaseService<AddCompanyRequest,UpdateCompanyRequest> {
	
	List<GetAllCompanyResponse> getAll();
	List<GetAllCompanyResponse> getAllActiveCompanies();
	GetCompanyResponse getCompanyById(int id);
	GetCompanyEmailPasswordResponse getCompanyByAccountEmail(String email);
	
	boolean checkCompanyEmailAndPasswordFields(String email,String password);
	

}
