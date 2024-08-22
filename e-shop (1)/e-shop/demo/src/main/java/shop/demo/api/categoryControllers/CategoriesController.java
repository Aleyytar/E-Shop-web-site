package shop.demo.api.categoryControllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.categoryServices.CategoryService;
import shop.demo.business.requests.categoryRequests.AddCategoryRequest;
import shop.demo.business.requests.categoryRequests.UpdateCategoryRequest;
import shop.demo.business.responses.categoryResponses.GetAllActiveCategoryResponse;
import shop.demo.business.responses.categoryResponses.GetAllCategoryResponse;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
@CrossOrigin
public class CategoriesController {
	
	private CategoryService categoryService;
	
	
	@GetMapping("/getall")
	public List<GetAllCategoryResponse> getAll(){
		
		return categoryService.getAll();
	}
	
	@GetMapping("/getallactivecategory")
	public List<GetAllCategoryResponse> getAllActiveCategory(){
		
		return categoryService.getAllActiveCategory();
	}
	
	@GetMapping("/getallmencategory") 
	public List<GetAllActiveCategoryResponse> getAllMenCategory(){ 
		
		return categoryService.getAllMenCategory();
	}
	
	@GetMapping("/getallwomencategory")
	public List<GetAllActiveCategoryResponse> getAllWomenCategory(){
		
		return categoryService.getAllWomenCategory();
	}
	
	@GetMapping("/getallunisexcategory")
	public List<GetAllActiveCategoryResponse> getAllUnisexCategory(){
		
		return categoryService.getAllUnisexCategory();
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody AddCategoryRequest addCategoryRequest) {
		
		categoryService.add(addCategoryRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateCategoryRequest updateCategoryRequest) {
		
		categoryService.update(updateCategoryRequest);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		
		categoryService.delete(id);
		
	}
	

}
