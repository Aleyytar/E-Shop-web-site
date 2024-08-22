package shop.demo.business.requests.categoryRequests.subCategoryRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import shop.demo.core.business.requests.AddRequest;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class AddSubCategoryRequest extends AddRequest{
	
	private int categoryId;
	private String name;

}
