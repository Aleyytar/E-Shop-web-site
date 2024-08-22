package shop.demo.business.abstracts.favoriteServices;

import java.util.List;

import shop.demo.business.requests.favoriteRequests.AddFavoriteProductRequest;
import shop.demo.business.responses.favoriteResponses.GetFavoriteProductResponse;

public interface FavoriteProductService {
	
	List<GetFavoriteProductResponse> getAllFavoriteProductsByCustomerId(int customerId);
	void add(AddFavoriteProductRequest addFavoriteProductRequest);
	void delete(int id);

}
