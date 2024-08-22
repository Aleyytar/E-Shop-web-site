package shop.demo.business.requests.favoriteRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFavoriteProductRequest {
	
	private int customerId;
	private int productId;

}
