package shop.demo.business.responses.categoryResponses.subCategoryResponses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.demo.business.responses.productResponses.normalProductResponses.GetAllNormalProductResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSubCategoryResponse {

	private int id;
	private String categoryName;
	private String name;
	private List<GetAllNormalProductResponse> products;
	
}
