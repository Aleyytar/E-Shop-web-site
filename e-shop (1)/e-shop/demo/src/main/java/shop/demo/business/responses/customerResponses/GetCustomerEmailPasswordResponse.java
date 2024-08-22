package shop.demo.business.responses.customerResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerEmailPasswordResponse {
	
	private int id;
	private int accountId;
	private String email;
	private String password;

}
