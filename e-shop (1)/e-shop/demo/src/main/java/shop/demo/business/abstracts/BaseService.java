package shop.demo.business.abstracts;

import shop.demo.core.business.requests.AddRequest;
import shop.demo.core.business.requests.UpdateRequest;

public interface BaseService<AddEntityRequest extends AddRequest,UpdateEntityRequest extends UpdateRequest>  {
	
	void add(AddEntityRequest addEntityRequest);
	void update(UpdateEntityRequest updateEntityRequest);
	void delete(int id);

}
