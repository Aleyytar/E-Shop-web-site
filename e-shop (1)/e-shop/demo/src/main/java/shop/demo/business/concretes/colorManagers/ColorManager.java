package shop.demo.business.concretes.colorManagers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.colorsServices.ColorService;
import shop.demo.business.requests.colorRequests.AddColorRequest;
import shop.demo.business.responses.colorResponses.GetAllColorResponse;
import shop.demo.business.rules.colorRules.ColorBusinessRules;
import shop.demo.core.utilities.mappers.ModelMapperService;
import shop.demo.dataAccess.abstracts.ColorRepository;
import shop.demo.entities.abstracts.Color;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
	
	private ColorRepository colorRepository;
	private ModelMapperService modelMapperService;
	private ColorBusinessRules colorBusinessRules;

	@Override
	public List<GetAllColorResponse> getAll() {
		
		List<GetAllColorResponse> colorResponseList = colorRepository.findAll().stream().map(color ->
		modelMapperService.forResponse().map(color, GetAllColorResponse.class)).collect(Collectors.toList());
		
		return colorResponseList;
	}
	
	@Override
	public List<GetAllColorResponse> getColorsByProductId(int id) {
		
		List<GetAllColorResponse> colorResponseList = colorRepository.getColorsByProductId(id).stream().map(color ->
		modelMapperService.forResponse().map(color, GetAllColorResponse.class)).collect(Collectors.toList());
		
		return colorResponseList;
	}

	@Override
	public void add(AddColorRequest addColorRequest) {
		
		colorBusinessRules.checkColorCountOfProduct(addColorRequest.getProductId());
		
		Color color = modelMapperService.forRequest().map(addColorRequest, Color.class);
		color.setId(0);
		
		colorRepository.save(color);

	}

	@Override
	public void delete(int id) {

		colorRepository.deleteById(id);

	}

	

}
