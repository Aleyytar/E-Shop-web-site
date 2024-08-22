import axios from "axios";

const baseUrl = "http://localhost:8080/api/customers";


export class CustomerService {
  async checkCustomerFields(email) {
    return await axios.get(
      `${baseUrl}/getcustomerbyaccountemail/${email}`
    )
  }

  async addCustomer(user){

    await axios.post(`${baseUrl}/add`,user)

  }

  async getCustomerById(id){
    try {
      const response = await axios.get(`${baseUrl}/getcustomerbyid/${id}`)
      return response.data
    } catch (error) {
      
    }
  }

  async updateCustomer(target){
    await axios.put(`${baseUrl}/update`,target)
  }

}
