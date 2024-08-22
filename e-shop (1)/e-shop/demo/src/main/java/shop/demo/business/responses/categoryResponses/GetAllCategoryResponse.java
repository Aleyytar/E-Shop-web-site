package shop.demo.business.responses.categoryResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCategoryResponse {
	
	private int id;
	private String statusName; 
	private String name;

}
