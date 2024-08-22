import { defineStore } from "pinia";

export const useGlobalProductStore = defineStore("globalProduct", {
  state: () => ({
    authorizeForUpdate: false,
  }),

  getters: {
    getAuthorizeForUpdate(state) {
      return state.authorizeForUpdate;
    },
  },

  actions: {
    setAuthorizeForUpdate(boolean) {
      this.authorizeForUpdate = boolean;
    },
  },
});
