package shop.demo.business.abstracts.colorsServices;

import java.util.List;

import shop.demo.business.requests.colorRequests.AddColorRequest;
import shop.demo.business.responses.colorResponses.GetAllColorResponse;

public interface ColorService {
	
	List<GetAllColorResponse> getAll();
	List<GetAllColorResponse> getColorsByProductId(int id);
	void add(AddColorRequest addColorRequest);
	void delete(int id);

}
