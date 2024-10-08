package shop.demo.api.productControllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.productServices.ProductLikeService;
import shop.demo.business.requests.productLikeRequests.AddProductLikeRequest;
import shop.demo.business.responses.productLikeResponses.GetProductLikeRespone;

@RestController
@RequestMapping("/api/productlikes")
@AllArgsConstructor
public class ProductLikesController {

	private ProductLikeService productLikeService;
	
	@GetMapping("/getproductsbyproductid/{id}")
	public List<GetProductLikeRespone> getProductLikeByProductId(@PathVariable int id){
		
		return productLikeService.getProductLikeByProductId(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody AddProductLikeRequest addProductLikeRequest) {
		
		productLikeService.add(addProductLikeRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		
		productLikeService.delete(id);
	}
}
