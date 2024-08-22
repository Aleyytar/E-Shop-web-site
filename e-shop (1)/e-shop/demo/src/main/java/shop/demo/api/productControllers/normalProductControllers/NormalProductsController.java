package shop.demo.api.productControllers.normalProductControllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.productServices.normalProductServices.NormalProductService;
import shop.demo.business.requests.productRequests.normalProductRequests.AddNormalProductRequest;
import shop.demo.business.requests.productRequests.normalProductRequests.UpdateNormalProductRequest;
import shop.demo.business.responses.productResponses.normalProductResponses.GetAllActiveNormalProductResponse;
import shop.demo.business.responses.productResponses.normalProductResponses.GetAllNormalProductResponse;
import shop.demo.business.responses.productResponses.normalProductResponses.GetAllNormalProductsByGender;
import shop.demo.business.responses.productResponses.normalProductResponses.GetAwaitingNormalProductResponse;
import shop.demo.business.responses.productResponses.normalProductResponses.GetNormalProductResponse;

@RestController
@RequestMapping("/api/normalproducts")
@AllArgsConstructor
@CrossOrigin
public class NormalProductsController {

	private NormalProductService normalProductService;
	
	@GetMapping("/getall")
	public List<GetAllNormalProductResponse> getAll(){
		
		return normalProductService.getAll();
	}
	
	@GetMapping("/getproductsbyproductcategoryid/{id}")
	public List<GetAllNormalProductResponse> getNormalProductsByProductCategoryId(@PathVariable int id){
		
		
		return normalProductService.getNormalProductsByProductCategoryId(id);
		
	}
	
	@GetMapping("/getallactivenormalproducts")
	public List<GetAllActiveNormalProductResponse> getAllActiveNormalProducts(){
		
		return normalProductService.getAllActiveNormalProducts();
	}
	
	@GetMapping("/getallnormalproductnamecontaining/{value}")
	public List<GetAllActiveNormalProductResponse> getAllNormalProductNameContaining(@PathVariable String value) {
		
		return normalProductService.getAllNormalProductNameContaining(value);
	}
	
	@GetMapping("/getallnormalproductsbygender/{genderId}")
	public List<GetAllNormalProductsByGender> getAllNormalProductsByGenderId(@PathVariable int genderId){
		
		return normalProductService.getAllNormalProductsByGenderId(genderId);
	}
	
	@GetMapping("/getallnormalproductsbycompanyandstatus/{companyId}/{statusId}")
	public List<GetAwaitingNormalProductResponse> getAllNormalProductByCompanyIdAndStatusId(@PathVariable("companyId") int companyId,@PathVariable("statusId") int statusId){
		
		return normalProductService.getAllNormalProductByCompanyIdAndStatusId(companyId, statusId);
	}
	
	@GetMapping("/getproductbyid/{id}")
	public GetNormalProductResponse getProductById(@PathVariable int id) {
		
		return normalProductService.getProductById(id);
		
	}
	
	@PostMapping("/add")
	public void add(@RequestBody @Valid AddNormalProductRequest addProductRequest) {
		
		normalProductService.add(addProductRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody @Valid UpdateNormalProductRequest updateNormalProductRequest) {
		
		normalProductService.update(updateNormalProductRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		
		normalProductService.delete(id);
	}
	
	
}
