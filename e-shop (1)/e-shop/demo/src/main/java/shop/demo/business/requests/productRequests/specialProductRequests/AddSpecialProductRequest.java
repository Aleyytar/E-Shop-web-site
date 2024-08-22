package shop.demo.business.requests.productRequests.specialProductRequests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSpecialProductRequest {
	
	@NotNull(message = "Company ID is required")
	private int productCompanyId;
	
	@NotNull(message = "Sub category ID is required")
	private int productSubCategoryId;
	
	@NotNull(message = "Gender ID is required")
	private int productGenderId;
	
	@NotBlank(message = "Product name is required")
	@Size(min = 3,message = "Product name's length should be more than 3")
	private String productName;
	
	@NotBlank(message = "Product description is required")
	@Size(min = 20,message = "Product description's length should be more than 20")
	private String productDescription;
	
	@Min(0)
	@NotNull(message = "Min Price is required")
	private double productMinPrice;
	
	@NotNull(message = "Max Price is required")
	private double productMaxPrice;

}
