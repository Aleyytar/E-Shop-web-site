<template>
    <div class="h-screen items-center bg-login flex min-h-full flex-1 flex-col justify-center px-6 lg:px-8">
        <CompanyLogin v-if="getIsCompanyLoginForm" />
        <CustomerLogin v-else />



    </div>
</template>


<script>
import { mapState } from 'pinia';
import CompanyLogin from '../components/login/CompanyLogin.vue';
import CustomerLogin from '../components/login/CustomerLogin.vue';
import { useGlobalStore } from '../stores';
export default {

    computed: {
        

        ...mapState(useGlobalStore, ["getIsCompanyLoginForm"])

    },




    components: { CompanyLogin,CustomerLogin }

}
</script>