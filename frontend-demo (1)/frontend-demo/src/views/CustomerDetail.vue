<template>
    <div>
        <Navbar />
        <loading v-model:active="isLoading" :is-full-page="fullPage" />
        <main v-if="!customer == false">
            <CustomerDetailBackgroundField />
            <section  class="relative py-16 bg-blueGray-200">
                <div class="container mx-auto px-4">
                    <div
                        class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-xl rounded-lg -mt-64">
                        <div class="px-6">
                            <div class="flex flex-wrap justify-center">
                                <CustomerDetailProfilePhotoField :customerAccountId="customer.accountId" />
                                <CustomerDetailButtonField />
                                <CustomerDetailStatsField />
                            </div>
                            <div class="text-center mt-12">
                                <h3 class="text-4xl font-semibold leading-normal mb-2 text-blueGray-700">
                                    {{ customer.firstName}} {{customer.lastName}}
                                </h3>
                                <div class="mb-2 text-blueGray-600 mt-10">
                                    <i class="fas fa-briefcase mr-2 text-lg text-blueGray-400"></i>Solution Manager
                                    - Creative Tim Officer
                                </div>
                                <div class="mb-2 text-blueGray-600">
                                    <i class="fas fa-university mr-2 text-lg text-blueGray-400"></i>University of
                                    Computer Science
                                </div>
                            </div>
                            <div class="mt-10 py-10 border-t border-blueGray-200 text-center">
                                <div class="flex flex-wrap justify-center">
                                    <div class="w-full lg:w-9/12 px-4">
                                        <p class="mb-4 text-lg leading-relaxed text-blueGray-700">
                                           {{ customer.description }}
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <Footer />
            </section>

        </main>
    </div>
</template>

<script>
import { mapActions, mapState } from 'pinia';
import Footer from '../components/common/Footer.vue';
import Navbar from '../components/common/Navbar.vue';
import CustomerDetailBackgroundField from '../components/profileDetail/customerDetail/CustomerDetailBackgroundField.vue';
import CustomerDetailButtonField from '../components/profileDetail/customerDetail/CustomerDetailButtonField.vue';
import CustomerDetailProfilePhotoField from '../components/profileDetail/customerDetail/CustomerDetailProfilePhotoField.vue';
import CustomerDetailStatsField from '../components/profileDetail/customerDetail/CustomerDetailStatsField.vue';
import Loading from 'vue-loading-overlay';
import { useCustomerStore } from '../stores/user/customer';


export default {
    created() {

        const customerId = this.$route.params.id
        this.setTargetCustomer(customerId)
        setTimeout(() => {
            this.customer = this.getTargetCustomer;
            this.isLoading = false
        }, 1000);
    },

    unmounted() {
        this.company = null
    },

    data() {
        return {
            customer:null,
            isLoading: true,
            fullPage: true,
        }
    },


    methods: {
        
        ...mapActions(useCustomerStore,["setTargetCustomer"])
    },
    computed:{

        ...mapState(useCustomerStore,["getTargetCustomer"])
    },

    components: { Navbar,Loading,CustomerDetailBackgroundField,CustomerDetailProfilePhotoField,CustomerDetailButtonField,CustomerDetailStatsField,Footer }
}
</script>