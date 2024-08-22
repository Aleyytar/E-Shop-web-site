package shop.demo.api.categoryControllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.categoryServices.SubCategoryService;
import shop.demo.business.requests.categoryRequests.subCategoryRequests.AddSubCategoryRequest;
import shop.demo.business.requests.categoryRequests.subCategoryRequests.UpdateSubCategoryRequest;
import shop.demo.business.responses.categoryResponses.subCategoryResponses.GetAllActiveSubCategoryResponse;
import shop.demo.business.responses.categoryResponses.subCategoryResponses.GetAllSubCategoryResponse;

@RestController
@RequestMapping("/api/subcategories")
@AllArgsConstructor
@CrossOrigin
public class SubCategoriesController {
	
	private SubCategoryService subCategoryService;
	
	
	@GetMapping("/getall")
	public List<GetAllSubCategoryResponse> getAll(){
		
		return subCategoryService.getAll();
		
	}
	
	@GetMapping("/getallactivesubcategories")
	public List<GetAllActiveSubCategoryResponse> getAllActiveSubCategory(){
		
		 
		return subCategoryService.getAllActiveSubCategory();
	}
	
	@GetMapping("getallsubcategorybygender/{genderId}")
	public List<GetAllActiveSubCategoryResponse> getAllSubCategoryByGenderId(@PathVariable int genderId) {
		
		return subCategoryService.getAllSubCategoryByGenderId(genderId);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody AddSubCategoryRequest addSubCategoryRequest) {
		
		subCategoryService.add(addSubCategoryRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateSubCategoryRequest updateSubCategoryRequest) {
		
		subCategoryService.update(updateSubCategoryRequest);
	} 
	
	@DeleteMapping("/delete/{id}")
	public void delete(@RequestParam int id) {
		
		subCategoryService.delete(id);
	}
	
}
