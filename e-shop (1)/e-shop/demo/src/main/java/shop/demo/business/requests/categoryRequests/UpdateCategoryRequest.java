package shop.demo.business.requests.categoryRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import shop.demo.core.business.requests.UpdateRequest;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest extends UpdateRequest {
	
	private int id;
	private int statusId;
	private String name;
	

}
