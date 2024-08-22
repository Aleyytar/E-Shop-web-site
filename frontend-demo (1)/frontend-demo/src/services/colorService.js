import axios from "axios";

const baseUrl = "http://localhost:8080/api/colors";



export class ColorService{


    async add(color){
        await axios.post(`${baseUrl}/add`,color)
    }

    async getColorByProductId(productId){
        try {
            const response = await axios.get(`${baseUrl}/getcolorsbyproduct/${productId}`)
            return response
        } catch (error) {
            throw error;
        }
    }

    async delete(id){

        await axios.delete(`${baseUrl}/delete/${id}`)
    }


}


