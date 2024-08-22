<template>
    <div class="w-full lg:w-3/12 px-4 lg:order-2 flex justify-center">
        <div class="relative">
            <button 
            @click="!this.getIsCompanyAccount && (this.getActiveUserId == this.$route.params.id) ? changeProfilePhoto() : null">
                <img alt="..." :src="this.getProfileDetailPhoto"
                    class="bg-white shadow-xl rounded-full h-auto align-middle border-none absolute -m-16 -ml-20 lg:-ml-16 max-w-[150px]">
            </button>
        </div>
        <CustomerProfileUpdatePhotoModal :customerAccountId="this.customerAccountId" />
    </div>
</template>


<script>
import { useUserStore } from '../../../stores/user';
import { mapActions, mapState } from "pinia"
import { useCustomerStore } from '../../../stores/user/customer';
import CustomerProfileUpdatePhotoModal from '../../profileUpdate/customerProfileUpdate/CustomerProfileUpdatePhotoModal.vue';

export default {
    created() {
        this.setProfileDetailPhoto(this.customerAccountId)
    },
    methods: {

        changeProfilePhoto() {
            this.setCanChangeProfilePhoto(true)
        },

        ...mapActions(useCustomerStore,["setCanChangeProfilePhoto"]),
        ...mapActions(useUserStore, ["setProfileDetailPhoto"])
    },
    computed: {
        ...mapState(useUserStore, ["getProfileDetailPhoto","getIsCompanyAccount","getActiveUserId","getActiveUserAccountId"])
    },

    props: ["customerAccountId"],

    components:{CustomerProfileUpdatePhotoModal}
}
</script>