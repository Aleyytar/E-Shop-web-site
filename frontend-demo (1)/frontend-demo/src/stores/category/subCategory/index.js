import axios from "axios";
import { defineStore } from "pinia";

const baseUrl = "http://localhost:8080/api/subcategories";

export const useSubCategoryStore = defineStore("subCategory", {
  state: () => ({
    
    menSubCategories:[],
    womenSubCategories:[],
    unisexSubCategories:[]
    
  }),

  getters: {

    getMenSubCategory(state){
        return state.menSubCategories;
    },
    getWomenSubCategory(state){
        return state.womenSubCategories;
    },
    getUnisexSubCategory(state){
        return state.unisexSubCategories;
    }
    
  },

  actions: {
    async getAllMenSubCategories(){

        await axios.get(`${baseUrl}/getallsubcategorybygender/1`).then(response => {
            this.menSubCategories = response.data
        })
    },
    async getAllWomenSubCategories(){

        await axios.get(`${baseUrl}/getallsubcategorybygender/2`).then(response => {
            this.womenSubCategories = response.data
        })
    },
    async getAllUnisexSubCategories(){

        await axios.get(`${baseUrl}/getallsubcategorybygender/3`).then(response => {
            this.unisexSubCategories = response.data
        })
    }

    
  },
});
