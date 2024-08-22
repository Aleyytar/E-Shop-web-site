package shop.demo.business.responses.followerResponses.customerFollowerResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerFollowersByCustomerResponse {
	
	
	private int id;
	private int companyId;
	private String companyUsername;
	private String companyProfileUrl;
	

}
