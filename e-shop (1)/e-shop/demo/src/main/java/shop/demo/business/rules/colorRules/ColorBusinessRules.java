package shop.demo.business.rules.colorRules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.core.utilities.exceptions.BusinessException;
import shop.demo.dataAccess.abstracts.ColorRepository;

@AllArgsConstructor
@Service
public class ColorBusinessRules implements BaseColorBusinessRules{
	
	private ColorRepository colorRepository;

	@Override
	public void checkColorCountOfProduct(int productId) {
		
		int colorLength = colorRepository.getColorsByProductId(productId).size();
		
		if(colorLength >= 4) {
			throw new BusinessException("You can add only four colors to product");
		}
		
	}

}
