package shop.demo.business.requests.followerRequests.companyFollowerRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCompanyFollowerRequest {
	
	private int companyId;
	private int customerId;

}
