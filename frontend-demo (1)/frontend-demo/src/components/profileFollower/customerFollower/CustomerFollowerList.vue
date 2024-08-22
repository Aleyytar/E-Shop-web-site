<template>
    <ul role="list" class="p-6 divide-y divide-slate-200">
        <li v-for="follower in this.getCustomerFollower">
            <router-link :to="{ path: `/company/${follower.companyId}` }">
                <div class="flex py-4 first:pt-0 last:pb-0">
                    <img class="h-20 w-20 rounded-full"
                        :src="follower.companyProfileUrl != null ? follower.companyProfileUrl : this.getDefaultProfilePhoto"
                        alt="" />
                    <div class="flex justify-between items-center w-full">
                        <div class="ml-3 overflow-hidden">
                            <p class="text-sm font-medium text-slate-900">{{ follower.companyUsername }}</p>
                        </div>
                    </div>
                </div>
            </router-link>
        </li>
    </ul>
</template>

<script>
import { mapActions, mapState } from 'pinia';
import { useCustomerFollowerStore } from '../../../stores/followers/customerFollower';
import { useUserStore } from '../../../stores/user';

export default {
    
    created() {
        this.setCustomerFollower(this.$route.params.id)
    },

    methods: {
        
        ...mapActions(useCustomerFollowerStore,["setCustomerFollower"])
    },

    computed:{

        ...mapState(useCustomerFollowerStore,["getCustomerFollower"]),
        ...mapState(useUserStore,["getDefaultProfilePhoto"])
    },

}
</script>