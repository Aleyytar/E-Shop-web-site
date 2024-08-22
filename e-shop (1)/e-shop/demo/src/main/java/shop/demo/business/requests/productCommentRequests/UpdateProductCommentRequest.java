package shop.demo.business.requests.productCommentRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import shop.demo.core.business.requests.UpdateRequest;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductCommentRequest extends UpdateRequest {
	
	private int id;
	private int accountId;
	private int productId;
	private String text;

}
