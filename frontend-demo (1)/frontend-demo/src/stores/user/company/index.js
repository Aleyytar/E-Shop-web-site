import { defineStore } from "pinia";
import { NormalProductService } from "../../../services/normalProductService";
import { CompanyService } from "../../../services/companyService";

const baseUrl = "http://localhost:8080/api/companies";

const normalProductService = new NormalProductService();
const companyService = new CompanyService();

export const useCompanyStore = defineStore("company", {
  state: () => ({
    activeProducts: [],
    awaitingProducts: [],
    passiveProducts: [],
    targetCompany: null,
    authorizeForUpdateProfile: false,
    canChangeProfilePhoto: false,
  }),

  getters: {
    getActiveProducts(state) {
      return state.activeProducts;
    },

    getActiveProductCount(state) {
      return state.activeProducts.length;
    },

    getAwaitingProducts(state) {
      return state.awaitingProducts;
    },
    getPassiveProducts(state) {
      return state.passiveProducts;
    },

    getTargetCompany(state) {
      return state.targetCompany;
    },
    getAuthorizeForUpdateProfile(state) {
      return state.authorizeForUpdateProfile;
    },
    getCanChangeProfilePhoto(state) {
      return state.canChangeProfilePhoto;
    },
  },

  actions: {
    async getActiveProductsByCompanyId(companyId) {
      try {
        const products =
          await normalProductService.getActiveProductsByCompanyId(companyId);
        this.activeProducts = products;
      } catch (error) {
        console.log("Failed to fetch awaiting products:", error);
      }
    },

    async getAwaitingProductsByCompanyId(companyId) {
      try {
        const products =
          await normalProductService.getAwaitingProductsByCompanyId(companyId);
        this.awaitingProducts = products;
      } catch (error) {
        console.log("Failed to fetch awaiting products:", error);
      }
    },

    async getPassiveProductsByCompanyId(companyId) {
      try {
        const products =
          await normalProductService.getPassiveProductsByCompanyId(companyId);
        this.passiveProducts = products;
      } catch (error) {
        console.log("Failed to fetch awaiting products:", error);
      }
    },

    async setTargetCompanyById(companyId) {
      try {
        const company = await companyService.getCompanyById(companyId);
        this.targetCompany = company.data;
      } catch (error) {
        throw error;
      }
    },

    setAuthorizeForUpdateProfile(status) {
      this.authorizeForUpdateProfile = status;
    },
    setCanChangeProfilePhoto(status) {
      this.canChangeProfilePhoto = status;
    },
  },
});
