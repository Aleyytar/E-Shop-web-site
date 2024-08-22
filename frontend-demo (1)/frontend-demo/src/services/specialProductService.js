
import axios from "axios";

const baseUrl = "http://localhost:8080/api/specialproducts";

export class SpecialProductService {
  
    async add(product){
        await axios.post(`${baseUrl}/add`,product)
    }

}





