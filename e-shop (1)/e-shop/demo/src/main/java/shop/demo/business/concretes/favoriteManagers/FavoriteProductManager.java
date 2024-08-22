package shop.demo.business.concretes.favoriteManagers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.favoriteServices.FavoriteProductService;
import shop.demo.business.requests.favoriteRequests.AddFavoriteProductRequest;
import shop.demo.business.responses.favoriteResponses.GetFavoriteProductResponse;
import shop.demo.core.utilities.mappers.ModelMapperService;
import shop.demo.dataAccess.abstracts.FavoriteProductRepository;
import shop.demo.entities.concretes.favorites.FavoriteProduct;

@Service
@AllArgsConstructor
public class FavoriteProductManager implements FavoriteProductService {
	
	private FavoriteProductRepository favoriteProductRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetFavoriteProductResponse> getAllFavoriteProductsByCustomerId(int customerId) {
		
		List<GetFavoriteProductResponse> favoriteProductResponseList = favoriteProductRepository.getAllFavoriteProductsByCustomerId(customerId)
				.stream().map(favoriteProduct -> modelMapperService.forResponse()
				.map(favoriteProduct, GetFavoriteProductResponse.class)).collect(Collectors.toList());
		
		return favoriteProductResponseList;
	}

	@Override
	public void add(AddFavoriteProductRequest addFavoriteProductRequest) {
		
		FavoriteProduct favoriteProduct = modelMapperService.forRequest().map(addFavoriteProductRequest, FavoriteProduct.class);
		favoriteProduct.setId(0);
		
		favoriteProductRepository.save(favoriteProduct);
		
	}

	@Override
	public void delete(int id) {
		
		favoriteProductRepository.deleteById(id);
		
	}

}
