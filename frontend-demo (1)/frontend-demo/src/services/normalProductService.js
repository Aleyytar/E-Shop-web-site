import axios from "axios";

const baseUrl = "http://localhost:8080/api/normalproducts";

export class NormalProductService {
  async add(product) {
    await axios.post(`${baseUrl}/add`, product);
  }

  async getActiveProductsByCompanyId(companyId) {
    try {
      const response = await axios.get(
        `${baseUrl}/getallnormalproductsbycompanyandstatus/${companyId}/1`
      );
      return response.data;
    } catch (error) {
      console.log(error);
      throw error;
    }
  }

  async getAwaitingProductsByCompanyId(companyId) {
    try {
      const response = await axios.get(
        `${baseUrl}/getallnormalproductsbycompanyandstatus/${companyId}/3`
      );
      return response.data;
    } catch (error) {
      console.log(error);
      throw error;
    }
  }

  async getPassiveProductsByCompanyId(companyId) {
    try {
      const response = await axios.get(
        `${baseUrl}/getallnormalproductsbycompanyandstatus/${companyId}/2`
      );
      return response.data;
    } catch (error) {
      console.log(error);
      throw error;
    }
  }

  async getProductById(id) {
    try {
      const response = await axios.get(`${baseUrl}/getproductbyid/${id}`);
      return response.data;
    } catch (error) {
        throw error;
    }
  }

  async update(product) {
    await axios.put(`${baseUrl}/update`, product);
  }

  async getActiveProducts(){
    try {
      const response = await axios.get(`${baseUrl}/getallactivenormalproducts`)
      return response.data
    } catch (error) {
      throw error
    }
  }

  async getActiveProductsBySearchValue(value){
    try {
      const products = await axios.get(`${baseUrl}/getallnormalproductnamecontaining/${value}`);
      return products.data
    } catch (error) {
      throw error;
    }
  }
}
