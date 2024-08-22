package shop.demo.business.responses.photosResponses.profilePhotoResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProfilePhotoResponse {
	
	private int id;
	private int accountId;
	private String url;

}
