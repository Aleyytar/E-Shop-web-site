<template>
    <div class="w-full lg:w-4/12 px-4 lg:order-1">
        <router-link :to="{path:`/customer/${this.$route.params.id}/info`}">
            <div class="flex justify-center py-4 lg:pt-4 pt-8">
            <div class="mr-4 p-3 text-center">
                <span class="text-xl font-bold block uppercase tracking-wide text-blueGray-600">{{this.getCustomerFollowerCount}}</span><span
                    class="text-sm text-blueGray-400">Follower</span>
            </div>
            <div class="mr-4 p-3 text-center">
                <span class="text-xl font-bold block uppercase tracking-wide text-blueGray-600">{{ this.getCustomerFollowingCount }}</span><span
                    class="text-sm text-blueGray-400">Following</span>
            </div>
            <!-- <div class="lg:mr-4 p-3 text-center">
                <span class="text-xl font-bold block uppercase tracking-wide text-blueGray-600">89</span><span
                    class="text-sm text-blueGray-400">Comments</span>
            </div> -->
        </div>
        </router-link>
    </div>
</template>


<script>
import { mapActions, mapState } from 'pinia';
import { useCustomerFollowerStore } from '../../../stores/followers/customerFollower';

export default {
    

    created() {
        const customerId = this.$route.params.id
        this.setCustomerFollower(customerId)
        this.setCustomerFollowing(customerId)
    },

    methods: {
        ...mapActions(useCustomerFollowerStore,["setCustomerFollower","setCustomerFollowing"])
    },

    computed:{

        ...mapState(useCustomerFollowerStore,["getCustomerFollowerCount","getCustomerFollowingCount"])
    }
}
</script>

