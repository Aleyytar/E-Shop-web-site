import axios from "axios";

const baseUrl = "http://localhost:8080/api/productphotos";


export class ProductPhotoService {
  
  async addPhoto(file){

    await axios.post(`${baseUrl}/add`,file,{
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      })
  }

  async deletePhoto(id){
    await axios.delete(`${baseUrl}/delete/${id}`)
  }

  async getPhotosByProductId(id){
    try {
      const response = await axios.get(`${baseUrl}/getproductphotosbyproductid/${id}`)
      return response
    } catch (error) {
      throw error;
    }
  }

  

}
