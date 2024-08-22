<template>
    <div class="h-screen bg-login" v-if="this.getAuthorizeForUpdateProfile">
        <loading v-model:active="isLoading" :is-full-page="fullPage" />
        <CustomerProfileUpdateForm :customer="customer" />
    </div>

    <div v-else>
        <h2>NOT AUTHORIZED</h2>
    </div>
</template>


<script>
import Loading from 'vue-loading-overlay';
import CustomerProfileUpdateForm from '../components/profileUpdate/customerProfileUpdate/CustomerProfileUpdateForm.vue'
import { mapState, mapActions } from 'pinia';
import { useCustomerStore } from '../stores/user/customer';
import { CustomerService } from '../services/customerService';
import { useUserStore } from '../stores/user';

const customerService = new CustomerService();

export default {
    created() {

        customerService.getCustomerById(this.$route.params.id).then(response => {
            const customer = response
            delete customer.favoriteProducts;
            delete customer.customerFollowers;

            if (this.getActiveUserAccountId != customer.accountId) {
                this.setAuthorizeForUpdateProfile(false)
            } else {
                this.setAuthorizeForUpdateProfile(true)

                this.customer = {
                    ...customer,
                    confirmPassword:customer.password

                }

                setTimeout(() => {
                    this.isLoading = false
                }, 1500);
            }
        })

    },

    data() {
        return {
            customer: null,
            isLoading: true,
            fullPage: true,
        }
    },

    methods: {
        ...mapActions(useCustomerStore, ["setAuthorizeForUpdateProfile"])
    },

    computed: {


        ...mapState(useCustomerStore, ["getAuthorizeForUpdateProfile"]),
        ...mapState(useUserStore, ["getActiveUserAccountId"])
    },
    components: { Loading, CustomerProfileUpdateForm }
}
</script>