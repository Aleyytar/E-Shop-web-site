package shop.demo.business.responses.colorResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductColorByProductResponse {
	
	private int id;
	private String colorName;
	

}
