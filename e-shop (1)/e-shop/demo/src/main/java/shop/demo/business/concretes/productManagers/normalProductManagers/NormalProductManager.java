package shop.demo.business.concretes.productManagers.normalProductManagers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.productServices.normalProductServices.NormalProductService;
import shop.demo.business.requests.productRequests.normalProductRequests.AddNormalProductRequest;
import shop.demo.business.requests.productRequests.normalProductRequests.UpdateNormalProductRequest;
import shop.demo.business.responses.productResponses.normalProductResponses.GetAllActiveNormalProductResponse;
import shop.demo.business.responses.productResponses.normalProductResponses.GetAllNormalProductResponse;
import shop.demo.business.responses.productResponses.normalProductResponses.GetAllNormalProductsByGender;
import shop.demo.business.responses.productResponses.normalProductResponses.GetAwaitingNormalProductResponse;
import shop.demo.business.responses.productResponses.normalProductResponses.GetNormalProductResponse;
import shop.demo.core.utilities.mappers.ModelMapperService;
import shop.demo.dataAccess.abstracts.NormalProductRepository;
import shop.demo.entities.abstracts.Status;
import shop.demo.entities.concretes.products.NormalProduct;

@Service
@AllArgsConstructor
public class NormalProductManager implements NormalProductService {
	
	private NormalProductRepository normalProductRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllNormalProductResponse> getAll() {
		
		List<GetAllNormalProductResponse> productResponseList = normalProductRepository.findAll().stream().map(product ->
		modelMapperService.forResponse().map(product, GetAllNormalProductResponse.class)).collect(Collectors.toList());
		
		
		return productResponseList;
	}
	
	
	@Override
	public List<GetAllNormalProductResponse> getNormalProductsByProductCategoryId(int id) {
		
		/*
		 * List<GetAllNormalProductResponse> productResponseList =
		 * normalProductRepository.getNormalProductsByProductCategoryId(id).stream()
		 * .map(product -> modelMapperService.forResponse().map(product,
		 * GetAllNormalProductResponse.class)) .collect(Collectors.toList());
		 * 
		 * return productResponseList;
		 */
		
		return null;
	}
	
	
	@Override
	public List<GetAllActiveNormalProductResponse> getAllActiveNormalProducts() {
		
		List<GetAllActiveNormalProductResponse> activeNormalProductResponseList = normalProductRepository.getAllActiveNormalProducts()
				.stream().map(np -> modelMapperService.forResponse().map(np, GetAllActiveNormalProductResponse.class)).collect(Collectors.toList());
		
		
		return activeNormalProductResponseList;
	}
	
	
	@Override
	public List<GetAllActiveNormalProductResponse> getAllNormalProductNameContaining(String value) {
		
		List<GetAllActiveNormalProductResponse> activeNormalProductResponseList = normalProductRepository.getAllNormalProductNameContaining(value)
				.stream().map(np -> modelMapperService.forResponse().map(np, GetAllActiveNormalProductResponse.class)).collect(Collectors.toList());
		
		
		return activeNormalProductResponseList;
	}
	
	@Override
	public List<GetAllNormalProductsByGender> getAllNormalProductsByGenderId(int genderId) {
		
		List<GetAllNormalProductsByGender> normalProductsByGenderResponseList = normalProductRepository.getNormalProductsByProductGenderId(genderId)
				.stream().map(np -> modelMapperService.forResponse().map(np, GetAllNormalProductsByGender.class))
				.collect(Collectors.toList());
		
		
		return normalProductsByGenderResponseList;
	}
	
	@Override
	public GetNormalProductResponse getProductById(int id) {
		
		NormalProduct target = normalProductRepository.findById(id).orElse(null);
		
		if(target != null) {
			
			GetNormalProductResponse productResponse = modelMapperService.forResponse().map(target, GetNormalProductResponse.class);
			
			return productResponse;
			
		}
		
		return null;
	}
	
	@Override
	public List<GetAwaitingNormalProductResponse> getAllNormalProductByCompanyIdAndStatusId(int companyId, int statusId) {
		
		List<GetAwaitingNormalProductResponse> normalProductList = normalProductRepository.getAllNormalProductsByCompanyIdAndStatusId(companyId, statusId)
				.stream().map(np -> modelMapperService.forResponse().map(np, GetAwaitingNormalProductResponse.class))
				.collect(Collectors.toList());
		
		return normalProductList;
	}

	@Override
	public void add(AddNormalProductRequest addProductRequest) {
		
		NormalProduct normalProduct = modelMapperService.forRequest().map(addProductRequest, NormalProduct.class);
		
		normalProduct.getProduct().setId(0);
		normalProduct.setId(0);
		normalProduct.getProduct().setStatus(new Status());
		normalProduct.getProduct().getStatus().setId(3);
		
		System.out.println(normalProduct);
		
		normalProductRepository.save(normalProduct);
		
		
	}
	
	@Override
	public void update(UpdateNormalProductRequest updateNormalProductRequest) {
		
		NormalProduct target = normalProductRepository.findById(updateNormalProductRequest.getId()).orElse(null);
		
		
		if(target != null) {
			
			target = modelMapperService.forRequest().map(updateNormalProductRequest, NormalProduct.class);
			
			target.setId(updateNormalProductRequest.getId());
			target.getProduct().setId(updateNormalProductRequest.getProductId());
			target.getProduct().getStatus().setId(updateNormalProductRequest.getProductStatusId());
			
			
			normalProductRepository.save(target);
			
		}
		
		
	}

	@Override
	public void delete(int id) {
		
		NormalProduct target = normalProductRepository.findById(id).orElseThrow();
		
		target.getProduct().setStatus(new Status());
		target.getProduct().getStatus().setId(2);
		
		normalProductRepository.save(target);
		
	}


	

}
