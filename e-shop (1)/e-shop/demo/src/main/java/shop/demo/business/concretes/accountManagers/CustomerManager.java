package shop.demo.business.concretes.accountManagers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.accountServices.CustomerService;
import shop.demo.business.requests.customerRequests.AddCustomerRequest;
import shop.demo.business.requests.customerRequests.UpdateCustomerRequest;
import shop.demo.business.responses.customerResponses.GetAllActiveCustomerResponse;
import shop.demo.business.responses.customerResponses.GetAllCustomerResponse;
import shop.demo.business.responses.customerResponses.GetCustomerEmailPasswordResponse;
import shop.demo.business.responses.customerResponses.GetCustomerResponse;
import shop.demo.business.rules.accountRules.CustomerBusinessRules;
import shop.demo.core.utilities.mappers.ModelMapperService;
import shop.demo.dataAccess.abstracts.CustomerRepository;
import shop.demo.entities.abstracts.Status;
import shop.demo.entities.concretes.accounts.Customer;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
	
	private CustomerRepository customerRepository;
	private ModelMapperService modelMapperService;
	private CustomerBusinessRules customerBusinessRules;
	
	
	@Override
	public List<GetAllCustomerResponse> getAll() {
		
		List<GetAllCustomerResponse> customerResponseList = customerRepository.findAll().stream().map(customer ->
		modelMapperService.forResponse().map(customer, GetAllCustomerResponse.class)).collect(Collectors.toList());
		
		return customerResponseList;
	}
	
	@Override
	public List<GetAllActiveCustomerResponse> getAllActiveCustomers() {
		
		List<GetAllActiveCustomerResponse> activeCustomerResponseList = customerRepository.getAllActiveCustomers().stream()
				.map(c -> modelMapperService.forResponse().map(c, GetAllActiveCustomerResponse.class)).collect(Collectors.toList());
		
		return activeCustomerResponseList;
	}

	
	@Override
	public GetCustomerResponse getCustomerById(int id) {
		
		Customer target = customerRepository.findById(id).orElse(null);
		
		
		if(target != null) {
			
			GetCustomerResponse customerResponse = modelMapperService.forResponse().map(target, GetCustomerResponse.class);
			
			return customerResponse;
			
		}
		
		return null;
	}
	
	@Override
	public GetCustomerEmailPasswordResponse getCustomerByAccountEmail(String email) {
		
		Customer target = customerRepository.getCustomerByAccountEmail(email);
		
		if(target != null) {
			GetCustomerEmailPasswordResponse customerResponse = modelMapperService.forResponse()
					.map(target, GetCustomerEmailPasswordResponse.class);
			
			return customerResponse;
		}
		
		
		return null;
	}
	

	@Override
	public void add(AddCustomerRequest addCustomerRequest) {
		
		
		customerBusinessRules.checkPasswordFields(addCustomerRequest.getAccountPassword(), addCustomerRequest.getAccountConfirmPassword());
		customerBusinessRules.existsEmailBefore(addCustomerRequest.getAccountEmail());
		customerBusinessRules.existsUsernameBefore(addCustomerRequest.getAccountUsername());
		
		Customer customer = modelMapperService.forRequest().map(addCustomerRequest, Customer.class);
		
		customer.getAccount().setStatus(new Status());
		customer.getAccount().getStatus().setId(1);
		
		
		customerRepository.save(customer);
		
	}


	


	@Override
	public void update(UpdateCustomerRequest updateCustomerRequest) {
		
		Customer target = customerRepository.findById(updateCustomerRequest.getId()).orElse(null);
		int accountId = target.getAccount().getId();
		
		if(target != null) {
			
			target = modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
			target.getAccount().setId(accountId);
			
			customerRepository.save(target);
		}
		
		
		
		
	}


	@Override
	public void delete(int id) {
		
		Customer target = customerRepository.findById(id).orElseThrow();
		
		if(target != null) {

			target.getAccount().setStatus(new Status());
			target.getAccount().getStatus().setId(2);
			
			customerRepository.save(target);
		}
		
		
	}

	


	
	
	
	

}
