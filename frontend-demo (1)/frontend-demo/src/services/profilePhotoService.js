
import axios from "axios";

const baseUrl = "http://localhost:8080/api/profilephotos";

export class ProfilePhotoService {
  async getAccountProfilePhotoById(accountId) {
    return axios.get(
      `${baseUrl}/getprofilephotobyaccountid/${accountId}`
    )
  }

  async updateProfilePhoto(data){
    await axios.put(`${baseUrl}/update`,data,{
      headers: {
        'Content-Type': 'multipart/form-data'
      }})
  }

  async addProfilePhoto(data){
    await axios.post(`${baseUrl}/add`,data,{
      headers: {
        'Content-Type': 'multipart/form-data'
      }})
  }

}





