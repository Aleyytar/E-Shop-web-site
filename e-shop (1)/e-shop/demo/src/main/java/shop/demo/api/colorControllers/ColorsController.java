package shop.demo.api.colorControllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import shop.demo.business.abstracts.colorsServices.ColorService;
import shop.demo.business.requests.colorRequests.AddColorRequest;
import shop.demo.business.responses.colorResponses.GetAllColorResponse;

@RestController
@RequestMapping("/api/colors")
@AllArgsConstructor
@CrossOrigin
public class ColorsController {
	
	private ColorService colorService;
	
	@GetMapping("/getall")
	public List<GetAllColorResponse> getAll(){
		
		return colorService.getAll();
	}
	
	@GetMapping("/getcolorsbyproduct/{id}")
	public List<GetAllColorResponse> getColorsByProductId(@PathVariable int id) {
		
		return colorService.getColorsByProductId(id);
		
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody AddColorRequest addColorRequest) {
		
		colorService.add(addColorRequest);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		
		colorService.delete(id);
		
	}

}
