package shop.demo.business.responses.categoryResponses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.demo.business.responses.categoryResponses.subCategoryResponses.GetAllActiveSubCategoryResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllActiveCategoryResponse {

	private int id;
	private String name;
	private List<GetAllActiveSubCategoryResponse> subCategories;
}
