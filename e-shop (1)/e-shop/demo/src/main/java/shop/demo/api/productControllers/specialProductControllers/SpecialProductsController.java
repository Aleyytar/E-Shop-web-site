package shop.demo.api.productControllers.specialProductControllers;

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

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.productServices.specialProductServices.SpecialProductService;
import shop.demo.business.requests.productRequests.specialProductRequests.AddSpecialProductRequest;
import shop.demo.business.requests.productRequests.specialProductRequests.UpdateSpecialProductRequest;
import shop.demo.business.responses.productResponses.specialProductResponses.GetAllSpecialProductsByGender;
import shop.demo.business.responses.productResponses.specialProductResponses.GetSpecialProductResponse;

@RestController
@RequestMapping("/api/specialproducts")
@AllArgsConstructor
@CrossOrigin
public class SpecialProductsController {

	private SpecialProductService specialProductService;
	
	@GetMapping("/getspecialproductsbycompany/{companyId}")
	public List<GetSpecialProductResponse> getSpecialProductsByCompanyId(@PathVariable int companyId){
		
		return specialProductService.getSpecialProductsByCompanyId(companyId);
	}
	
	@GetMapping("/getallspecialproductsbygender/{id}")
	public List<GetAllSpecialProductsByGender> getSpecialProductsByGenderId(@PathVariable int genderId){
		
		return specialProductService.getSpecialProductsByGenderId(genderId);
	}
	
	@GetMapping("/getspecialproductbyid/{id}")
	public GetSpecialProductResponse getSpecialProductById(@PathVariable int id) {
		
		return specialProductService.getSpecialProductById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid AddSpecialProductRequest addSpecialProductRequest) {
		
		specialProductService.add(addSpecialProductRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody @Valid UpdateSpecialProductRequest updateSpecialProductRequest) {
		
		specialProductService.update(updateSpecialProductRequest);
		
	}
	
	@DeleteMapping("/delete/{specialProductId}")
	public void delete(@PathVariable int specialProductId) {
		
		specialProductService.delete(specialProductId);
	}
	
}
