package shop.demo.business.responses.categoryResponses.subCategoryResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllGenderSubCategoryResponse {
	
	private int id;
	private String name;
	private String categoryName;

}
