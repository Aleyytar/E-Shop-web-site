import { defineStore } from "pinia";
import { CompanyFollowerService } from "../../../services/companyFollowerService";
import { CustomerFollowerService } from "../../../services/customerFollowerService";

const companyFollowerService = new CompanyFollowerService();
const customerFollowerService = new CustomerFollowerService();

export const useCompanyFollowerStore = defineStore("companyFollower", {
  state: () => ({
    companyFollower: [],
    companyFollowing: [],
    isFollowedBefore: false,
    targetFollowId: null,
  }),

  getters: {
    getCompanyFollower(state) {
      return state.companyFollower;
    },

    getCompanyFollowerCount(state) {
      return state.companyFollower.length;
    },

    getCompanyFollowing(state) {
      return state.companyFollowing;
    },

    getCompanyFollowingCount(state) {
      return state.companyFollowing.length;
    },

    getIsFollowed(state) {
      return state.isFollowedBefore;
    },

    getTargetFollowId(state) {
      return state.targetFollowId;
    },
  },

  actions: {
    async setCompanyFollower(companyId) {
      const followerList =
        await companyFollowerService.getCompanyFollowerByCompanyId(companyId);
      this.companyFollower = followerList;
    },

    async setCompanyFollowing(companyId) {
      const followingList =
        await customerFollowerService.getCompanyFollowingByCompanyId(companyId);
      this.companyFollowing = followingList;
    },

    async setCompanyFollowerForCustomer(companyId, customerId) {
      const followerList =
        await companyFollowerService.getCompanyFollowerByCompanyId(companyId);
      this.companyFollower = followerList;
      
      this.setIfCustomerFollowedBefore(customerId)
    },

    setIfCustomerFollowedBefore(customerId){
      const target = this.companyFollower.filter(follower => follower.customerId == customerId)
      if(target.length > 0){
        this.isFollowedBefore = true 
        this.targetFollowId =  target[0].id
      }else{
        this.isFollowedBefore = false
        this.targetFollowId =  null
      }
    }

  },
});
