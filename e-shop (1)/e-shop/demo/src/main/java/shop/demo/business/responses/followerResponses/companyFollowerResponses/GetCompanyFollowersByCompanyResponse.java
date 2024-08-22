package shop.demo.business.responses.followerResponses.companyFollowerResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCompanyFollowersByCompanyResponse {
	
	private int id;
	private int customerId;
	private String customerUsername;
	private String customerProfileUrl;
	

}
