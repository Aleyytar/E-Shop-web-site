package shop.demo.business.abstracts.productServices;

import java.util.List;

import shop.demo.business.abstracts.BaseService;
import shop.demo.business.requests.productCommentRequests.AddProductCommentRequest;
import shop.demo.business.requests.productCommentRequests.UpdateProductCommentRequest;
import shop.demo.business.responses.productCommentResponses.GetProductCommentResponse;

public interface ProductCommentService extends BaseService<AddProductCommentRequest, UpdateProductCommentRequest>{
	
	List<GetProductCommentResponse> getProductCommentsByProductId(int id);
	
	

}
