package shop.demo.business.rules.photoRules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.core.utilities.exceptions.BusinessException;
import shop.demo.dataAccess.abstracts.ProductPhotoRepository;

@Service
@AllArgsConstructor
public class ProductPhotoBusinessRules implements BasePhotoBusinessRules {
	
	private ProductPhotoRepository productPhotoRepository;

	@Override
	public void checkPhotoCount(int productId) {
		
		int photoLength = productPhotoRepository.getProductPhotosByProductId(productId).size();
		
		if(photoLength >=5) {
			
			throw new BusinessException("İlgili ürüne en fazla 5 fotoğraf eklenebilir");
		}
		
	}
	
	
	

}
