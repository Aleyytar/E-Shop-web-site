package shop.demo.business.responses.productResponses.normalProductResponses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Silinebilir

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetNormalProductForUpdateResponse {
	
	private int id;
	private int productId;
	private int companyAccountId;
	private int productSubCategoryId;
	private int productGenderId;
	private String name;
	private String companyName;
	private String description;
	private double minPrice;
	private double maxPrice;
}
