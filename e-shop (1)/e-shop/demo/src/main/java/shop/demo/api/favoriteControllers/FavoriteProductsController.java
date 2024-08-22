package shop.demo.api.favoriteControllers;

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
import shop.demo.business.abstracts.favoriteServices.FavoriteProductService;
import shop.demo.business.requests.favoriteRequests.AddFavoriteProductRequest;
import shop.demo.business.responses.favoriteResponses.GetFavoriteProductResponse;

@RestController
@RequestMapping("/api/favoriteproducts")
@AllArgsConstructor
public class FavoriteProductsController {
	
	private FavoriteProductService favoriteProductService;
	
	@GetMapping("getallfavoriteproductsbycustomer/{customerId}")
	public List<GetFavoriteProductResponse> getAllFavoriteProductsByCustomerId(@PathVariable int customerId){
		
		return favoriteProductService.getAllFavoriteProductsByCustomerId(customerId);
		
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody AddFavoriteProductRequest addFavoriteProductRequest) {
		
		favoriteProductService.add(addFavoriteProductRequest);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		
		favoriteProductService.delete(id);
	}
}
