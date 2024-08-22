package shop.demo.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.photoServices.ProfilePhotoService;
import shop.demo.business.requests.photoRequests.profilePhotoRequests.AddProfilePhotoRequest;
import shop.demo.business.responses.photosResponses.profilePhotoResponses.GetProfilePhotoResponse;
import shop.demo.business.responses.photosResponses.profilePhotoResponses.UpdateProfilePhotoRequest;

@RestController
@RequestMapping("/api/profilephotos")
@AllArgsConstructor
@CrossOrigin
public class ProfilePhotosController {
	
	private ProfilePhotoService profilePhotoService;
	
	
	@GetMapping("/getprofilephotobyaccountid/{accountId}")
	public GetProfilePhotoResponse getProfilePhotoByAccountId(@PathVariable int accountId) {
		
		
		return profilePhotoService.getProfilePhotoByAccountId(accountId);
		
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(AddProfilePhotoRequest addProfilePhotoRequest) {
		
		profilePhotoService.add(addProfilePhotoRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateProfilePhotoRequest updateProfilePhotoRequest) {
		
		profilePhotoService.update(updateProfilePhotoRequest);
	}
	
	@DeleteMapping("/delete/{profilePhotoId}")
	public void delete(@PathVariable int profilePhotoId) {
		
		profilePhotoService.delete(profilePhotoId);
	}
	
	

}
