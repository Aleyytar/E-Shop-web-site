package shop.demo.business.responses.categoryResponses.subCategoryResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllActiveSubCategoryResponse {
	
	private int id;
	private String name;

}
