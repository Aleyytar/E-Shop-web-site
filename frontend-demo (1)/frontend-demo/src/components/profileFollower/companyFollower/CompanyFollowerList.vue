<template>
    <ul role="list" class="p-6 divide-y divide-slate-200">
        <li v-for="follower in this.getCompanyFollower">
            <router-link :to="{ path: `/customer/${follower.customerId}` }">
                <div class="flex py-4 first:pt-0 last:pb-0">
                    <img class="h-20 w-20 rounded-full"
                        :src="follower.customerProfileUrl != null ? follower.customerProfileUrl : this.getDefaultProfilePhoto"
                        alt="" />
                    <div class="flex justify-between items-center w-full">
                        <div class="ml-3 overflow-hidden">
                            <p class="text-sm font-medium text-slate-900">{{ follower.customerUsername }}</p>
                        </div>
                    </div>
                </div>
            </router-link>
        </li>
    </ul>
</template>

<script>
import { mapActions, mapState } from 'pinia';
import { useCompanyFollowerStore } from '../../../stores/followers/companyFollower';
import { useUserStore } from '../../../stores/user';



export default {

    created() {
        this.setCompanyFollower(this.$route.params.id)
    },

    methods: {
        ...mapActions(useCompanyFollowerStore, ["setCompanyFollower", "setIsFollowedBefore"])
    },

    computed: {

        ...mapState(useCompanyFollowerStore, ["getCompanyFollower"]),
        ...mapState(useUserStore, ["getDefaultProfilePhoto", "getActiveUserId"])
    }



}

</script>