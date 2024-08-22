
import axios from "axios";

const baseUrl = "http://localhost:8080/api/customerfollowers";


export class CustomerFollowerService{


    async add(customerFollower){
        await axios.post(`${baseUrl}/add`,customerFollower)
    }

    async getCustomerFollowerByCustomerId(customerId){
        try {
            const response = await axios.get(`${baseUrl}/getcustomerfollowersbycustomerid/${customerId}`)
            return response.data
        } catch (error) {
            throw error
        }
    }

    async getCompanyFollowingByCompanyId(companyId){
        try {
            const response = await axios.get(`${baseUrl}/getcompanyfollowingbycompanyid/${companyId}`)
            return response.data
        } catch (error) {
            throw error;
        }
    }

    async delete(id){
        await axios.delete(`${baseUrl}/delete/${id}`)
    }



}