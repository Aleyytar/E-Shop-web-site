package shop.demo.business.responses.colorResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllColorResponse {
	
	private int id;
	private int productId;
	private String name;

}
