package shop.demo.business.responses.photosResponses.profilePhotoResponses;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import shop.demo.core.business.requests.UpdateRequest;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfilePhotoRequest extends UpdateRequest {
	
	private int id;
	private int accountId;
	private MultipartFile url;

}
