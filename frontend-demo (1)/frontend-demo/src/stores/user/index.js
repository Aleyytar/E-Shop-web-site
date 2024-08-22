import { defineStore } from "pinia";
import createPersistedState from "pinia-persistedstate";
import SecureLS from "secure-ls";
import { ProfilePhotoService } from "../../services/profilePhotoService";

var ls = new SecureLS({ isCompression: false });

const profilePhotoService = new ProfilePhotoService();

export const useUserStore = defineStore("user", {
  persist: true,

  state: () => ({
    isLogin: false,
    activeUser: null,
    isCompanyAccount: false,
    profilePhoto:null,
    profileDetailPhoto:null,
    defaultProfilePhoto:
      "https://res.cloudinary.com/dvjylxwa1/image/upload/v1715694796/samples/ng30dhamfcy80q6cwjft.png",
  }),

  getters: {
    getIsLogin(state) {
      return state.isLogin;
    },

    getActiveUser(state) {
      return state.activeUser;
    },

    getActiveUserAccountId(state) {
      return state.activeUser.accountId;
    },

    getActiveUserId(state) {
      return state.activeUser?.id;
    },

    getIsCompanyAccount(state) {
      return state.isCompanyAccount;
    },

    getCompanyAccountId(state) {
      if (this.isCompanyAccount) return state.activeUser.accountId;
    },

    getDefaultProfilePhoto(state) {
      return state.defaultProfilePhoto;
    },
    getProfilePhoto(state){
      return state.profilePhoto;
    },
    getProfileDetailPhoto(state){
      return state.profileDetailPhoto;
    }
  },

  actions: {
    setActiveCompanyUser(user) {
      delete user.password;

      this.activeUser = user;
      this.isLogin = true;
      this.isCompanyAccount = true;
    },

    setActiveCustomerUser(user) {
      delete user.password;

      this.activeUser = user;
      this.isLogin = true;
    },

    removeActiveUser() {
      this.activeUser = null;
      this.isLogin = false;
      this.isCompanyAccount = false;
    },

    async setProfilePhoto(accountId) {
      await profilePhotoService
        .getAccountProfilePhotoById(accountId)
        .then((response) => {
          if (response.data.url != null) {
            this.profilePhoto = response.data.url;
          } else {
            this.profilePhoto = this.defaultProfilePhoto;
          }
        });
    },

    async setProfileDetailPhoto(accountId) {
      await profilePhotoService
        .getAccountProfilePhotoById(accountId)
        .then((response) => {
          if (response.data.url != null) {
            this.profileDetailPhoto = response.data.url;
          } else {
            this.profileDetailPhoto = this.defaultProfilePhoto;
          }
        });
    },
  },

  plugins: [
    createPersistedState({
      storage: {
        getItem: (key) => ls.get(key),
        setItem: (key, value) => ls.set(key, value),
        removeItem: (key) => ls.remove(key),
      },
    }),
  ],
});
