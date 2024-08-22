import { defineStore } from "pinia";
import { CustomerService } from "../../../services/customerService";

const customerService = new CustomerService();

export const useCustomerStore = defineStore("customer", {
  state: () => ({
    targetCustomer: null,
    canChangeProfilePhoto: false,
    authorizeForUpdateProfile: false,
  }),
  getters: {
    getTargetCustomer(state) {
      return state.targetCustomer;
    },

    getCanChangeProfilePhoto(state) {
      return state.canChangeProfilePhoto;
    },

    getAuthorizeForUpdateProfile(state) {
      return state.authorizeForUpdateProfile;
    },
  },
  actions: {
    setCanChangeProfilePhoto(status) {
      this.canChangeProfilePhoto = status;
    },

    async setTargetCustomer(customerId) {
      try {
        const customer = await customerService.getCustomerById(customerId);
        this.targetCustomer = customer;
      } catch (error) {
        throw error;
      }
    },

    setAuthorizeForUpdateProfile(status) {
      this.authorizeForUpdateProfile = status;
    },
  },
});
