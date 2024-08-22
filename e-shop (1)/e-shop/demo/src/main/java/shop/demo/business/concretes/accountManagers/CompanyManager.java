package shop.demo.business.concretes.accountManagers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.accountServices.CompanyService;
import shop.demo.business.requests.companyRequests.AddCompanyRequest;
import shop.demo.business.requests.companyRequests.UpdateCompanyRequest;
import shop.demo.business.responses.companyResponses.GetAllCompanyResponse;
import shop.demo.business.responses.companyResponses.GetCompanyEmailPasswordResponse;
import shop.demo.business.responses.companyResponses.GetCompanyResponse;
import shop.demo.business.rules.accountRules.CompanyBusinessRules;
import shop.demo.core.utilities.mappers.ModelMapperService;
import shop.demo.dataAccess.abstracts.CompanyRepository;
import shop.demo.entities.abstracts.Status;
import shop.demo.entities.concretes.accounts.Company;

@Service
@AllArgsConstructor
public class CompanyManager implements CompanyService{

	private CompanyRepository companyRepository;
	private ModelMapperService modelMapperService;
	private CompanyBusinessRules companyBusinessRules;

	@Override
	public List<GetAllCompanyResponse> getAll() {
		
		List<GetAllCompanyResponse> companyResponseList = companyRepository.findAll().stream().map(company -> 
		modelMapperService.forResponse().map(company, GetAllCompanyResponse.class)).collect(Collectors.toList());
		
		
		return companyResponseList;
	}
	
	@Override
	public List<GetAllCompanyResponse> getAllActiveCompanies() {
		
		List<GetAllCompanyResponse> activeCompaniesList = companyRepository.getAllActiveCompanies().stream()
				.map(activeCompany -> modelMapperService.forResponse().map(activeCompany, GetAllCompanyResponse.class))
				.collect(Collectors.toList());
		
		return activeCompaniesList;
	}
	
	@Override
	public GetCompanyResponse getCompanyById(int id) {
		
		Company target = companyRepository.findById(id).orElse(null);
		
		if(target != null) {
			
			GetCompanyResponse companyResponse = modelMapperService.forResponse().map(target, GetCompanyResponse.class);
			return companyResponse;
			
		}
		
		return null;
	}
	
	@Override
	public GetCompanyEmailPasswordResponse getCompanyByAccountEmail(String email) {
		Company target = companyRepository.getCompanyByAccountEmail(email);
		
		if(target != null) {
			GetCompanyEmailPasswordResponse companyResponse = modelMapperService.forResponse()
					.map(target, GetCompanyEmailPasswordResponse.class);
			
			return companyResponse;
		}
		
		
		return null;
	}

	@Override
	public void add(AddCompanyRequest addCompanyRequest) {
		
		
		companyBusinessRules.checkPasswordFields(addCompanyRequest.getAccountPassword(), addCompanyRequest.getAccountConfirmPassword());
		companyBusinessRules.existsEmailBefore(addCompanyRequest.getAccountEmail());
		companyBusinessRules.existsUsernameBefore(addCompanyRequest.getAccountUsername());
		
		Company company = modelMapperService.forRequest().map(addCompanyRequest, Company.class);
		company.setId(0);
		
		company.getAccount().setStatus(new Status());
		
		company.getAccount().getStatus().setId(1);
		
		
		
		companyRepository.save(company);
		
	}

	

	@Override
	public void update(UpdateCompanyRequest updateCompanyRequest) {
		
		Company target = companyRepository.findById(updateCompanyRequest.getId()).orElse(null);
		int accountId = target.getAccount().getId();
		
		if(target != null) {
			
			target = modelMapperService.forRequest().map(updateCompanyRequest, Company.class);
			target.getAccount().setId(accountId);
			
			companyRepository.save(target);
			
			
		}
		
		
	}

	@Override
	public void delete(int id) {
		
		Company target = companyRepository.findById(id).orElseThrow();
		
		
		if(target != null) {
			
			target.getAccount().setStatus(new Status());
			target.getAccount().getStatus().setId(2);
		
			companyRepository.save(target);
		}
		
		
	}

	@Override
	public boolean checkCompanyEmailAndPasswordFields(String email, String password) {
		
		var result = companyRepository.checkCompanyEmailAndPasswordFields(email, password);

		if(result != null) {
			return true;
		}
		return false;

	}

	

	
	
}
