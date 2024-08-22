package shop.demo.business.requests.productCommentRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import shop.demo.core.business.requests.AddRequest;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class AddProductCommentRequest extends AddRequest{
	
	private int productId;
	private int accountId;
	private String text;

}
