package shop.demo.business.responses.companyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCompanyEmailPasswordResponse {
	
	private int id;
	private int accountId;
	private String accountUsername;
	private String companyName;
	private String email;
	private String password;
	
}
