package shop.demo.business.abstracts.photoServices;

import java.util.List;

import shop.demo.business.abstracts.BaseService;
import shop.demo.business.requests.photoRequests.productPhotoRequests.AddProductPhotoRequest;
import shop.demo.business.requests.photoRequests.productPhotoRequests.UpdateProductPhotoRequest;
import shop.demo.business.responses.photosResponses.productPhotoResponses.GetAllProductPhotosByProductResponse;

public interface ProductPhotoService extends BaseService<AddProductPhotoRequest, UpdateProductPhotoRequest>{

	List<GetAllProductPhotosByProductResponse> getProductPhotosByProductId(int id);
	
	
}
