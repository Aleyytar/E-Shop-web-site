<template>
    <div class="gradient-form h-screen bg-register">
        <CompanyRegister v-if="getIsCompanyRegisterForm" />
        <CustomerRegister v-else />
    </div>
</template>


<script>
import { mapState } from 'pinia';
import { useGlobalStore } from '../stores';
import CompanyRegister from '../components/register/CompanyRegister.vue';
import CustomerRegister from '../components/register/CustomerRegister.vue';



export default {


    computed:{

        ...mapState(useGlobalStore,["getIsCompanyRegisterForm"])
    },

    components:{CompanyRegister,CustomerRegister}
    
}
</script>