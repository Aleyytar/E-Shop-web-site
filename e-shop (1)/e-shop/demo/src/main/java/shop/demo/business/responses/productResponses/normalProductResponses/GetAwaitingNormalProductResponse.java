package shop.demo.business.responses.productResponses.normalProductResponses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.demo.business.responses.photosResponses.productPhotoResponses.GetAllProductPhotosByProductResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAwaitingNormalProductResponse {
	
	private int id;
	private int productId;
	private int productSubCategoryId;
	private int productCompanyId;
	private int statusId;
	private int genderId;
	private String name;
	private String username;
	private String categoryName;
	private String description;
	private double minPrice;
	private double maxPrice;
	
	private List<GetAllProductPhotosByProductResponse> productPhotos;

}
