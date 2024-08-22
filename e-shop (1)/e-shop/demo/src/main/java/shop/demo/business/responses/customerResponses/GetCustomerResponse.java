package shop.demo.business.responses.customerResponses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.demo.business.responses.favoriteResponses.GetFavoriteProductResponse;
import shop.demo.business.responses.followerResponses.customerFollowerResponses.GetCustomerFollowersByCustomerResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerResponse {
	
	
	private int id;
	private int statusId;
	private int accountId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String username;
	private String phoneNumber;
	private String url;
	private List<GetCustomerFollowersByCustomerResponse> customerFollowers;
	private List<GetFavoriteProductResponse> favoriteProducts;

}
