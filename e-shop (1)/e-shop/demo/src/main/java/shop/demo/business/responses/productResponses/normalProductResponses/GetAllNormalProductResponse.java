package shop.demo.business.responses.productResponses.normalProductResponses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.demo.business.responses.colorResponses.GetProductColorByProductResponse;
import shop.demo.business.responses.photosResponses.productPhotoResponses.GetAllProductPhotosByProductResponse;
import shop.demo.business.responses.productCommentResponses.GetProductCommentResponse;
import shop.demo.business.responses.productDislikeResponses.GetProductDislikeResponse;
import shop.demo.business.responses.productLikeResponses.GetProductLikeRespone;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllNormalProductResponse {
	
	private int id;
	private int productId;
	private String name;
	private String username;
	private String categoryName;
	private String description;
	private double minPrice;
	private double maxPrice;
	private List<GetAllProductPhotosByProductResponse> productPhotos;
	private List<GetProductColorByProductResponse> productColors;
	private List<GetProductCommentResponse> comments;
	private List<GetProductLikeRespone> productLikes;
	private List<GetProductDislikeResponse> productDislikes;
	private String statusName;
	private String genderName;

}
