<template>
    <ul role="list" class="p-6 divide-y divide-slate-200">
        <li v-for="following in followingList" :key="following.id" class="flex py-4 first:pt-0 last:pb-0">
            <img class="h-20 w-20 rounded-full bg-white"
                :src="following.customerProfileUrl != null ? following.customerProfileUrl : this.getDefaultProfilePhoto"
                alt="" />
            <div class="flex justify-between items-center w-full">
                <div class="ml-3 overflow-hidden">
                    <p class="text-sm font-medium text-slate-900">{{ following.customerUsername }}</p>
                </div>
                <div v-if="this.getIsLogin && this.getIsCompanyAccount ">
                    <button @click="unFollow(following)" v-if="this.$route.params.id == this.getActiveUserId"
                        class="relative px-5 py-3 overflow-hidden font-medium text-[#07B29C] bg-gray-100 border border-gray-100 rounded-lg shadow-inner group">
                        <span
                            class="absolute top-0 left-0 w-0 h-0 transition-all duration-200 border-t-2 border-[#07B29C] group-hover:w-full ease"></span>
                        <span
                            class="absolute bottom-0 right-0 w-0 h-0 transition-all duration-200 border-b-2 border-[#07B29C] group-hover:w-full ease"></span>
                        <span
                            class="absolute top-0 left-0 w-full h-0 transition-all duration-300 delay-200 bg-[#07B29C] group-hover:h-full ease"></span>
                        <span
                            class="absolute bottom-0 left-0 w-full h-0 transition-all duration-300 delay-200 bg-[#07B29C] group-hover:h-full ease"></span>
                        <span
                            class="absolute inset-0 w-full h-full duration-300 delay-300 bg-[#07B29C] opacity-0 group-hover:opacity-100"></span>
                        <span class="relative transition-colors duration-300 delay-200 group-hover:text-white ease"><i
                                class="fa-solid fa-user-minus"></i></span>
                    </button>
                </div>
            </div>
        </li>
    </ul>
</template>

<script>
import { mapActions, mapState } from 'pinia';
import { useCompanyFollowerStore } from '../../../stores/followers/companyFollower';
import { useUserStore } from '../../../stores/user';
import { CustomerFollowerService } from '../../../services/customerFollowerService';

const customerFollowerService = new CustomerFollowerService();
export default {

    created() {
        this.setCompanyFollowing(this.$route.params?.id).then(response => {
            this.followingList = this.getCompanyFollowing;
        })
    },

    data() {
        return {
            followingList:[]
        }
    },

    methods: {
        unFollow(target){
            customerFollowerService.delete(target.id).then(response=>{
                this.followingList = this.followingList.filter(following => following.id != target.id);
                this.$toast.success(`You've successfully unfollowed the account: ${target.customerUsername}`)
            })
        },
        ...mapActions(useCompanyFollowerStore, ["setCompanyFollowing"])
    },

    computed: {

        ...mapState(useCompanyFollowerStore, ["getCompanyFollowing"]),
        ...mapState(useUserStore, ["getDefaultProfilePhoto", "getActiveUserId","getIsLogin","getIsCompanyAccount"])
    }



}

</script>