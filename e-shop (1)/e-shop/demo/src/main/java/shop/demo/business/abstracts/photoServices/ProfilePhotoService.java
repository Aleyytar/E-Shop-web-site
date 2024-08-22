package shop.demo.business.abstracts.photoServices;

import shop.demo.business.abstracts.BaseService;
import shop.demo.business.requests.photoRequests.profilePhotoRequests.AddProfilePhotoRequest;
import shop.demo.business.responses.photosResponses.profilePhotoResponses.GetProfilePhotoResponse;
import shop.demo.business.responses.photosResponses.profilePhotoResponses.UpdateProfilePhotoRequest;

public interface ProfilePhotoService extends BaseService<AddProfilePhotoRequest, UpdateProfilePhotoRequest>{

	GetProfilePhotoResponse getProfilePhotoByAccountId(int accountId);
	void add(AddProfilePhotoRequest addProfilePhotoRequest);
	void update(UpdateProfilePhotoRequest updateProfilePhotoRequest);
	void delete(int profilePhotoId);
	
}
