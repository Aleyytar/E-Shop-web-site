package shop.demo.business.requests.followerRequests.customerFollowerRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerFollowerRequest {
	
	private int customerId;
	private int companyId;

}
