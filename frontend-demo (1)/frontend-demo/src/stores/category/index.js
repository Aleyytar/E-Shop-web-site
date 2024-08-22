import axios from "axios";
import { defineStore } from "pinia";

const baseUrl = "http://localhost:8080/api/categories";

export const useCategoryStore = defineStore("category", {
  state: () => ({
    status: false,
    categoryList: {
      manCategory: {
        name: "Man",
        categories: [],
      },
      womanCategory: {
        name: "Woman",
        categories: [],
      },
      unisexCategory: {
        name: "Unisex",
        categories: [],
      },
    },

    
  }),

  getters: {
    getCategoryList(state) {
      return state.categoryList;
    },
    getStatus(state) {
      return state.status;
    },
  },

  actions: {
    async getAllMenCategory() {
      axios.get(`${baseUrl}/getallmencategory`).then((response) => {
        response.status == 200
          ? (this.categoryList.manCategory.categories = response.data)
          : [];
      });
    },

    async getAllWomenCategory() {
      axios.get(`${baseUrl}/getallwomencategory`).then((response) => {
        response.status == 200
          ? (this.categoryList.womanCategory.categories = response.data)
          : [];
      });
    },
    async getAllUnisexCategory() {
      axios.get(`${baseUrl}/getallunisexcategory`).then((response) => {
        response.status == 200
          ? (this.categoryList.unisexCategory.categories = response.data)
          : [];
      });
    },

    changeStatus() {
      this.status = !this.status;
    },
  },
});
