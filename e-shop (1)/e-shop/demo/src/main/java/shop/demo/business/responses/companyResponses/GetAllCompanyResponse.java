package shop.demo.business.responses.companyResponses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.demo.business.responses.productResponses.normalProductResponses.GetNormalProductsByCompanyResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCompanyResponse {
	
	private int id;
	private String companyName;
	private String description;
	private String email;
	private String username;
	private String phoneNumber;
	private String url;
	private String statusName;
	private List<GetNormalProductsByCompanyResponse> products;

}
