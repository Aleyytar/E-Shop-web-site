package shop.demo.business.concretes.photoManagers;

import java.io.IOException;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.photoServices.ProfilePhotoService;
import shop.demo.business.requests.photoRequests.profilePhotoRequests.AddProfilePhotoRequest;
import shop.demo.business.responses.photosResponses.profilePhotoResponses.GetProfilePhotoResponse;
import shop.demo.business.responses.photosResponses.profilePhotoResponses.UpdateProfilePhotoRequest;
import shop.demo.core.cloudinary.CloudinaryService;
import shop.demo.core.utilities.mappers.ModelMapperService;
import shop.demo.dataAccess.abstracts.ProfilePhotoRepository;
import shop.demo.entities.concretes.photos.ProfilePhoto;

@Service
@AllArgsConstructor
public class ProfilePhotoManager implements ProfilePhotoService {
	
	private ProfilePhotoRepository profilePhotoRepository;
	private CloudinaryService cloudinaryService;
	private ModelMapperService modelMapperService;
	
	
	@Override
	public GetProfilePhotoResponse getProfilePhotoByAccountId(int accountId) {
		
		ProfilePhoto target = profilePhotoRepository.getProfilePhotoByAccountId(accountId);
		
		if(target != null) {
			
			GetProfilePhotoResponse profilePhotoResponse = modelMapperService.forResponse().map(target, GetProfilePhotoResponse.class);
			
			return profilePhotoResponse;
			
		}
		
		return null;
	}

	@Override
	public void add(AddProfilePhotoRequest addProfilePhotoRequest) {
		
		ProfilePhoto profilePhoto = modelMapperService.forRequest().map(addProfilePhotoRequest, ProfilePhoto.class);
		profilePhoto.getPhoto().setId(0);
		profilePhoto.setId(0);
		
		try {
			String url = cloudinaryService.uploadFile(addProfilePhotoRequest.getUrl());
			
			profilePhoto.getPhoto().setUrl(url);
			
			System.out.println(profilePhoto.getPhoto().getUrl());
			
			profilePhotoRepository.save(profilePhoto);
			
		} catch (IOException e) { 
			 
			e.printStackTrace(); 
		}

	}

	@Override
	public void update(UpdateProfilePhotoRequest updateProfilePhotoRequest) {
		
		ProfilePhoto target = profilePhotoRepository.getProfilePhotoByAccountId(updateProfilePhotoRequest.getAccountId());
		
		if(target != null) {
			
			ProfilePhoto updatedProfilePhoto = modelMapperService.forRequest().map(updateProfilePhotoRequest, ProfilePhoto.class);
			updatedProfilePhoto.setId(target.getId());
			updatedProfilePhoto.getAccount().setId(target.getAccount().getId());
			
			
			
			try {
			
				String url = cloudinaryService.uploadFile(updateProfilePhotoRequest.getUrl());
				updatedProfilePhoto.getPhoto().setUrl(url);
				
				profilePhotoRepository.save(updatedProfilePhoto);
			
			}catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			
		}
		
		
	}

	@Override
	public void delete(int profilePhotoId) {
		
		profilePhotoRepository.deleteById(profilePhotoId);
		
		
	}

	

}
