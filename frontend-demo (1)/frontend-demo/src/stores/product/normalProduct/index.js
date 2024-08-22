import axios from "axios";
import { defineStore } from "pinia";
import { NormalProductService } from "../../../services/normalProductService";

const baseUrl = "http://localhost:8080/api/normalproducts";

const normalProductService = new NormalProductService();

export const useNormalProductStore = defineStore("normalProduct", {
  state: () => ({
    products: [],
  }),

  getters: {
    getProducts(state) {
      return state.products;
    },
  },

  actions: {
    async setProducts() {
      const productResponse = await normalProductService.getActiveProducts();
      this.products = productResponse;
    },

    async setFilteredProducts(value) {
      const filteredProductResponse =
        await normalProductService.getActiveProductsBySearchValue(value);
      this.products = filteredProductResponse;
    },
  },
});
