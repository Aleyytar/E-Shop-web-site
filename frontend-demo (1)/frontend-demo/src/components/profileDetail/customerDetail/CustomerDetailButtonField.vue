<template>
    <div class="w-full lg:w-4/12 px-4 lg:order-3 lg:text-right lg:self-center">
        <div v-if="this.getIsLogin && this.getIsCompanyAccount" class="py-6 px-3 mt-16 sm:mt-0">
            <button v-if="!this.getIsFollowed" @click="followCustomer(this.$route.params.id)"
                class="bg-[#068E7D] font-sans  text-white font-bold hover:shadow-md shadow  px-4 py-2 rounded outline-none focus:outline-none sm:mr-2 mb-1 ease-linear transition-all duration-150"
                type="button">
                Follow
            </button>

            <button v-else @click="unFollowCustomer()"
                class="bg-red-500 font-sans  text-white font-bold hover:shadow-md shadow  px-4 py-2 rounded outline-none focus:outline-none sm:mr-2 mb-1 ease-linear transition-all duration-150"
                type="button">
                Unfollow
            </button>

        </div>
        <div class="py-6 px-3 mt-16 sm:mt-0" v-if="!this.getIsCompanyAccount && updateButton">
            <router-link :to="{ path: `/customer/${this.$route.params.id}/settings` }">
                <button
                    class="bg-blue-500 font-sans  text-white font-bold hover:shadow-md shadow  px-4 py-2 rounded outline-none focus:outline-none sm:mr-2 mb-1 ease-linear transition-all duration-150"
                    type="button">
                    Update Profile
                </button>
            </router-link>
        </div>
    </div>
</template>

<script>
import { mapActions, mapState } from 'pinia';
import { useCustomerFollowerStore } from '../../../stores/followers/customerFollower';
import { useUserStore } from '../../../stores/user';
import { CustomerFollowerService } from '../../../services/customerFollowerService';

const customerFollowerService = new CustomerFollowerService();

export default {

    created() {
        const customerId = this.$route.params.id
        this.getIsLogin ? this.setCustomerFollowerForCompany(customerId, this.getActiveUserId) : this.setCustomerFollower(customerId)
        
        setTimeout(() => {
            this.updateButton = this.getActiveUserId == customerId ? true : false
        }, 100);
        
    },

    data() {
        return {
            updateButton: false
        }
    },

    methods: {
        followCustomer(customerId) {
            const companyId = this.getActiveUserId

            const followRequest = {
                companyId,
                customerId: parseInt(customerId)
            }
            customerFollowerService.add(followRequest).then(response => {
                this.setCustomerFollowerForCompany(customerId, companyId)
                this.$toast.success("You've successfully followed this customer")
            }).catch(error => {
                if (error) {
                    const message = error.response?.data.message
                    this.$toast.error(message)
                }
            })
        },
        unFollowCustomer() {

            customerFollowerService.delete(this.getTargetFollowId).then(response => {
                this.$toast.success("You've successfully unfollowed this account")
                setTimeout(() => {
                    this.setCustomerFollowerForCompany(this.$route.params.id, this.getActiveUserId)
                }, 100);

            })

        },
        ...mapActions(useCustomerFollowerStore, ["setCustomerFollowerForCompany", "setCustomerFollower"])
    },

    computed: {
        ...mapState(useCustomerFollowerStore, ["getIsFollowed", "getTargetFollowId"]),
        ...mapState(useUserStore, ["getIsLogin", "getActiveUserId", "getIsCompanyAccount"])
    },
}
</script>