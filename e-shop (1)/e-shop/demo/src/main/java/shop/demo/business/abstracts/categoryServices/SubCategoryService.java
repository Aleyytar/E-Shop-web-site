package shop.demo.business.abstracts.categoryServices;

import java.util.List;

import shop.demo.business.abstracts.BaseService;
import shop.demo.business.requests.categoryRequests.subCategoryRequests.AddSubCategoryRequest;
import shop.demo.business.requests.categoryRequests.subCategoryRequests.UpdateSubCategoryRequest;
import shop.demo.business.responses.categoryResponses.subCategoryResponses.GetAllActiveSubCategoryResponse;
import shop.demo.business.responses.categoryResponses.subCategoryResponses.GetAllSubCategoryResponse;

public interface SubCategoryService extends BaseService<AddSubCategoryRequest, UpdateSubCategoryRequest> {
	
	List<GetAllSubCategoryResponse> getAll();
	List<GetAllActiveSubCategoryResponse> getAllActiveSubCategory();
	
	List<GetAllActiveSubCategoryResponse> getAllSubCategoryByGenderId(int genderId);

}


