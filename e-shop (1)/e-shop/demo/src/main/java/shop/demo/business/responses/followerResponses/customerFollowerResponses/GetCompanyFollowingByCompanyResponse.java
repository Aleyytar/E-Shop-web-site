package shop.demo.business.responses.followerResponses.customerFollowerResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCompanyFollowingByCompanyResponse {
	
	private int id;
	private String customerUsername;
	private String customerProfileUrl;
}
