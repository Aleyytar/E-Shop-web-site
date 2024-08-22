package shop.demo.business.abstracts.categoryServices;

import java.util.List;

import shop.demo.business.abstracts.BaseService;
import shop.demo.business.requests.categoryRequests.AddCategoryRequest;
import shop.demo.business.requests.categoryRequests.UpdateCategoryRequest;
import shop.demo.business.responses.categoryResponses.GetAllActiveCategoryResponse;
import shop.demo.business.responses.categoryResponses.GetAllCategoryResponse;

public interface CategoryService extends BaseService<AddCategoryRequest, UpdateCategoryRequest> {
	
	List<GetAllCategoryResponse> getAll();
	List<GetAllCategoryResponse> getAllActiveCategory();
	
	List<GetAllActiveCategoryResponse> getAllMenCategory();
	List<GetAllActiveCategoryResponse> getAllWomenCategory();
	List<GetAllActiveCategoryResponse> getAllUnisexCategory();

}
