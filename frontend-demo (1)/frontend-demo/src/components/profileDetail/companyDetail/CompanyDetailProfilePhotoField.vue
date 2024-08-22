<template>
    <div class="relative">
        <button
            @click="this.getIsCompanyAccount && (this.getActiveUserId == this.$route.params.id) ? changeProfilePhoto() : null">
            <img alt="..." :src="this.getProfileDetailPhoto"
                class="shadow-xl bg-white rounded-full h-auto align-middle border-none absolute -m-16 -ml-20 lg:-ml-16 max-w-[150px]">
        </button>

        <CompanyProfileUpdatePhotoModal :companyAccountId="this.companyAccountId" />
    </div>
</template>


<script>
import { mapState,mapActions } from 'pinia';
import { useUserStore } from '../../../stores/user';
import { useCompanyStore } from '../../../stores/user/company';
import CompanyProfileUpdatePhotoModal from '../../profileUpdate/companyProfileUpdate/CompanyProfileUpdatePhotoModal.vue'

export default {

    created() {
        this.setProfileDetailPhoto(this.companyAccountId)
    },
    
    methods: {
        changeProfilePhoto() {
            this.setCanChangeProfilePhoto(true)
        },

        ...mapActions(useCompanyStore,["setCanChangeProfilePhoto"]),
        ...mapActions(useUserStore,["setProfileDetailPhoto"])
    },
    
    computed: {
        
        ...mapState(useUserStore, ["getProfileDetailPhoto", "getIsCompanyAccount", "getActiveUserId","getActiveUserAccountId"]),
        
    },

    props: ["companyAccountId"],

    components:{CompanyProfileUpdatePhotoModal}

}
</script>