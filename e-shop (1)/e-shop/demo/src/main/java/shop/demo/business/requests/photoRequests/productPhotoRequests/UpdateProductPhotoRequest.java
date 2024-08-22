package shop.demo.business.requests.photoRequests.productPhotoRequests;

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
public class UpdateProductPhotoRequest extends UpdateRequest {
	
	private int id;
	private int photoId;
	private MultipartFile url;

}
