package shop.demo.business.abstracts.productServices.specialProductServices;

import java.util.List;

import shop.demo.business.requests.productRequests.specialProductRequests.AddSpecialProductRequest;
import shop.demo.business.requests.productRequests.specialProductRequests.UpdateSpecialProductRequest;
import shop.demo.business.responses.productResponses.specialProductResponses.GetAllSpecialProductsByGender;
import shop.demo.business.responses.productResponses.specialProductResponses.GetSpecialProductResponse;

public interface SpecialProductService {
	
	List<GetSpecialProductResponse> getSpecialProductsByCompanyId(int companyId);
	List<GetAllSpecialProductsByGender> getSpecialProductsByGenderId(int genderId);
	GetSpecialProductResponse getSpecialProductById(int id);
	void add(AddSpecialProductRequest addSpecialProductRequest);
	void update(UpdateSpecialProductRequest updateSpecialProductRequest);
	void delete(int specialProductId);

} 
