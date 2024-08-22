import { defineStore } from "pinia";
import { CustomerFollowerService } from "../../../services/customerFollowerService";
import { CompanyFollowerService } from "../../../services/companyFollowerService";


const customerFollowerService = new CustomerFollowerService();
const companyFollowerService = new CompanyFollowerService();

export const useCustomerFollowerStore = defineStore("customerFollower", {
  state: () => ({
    customerFollower:[],
    customerFollowing:[],
    isFollowedBefore: false,
    targetFollowId: null,
  }),
  getters: {
    getCustomerFollower(state){
        return state.customerFollower;
    },
    getCustomerFollowerCount(state){
      return state.customerFollower.length;
    },
    getCustomerFollowing(state){
      return state.customerFollowing;
    },
    getCustomerFollowingCount(state){
      return state.customerFollowing.length;
    },

    getIsFollowed(state) {
      return state.isFollowedBefore;
    },

    getTargetFollowId(state) {
      return state.targetFollowId;
    },

  },
  actions: {
    async setCustomerFollower(customerId){
        
        const followerList =
        await customerFollowerService.getCustomerFollowerByCustomerId(customerId);
        this.customerFollower = followerList;
    },

    async setCustomerFollowing(customerId){

      const followingList =
        await companyFollowerService.getCustomerFollowingByCustomerId(customerId);
      this.customerFollowing = followingList;

    },

    async setCustomerFollowerForCompany(customerId,companyId) {
      const followerList =
        await customerFollowerService.getCustomerFollowerByCustomerId(customerId);
      this.customerFollower = followerList;
      
      this.setIfCustomerFollowedBefore(companyId)
    },

    setIfCustomerFollowedBefore(companyId){
      const target = this.customerFollower.filter(follower => follower.companyId == companyId)
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
