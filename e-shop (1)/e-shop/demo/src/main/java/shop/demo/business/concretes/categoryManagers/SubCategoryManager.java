package shop.demo.business.concretes.categoryManagers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.categoryServices.SubCategoryService;
import shop.demo.business.requests.categoryRequests.subCategoryRequests.AddSubCategoryRequest;
import shop.demo.business.requests.categoryRequests.subCategoryRequests.UpdateSubCategoryRequest;
import shop.demo.business.responses.categoryResponses.subCategoryResponses.GetAllActiveSubCategoryResponse;
import shop.demo.business.responses.categoryResponses.subCategoryResponses.GetAllSubCategoryResponse;
import shop.demo.core.utilities.mappers.ModelMapperService;
import shop.demo.dataAccess.abstracts.SubCategoryRepository;
import shop.demo.entities.abstracts.Status;
import shop.demo.entities.concretes.categories.SubCategory;

@Service
@AllArgsConstructor
public class SubCategoryManager implements SubCategoryService {

	private SubCategoryRepository subCategoryRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllSubCategoryResponse> getAll() {
		
		List<GetAllSubCategoryResponse> subCategoryResponseList = subCategoryRepository.findAll().stream()
				.map(sC -> modelMapperService.forResponse().map(sC, GetAllSubCategoryResponse.class))
				.collect(Collectors.toList());
		
		return subCategoryResponseList;
	}

	@Override
	public List<GetAllActiveSubCategoryResponse> getAllActiveSubCategory() {
		
		List<GetAllActiveSubCategoryResponse> activeSubCategoryResponseList = subCategoryRepository.findAll().stream()
				.map(sC -> modelMapperService.forResponse().map(sC, GetAllActiveSubCategoryResponse.class))
				.collect(Collectors.toList());
		
		return activeSubCategoryResponseList;
	}
	
	
	@Override
	public List<GetAllActiveSubCategoryResponse> getAllSubCategoryByGenderId(int genderId) {
		
		List<GetAllActiveSubCategoryResponse> subCategoryByGenderResponseList = subCategoryRepository.getAllSubCategoriesByCategoryGenderId(genderId)
				.stream().map(sC -> modelMapperService.forResponse().map(sC, GetAllActiveSubCategoryResponse.class))
				.collect(Collectors.toList());
		
		return subCategoryByGenderResponseList;
		
	}
	
	
	
	@Override
	public void add(AddSubCategoryRequest addSubCategoryRequest) {
		
		SubCategory subCategory = modelMapperService.forRequest().map(addSubCategoryRequest, SubCategory.class);
		subCategory.setId(0);
		
		subCategory.setStatus(new Status());
		subCategory.getStatus().setId(1);
		
		subCategoryRepository.save(subCategory);

	}

	@Override
	public void update(UpdateSubCategoryRequest updateSubCategoryRequest) {
		
		SubCategory target = subCategoryRepository.findById(updateSubCategoryRequest.getId()).orElseThrow();
		
		target = modelMapperService.forRequest().map(updateSubCategoryRequest, SubCategory.class);
		
		subCategoryRepository.save(target);
		
		

	}

	@Override
	public void delete(int id) {
		
		SubCategory target = subCategoryRepository.findById(id).orElseThrow();
		
		if(target != null) {
			
			target.setStatus(new Status());
			target.getStatus().setId(2);
			
			subCategoryRepository.save(target);
			
		}
		

	}

	

	

	

}
