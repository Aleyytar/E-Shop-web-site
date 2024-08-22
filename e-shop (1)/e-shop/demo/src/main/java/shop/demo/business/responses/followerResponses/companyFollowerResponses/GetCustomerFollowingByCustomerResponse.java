package shop.demo.business.responses.followerResponses.companyFollowerResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerFollowingByCustomerResponse {
	
	private int id;
	private String companyUsername;
	private String companyProfileUrl;
}
