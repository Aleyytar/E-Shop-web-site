package shop.demo.business.responses.companyResponses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.demo.business.responses.followerResponses.companyFollowerResponses.GetCompanyFollowersByCompanyResponse;
import shop.demo.business.responses.photosResponses.profilePhotoResponses.GetProfilePhotoResponse;
import shop.demo.business.responses.productResponses.normalProductResponses.GetAllNormalProductResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCompanyResponse {
	
	private int id;
	private int accountId;
	private int statusId;
	private int photoId;
	private String companyName;
	private String description;
	private String email;
	private String username;
	private String password;
	private String phoneNumber;
	private String url;
	private List<GetAllNormalProductResponse> products;
	private List<GetCompanyFollowersByCompanyResponse> companyFollowers;
	
	

}
