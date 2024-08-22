<template>
    <div class="w-full lg:w-4/12 px-4 lg:order-1">
        <router-link :to="{ path: `/company/${this.$route.params.id}/info` }">
            <div class="flex justify-center py-4 lg:pt-4 pt-8">
                <div class="mr-4 p-3 text-center">
                    <span class="text-xl font-bold block uppercase tracking-wide text-blueGray-600">{{
                        this.getCompanyFollowerCount }}</span><span class="text-sm text-blueGray-400">Follower</span>
                </div>
                <div class="mr-4 p-3 text-center">
                    <span
                        class="text-xl font-bold block uppercase tracking-wide text-blueGray-600">{{ this.getCompanyFollowingCount }}</span><span
                        class="text-sm text-blueGray-400">Following</span>
                </div>
                <div class="lg:mr-4 p-3 text-center">
                    <span class="text-xl font-bold block uppercase tracking-wide text-blueGray-600">{{
                        this.getActiveProductCount }}</span><span class="text-sm text-blueGray-400">Products</span>
                </div>
            </div>
        </router-link>
    </div>
</template>

<script>
import { mapActions, mapState } from 'pinia';
import { useCompanyStore } from '../../../stores/user/company';
import { useCompanyFollowerStore } from '../../../stores/followers/companyFollower';

export default {

    created() {
        this.getActiveProductsByCompanyId(this.$route.params.id)
        this.setCompanyFollower(this.$route.params.id)
        this.setCompanyFollowing(this.$route.params.id)
    },

    methods: {
        ...mapActions(useCompanyStore, ["getActiveProductsByCompanyId"]),
        ...mapActions(useCompanyFollowerStore, ["setCompanyFollower", "setCompanyFollowing"])
    },

    computed: {
        ...mapState(useCompanyStore, ["getActiveProductCount"]),
        ...mapState(useCompanyFollowerStore, ["getCompanyFollowerCount", "getCompanyFollowingCount"])
    }
}
</script>