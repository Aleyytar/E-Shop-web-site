import axios from "axios";

const baseUrl = "http://localhost:8080/api/companies";


export class CompanyService {
  async checkCompanyFields(email) {
    return await axios.get(
      `${baseUrl}/getcompanybyaccountemail/${email}`
    )
  }

   async addCompany(company){

    await axios.post(`${baseUrl}/add`,company)

  }
  
  async updateCompany(targetCompany){
    await axios.put(`${baseUrl}/update`,targetCompany)
  }

  
  async getCompanyById(id){
    return await axios.get(`${baseUrl}/getcompanybyid/${id}`)
  }


}
