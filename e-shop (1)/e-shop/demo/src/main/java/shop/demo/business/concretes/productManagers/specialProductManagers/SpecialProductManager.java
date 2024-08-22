package shop.demo.business.concretes.productManagers.specialProductManagers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.productServices.specialProductServices.SpecialProductService;
import shop.demo.business.requests.productRequests.specialProductRequests.AddSpecialProductRequest;
import shop.demo.business.requests.productRequests.specialProductRequests.UpdateSpecialProductRequest;
import shop.demo.business.responses.productResponses.specialProductResponses.GetAllSpecialProductsByGender;
import shop.demo.business.responses.productResponses.specialProductResponses.GetSpecialProductResponse;
import shop.demo.core.utilities.mappers.ModelMapperService;
import shop.demo.dataAccess.abstracts.SpecialProductRepository;
import shop.demo.entities.abstracts.Status;
import shop.demo.entities.concretes.products.SpecialProduct;

@Service
@AllArgsConstructor
public class SpecialProductManager implements SpecialProductService {
	
	private SpecialProductRepository specialProductRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetSpecialProductResponse> getSpecialProductsByCompanyId(int companyId) {
		
		List<GetSpecialProductResponse> specialProductResponseList = specialProductRepository.getSpecialProductsByProductCompanyId(companyId)
				.stream().map(specialProduct -> modelMapperService.forResponse().map(specialProduct, GetSpecialProductResponse.class))
				.collect(Collectors.toList());
		
		return specialProductResponseList;
	}
	
	@Override
	public List<GetAllSpecialProductsByGender> getSpecialProductsByGenderId(int genderId) {
		
		List<GetAllSpecialProductsByGender> specialProductsByGenderResponseList = specialProductRepository.getSpecialProductsByProductGenderId(genderId)
				.stream().map(sp -> modelMapperService.forResponse().map(sp, GetAllSpecialProductsByGender.class))
				.collect(Collectors.toList());
		
		return specialProductsByGenderResponseList;
	}
	
	@Override
	public GetSpecialProductResponse getSpecialProductById(int id) {
		
		SpecialProduct target = specialProductRepository.findById(id).orElse(null);
		
		if(target != null) {
			
			GetSpecialProductResponse specialProductResponse = modelMapperService.forResponse().map(target, GetSpecialProductResponse.class);
			
			return specialProductResponse;
			
		}
		
		return null;
	}

	@Override
	public void add(AddSpecialProductRequest addSpecialProductRequest) {
		
		SpecialProduct specialProduct = modelMapperService.forRequest().map(addSpecialProductRequest, SpecialProduct.class);
		specialProduct.setId(0);
		
		specialProduct.getProduct().setStatus(new Status());
		specialProduct.getProduct().getStatus().setId(3);
		
		specialProductRepository.save(specialProduct);
		

	}
	
	@Override
	public void update(UpdateSpecialProductRequest updateSpecialProductRequest) {
		
		SpecialProduct target = specialProductRepository.findById(updateSpecialProductRequest.getId()).orElse(null);
		
		if(target != null) {
			
			target = modelMapperService.forRequest().map(updateSpecialProductRequest, SpecialProduct.class);
			
			target.setId(updateSpecialProductRequest.getId());
			target.getProduct().setId(updateSpecialProductRequest.getProductId());
			
			
			specialProductRepository.save(target);
			
		}
		
	}

	@Override
	public void delete(int specialProductId) {
		
		SpecialProduct target = specialProductRepository.findById(specialProductId).orElseThrow();
		
		target.getProduct().setStatus(new Status());
		target.getProduct().getStatus().setId(2);
		
		specialProductRepository.save(target);
		
		
		
	}

	

	

	

}
