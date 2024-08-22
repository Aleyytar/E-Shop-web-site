package shop.demo.api.productControllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.photoServices.ProductPhotoService;
import shop.demo.business.requests.photoRequests.productPhotoRequests.AddProductPhotoRequest;
import shop.demo.business.requests.photoRequests.productPhotoRequests.UpdateProductPhotoRequest;
import shop.demo.business.responses.photosResponses.productPhotoResponses.GetAllProductPhotosByProductResponse;

@RestController
@RequestMapping("/api/productphotos")
@AllArgsConstructor
@CrossOrigin
public class ProductPhotosController {
	
	private ProductPhotoService productPhotoService;
	
	@GetMapping("/getproductphotosbyproductid/{id}")
	public List<GetAllProductPhotosByProductResponse> getProductPhotosByProductId(@PathVariable int id){
		
		return productPhotoService.getProductPhotosByProductId(id);
	}
	
	@PostMapping("/add")
	public void add(AddProductPhotoRequest addProductPhotoRequest) {
		
		productPhotoService.add(addProductPhotoRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateProductPhotoRequest updateProductPhotoRequest) {  
		
		productPhotoService.update(updateProductPhotoRequest);
		
	}
	 
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		
		productPhotoService.delete(id);
		
	}

}
