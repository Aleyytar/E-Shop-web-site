package shop.demo.business.concretes.productManagers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.categoryServices.CategoryService;
import shop.demo.business.requests.categoryRequests.AddCategoryRequest;
import shop.demo.business.requests.categoryRequests.UpdateCategoryRequest;
import shop.demo.business.responses.categoryResponses.GetAllActiveCategoryResponse;
import shop.demo.business.responses.categoryResponses.GetAllCategoryResponse;
import shop.demo.core.utilities.mappers.ModelMapperService;
import shop.demo.dataAccess.abstracts.CategoryRepository;
import shop.demo.entities.abstracts.Category;
import shop.demo.entities.abstracts.Status;

@Service
@AllArgsConstructor
public class ProductCategoryManager implements CategoryService {

	private CategoryRepository categoryRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllCategoryResponse> getAll() {
		
		List<GetAllCategoryResponse> productCategoryResponseList = categoryRepository.findAll().stream()
				.map(productCategory -> modelMapperService.forResponse().map(productCategory, GetAllCategoryResponse.class))
				.collect(Collectors.toList());
		
		return productCategoryResponseList;
	}
	
	@Override
	public List<GetAllCategoryResponse> getAllActiveCategory() {
		
		List<GetAllCategoryResponse> activeProductCategoryResponseList = categoryRepository.getAllActiveCategories()
				.stream().map(pc -> modelMapperService.forResponse().map(pc, GetAllCategoryResponse.class))
				.collect(Collectors.toList());
		
		return activeProductCategoryResponseList;
	}
	
	@Override
	public List<GetAllActiveCategoryResponse> getAllMenCategory() {
		
		List<GetAllActiveCategoryResponse> activeMenCategoryList = categoryRepository.getAllMenCategories().stream()
				.map(pc -> modelMapperService.forResponse().map(pc, GetAllActiveCategoryResponse.class))
				.collect(Collectors.toList());
		
		return activeMenCategoryList;
		
	}

	@Override
	public List<GetAllActiveCategoryResponse> getAllWomenCategory() {
		
		List<GetAllActiveCategoryResponse> activeWomenCategoryList = categoryRepository.getAllWomenCategories().stream()
				.map(pc -> modelMapperService.forResponse().map(pc, GetAllActiveCategoryResponse.class))
				.collect(Collectors.toList());
		
		return activeWomenCategoryList;
	}

	@Override
	public List<GetAllActiveCategoryResponse> getAllUnisexCategory() {

		List<GetAllActiveCategoryResponse> activeUnisexCategoryList = categoryRepository.getAllUnisexCategories().stream()
				.map(pc -> modelMapperService.forResponse().map(pc, GetAllActiveCategoryResponse.class))
				.collect(Collectors.toList());
		
		return activeUnisexCategoryList;

	}

	@Override
	public void add(AddCategoryRequest addCategoryRequest) {
		
		Category category = modelMapperService.forRequest().map(addCategoryRequest, Category.class);
		category.setId(0);
		category.setStatus(new Status());
		category.getStatus().setId(1);
		
		categoryRepository.save(category);

	}

	@Override
	public void update(UpdateCategoryRequest updateCategoryRequest) {
		
		Category target = categoryRepository.findById(updateCategoryRequest.getId()).orElse(null);
		
		if(target != null) {
			
			target = modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
			
			categoryRepository.save(target);
			
		}
		

	}

	@Override
	public void delete(int id) {
		
		Category target = categoryRepository.findById(id).orElseThrow();
		
		target.setStatus(new Status());
		target.getStatus().setId(2);
		
		categoryRepository.save(target);

	}

	

	

}
