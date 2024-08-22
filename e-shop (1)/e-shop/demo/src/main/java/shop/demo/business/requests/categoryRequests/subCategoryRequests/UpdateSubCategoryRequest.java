package shop.demo.business.requests.categoryRequests.subCategoryRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import shop.demo.core.business.requests.UpdateRequest;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSubCategoryRequest extends UpdateRequest {
	
	private int id;
	private String name;

}
