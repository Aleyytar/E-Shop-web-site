import { defineStore } from "pinia";

export const useGlobalStore = defineStore("global", {
  state: () => ({
    isCompanyRegisterForm: true,
    isCompanyLoginForm:true,
    showProductAddDialog:false,
  }),

  getters: {
    getIsCompanyRegisterForm(state) {
      return state.isCompanyRegisterForm;
    },
    getIsCompanyLoginForm(state) {
      return state.isCompanyLoginForm;
    },
    getShowProductAddDialog(state){
      return state.showProductAddDialog;
    }
  },

  actions: {
    changeRegisterForm() {
      this.isCompanyRegisterForm = !this.isCompanyRegisterForm;
    },
    changeLoginForm() {
      this.isCompanyLoginForm = !this.isCompanyLoginForm;
    },

    changeShowProductAddDialog(){
      this.showProductAddDialog = !this.showProductAddDialog;
    }
  },
});
