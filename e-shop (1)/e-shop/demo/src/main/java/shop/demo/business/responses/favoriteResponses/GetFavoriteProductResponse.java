package shop.demo.business.responses.favoriteResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetFavoriteProductResponse {
	
	private int id;
	private String productName;
	private String productUrl;
	private String companyName;

}
