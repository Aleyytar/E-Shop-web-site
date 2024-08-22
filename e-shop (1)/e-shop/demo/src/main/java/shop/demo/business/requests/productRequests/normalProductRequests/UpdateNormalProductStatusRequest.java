package shop.demo.business.requests.productRequests.normalProductRequests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNormalProductStatusRequest {
	
	@NotNull
	private int id;
	
	@NotNull(message = "Product ID is required")
	private int productId;
	
	@NotNull(message = "Status ID is required")
	private int productStatusId;

}
