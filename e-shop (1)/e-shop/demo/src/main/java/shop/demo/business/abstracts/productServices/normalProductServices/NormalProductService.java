package shop.demo.business.abstracts.productServices.normalProductServices;

import java.util.List;

import shop.demo.business.requests.productRequests.normalProductRequests.AddNormalProductRequest;
import shop.demo.business.requests.productRequests.normalProductRequests.UpdateNormalProductRequest;
import shop.demo.business.responses.productResponses.normalProductResponses.GetAllActiveNormalProductResponse;
import shop.demo.business.responses.productResponses.normalProductResponses.GetAllNormalProductResponse;
import shop.demo.business.responses.productResponses.normalProductResponses.GetAllNormalProductsByGender;
import shop.demo.business.responses.productResponses.normalProductResponses.GetAwaitingNormalProductResponse;
import shop.demo.business.responses.productResponses.normalProductResponses.GetNormalProductResponse;

public interface NormalProductService {
	
	List<GetAllNormalProductResponse> getAll();
	List<GetAllNormalProductResponse> getNormalProductsByProductCategoryId(int id);
	List<GetAllActiveNormalProductResponse> getAllActiveNormalProducts();
	List<GetAllActiveNormalProductResponse> getAllNormalProductNameContaining(String value);
	List<GetAllNormalProductsByGender> getAllNormalProductsByGenderId(int genderId);
	List<GetAwaitingNormalProductResponse> getAllNormalProductByCompanyIdAndStatusId(int companyId,int statusId);
	GetNormalProductResponse getProductById(int id);
	
	
	void add(AddNormalProductRequest addProductRequest);
	void update(UpdateNormalProductRequest updateNormalProductRequest);
	void delete(int id);

}
