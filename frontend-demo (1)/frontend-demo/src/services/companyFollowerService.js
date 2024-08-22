
import axios from "axios";

const baseUrl = "http://localhost:8080/api/companyfollowers";


export class CompanyFollowerService{

    async add(companyFollower){
        await axios.post(`${baseUrl}/add`,companyFollower)
    }

    async getCompanyFollowerByCompanyId(companyId){
        try {
            const response = await axios.get(`${baseUrl}/getCompanyFollowersByCompany/${companyId}`)
            return response.data
        } catch (error) {
            throw error;
        }
    } 

    async getCustomerFollowingByCustomerId(customerId){
        try {
            const response = await axios.get(`${baseUrl}/getcustomerfollowingbycustomer/${customerId}`)
            return response.data
        } catch (error) {
            throw error;
        }
    }

    async delete(id){
        
        await axios.delete(`${baseUrl}/delete/${id}`)
        
    }



}