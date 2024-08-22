<template>
    <div class="h-screen bg-login" v-if="this.getAuthorizeForUpdateProfile">
        <loading v-model:active="isLoading" :is-full-page="fullPage" />
        <CompanyProfileUpdateForm :company="company" />
    </div>

    <div v-else>
        <h2>NOT AUTHORIZED</h2>
    </div>
</template>

<script>
import Loading from 'vue-loading-overlay';
import { CompanyService } from '../services/companyService';
import { mapActions, mapState } from 'pinia';
import { useCompanyStore } from '../stores/user/company';
import { useUserStore } from '../stores/user';
import CompanyProfileUpdateForm from '../components/profileUpdate/companyProfileUpdate/CompanyProfileUpdateForm.vue';

const companyService = new CompanyService();

export default {


    created() {
        companyService.getCompanyById(this.$route.params.id).then(response => {

            const company = response.data
            delete company.companyFollowers;
            delete company.products;


            if (this.getCompanyAccountId != company.accountId) {
                this.setAuthorizeForUpdateProfile(false)
            } else {
                this.setAuthorizeForUpdateProfile(true)

                this.company = {
                    ...company,
                    confirmPassword:company.password
                };

                setTimeout(() => {
                    this.isLoading = false
                }, 1500);

            }
        })
    },

    data() {
        return {
            company: null,
            isLoading: true,
            fullPage: true,
        }
    },


    methods: {

        ...mapActions(useCompanyStore, ["setAuthorizeForUpdateProfile"])
    },

    computed: {

        ...mapState(useCompanyStore, ["getAuthorizeForUpdateProfile"]),
        ...mapState(useUserStore, ["getCompanyAccountId"])
    },


    components: { Loading, CompanyProfileUpdateForm }

}
</script>