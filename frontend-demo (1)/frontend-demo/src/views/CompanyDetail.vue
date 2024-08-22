<template>
    <div>
        <Navbar />
        <loading v-model:active="isLoading" :is-full-page="fullPage" />
        <main v-if="!company == false">
            <CompanyDetailBackgroundField />
            <section class="relative py-16 bg-blueGray-200">
                <div class="container mx-auto px-4">
                    <div
                        class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-xl rounded-lg -mt-64">
                        <div class="px-6">
                            <div class="flex flex-wrap justify-center space-y-7 lg:space-y-0">
                                <div class="w-full lg:w-3/12 px-4 lg:order-2 flex justify-center">
                                    <CompanyDetailProfilePhotoField :companyAccountId="company.accountId" :photoUrl="company.url" />
                                </div>
                                <div  class="w-full lg:w-4/12 px-4 lg:order-3 lg:text-right lg:self-center">
                                    <div v-if="this.getIsLogin && !this.getIsCompanyAccount" class="py-6 px-3 mt-16 sm:mt-0">
                                        <button v-if="!this.getIsFollowed" @click="followCompany(company.id)"
                                            class="bg-[#068E7D] font-sans  text-white font-bold hover:shadow-md shadow  px-4 py-2 rounded outline-none focus:outline-none sm:mr-2 mb-1 ease-linear transition-all duration-150"
                                            type="button">
                                            Follow
                                        </button>
                                        
                                        <button v-else @click="unFollowCompany()"
                                            class="bg-red-500 font-sans  text-white font-bold hover:shadow-md shadow  px-4 py-2 rounded outline-none focus:outline-none sm:mr-2 mb-1 ease-linear transition-all duration-150"
                                            type="button">
                                            Unfollow
                                        </button>
                                        
                                    </div>
                                    <div class="py-6 px-3 mt-16 sm:mt-0" v-if="this.getIsCompanyAccount && updateButton">
                                        <router-link :to="{path:`/company/${this.$route.params.id}/settings`}">
                                            <button 
                                            class="bg-blue-500 font-sans  text-white font-bold hover:shadow-md shadow  px-4 py-2 rounded outline-none focus:outline-none sm:mr-2 mb-1 ease-linear transition-all duration-150"
                                            type="button">
                                            Update Profile
                                        </button>
                                        </router-link>
                                    </div>
                                </div>
                                <CompanyDetailStatsField />
                            </div>
                            <div class="text-center mt-12">
                                <h3 class="text-4xl font-semibold leading-normal mb-2 text-blueGray-700 ">
                                    {{ company.companyName }}
                                </h3>
                                <div class="mb-2 text-blueGray-600 mt-10">
                                    <i class="fas fa-briefcase mr-2 text-lg text-blueGray-400"></i>Solution Manager -
                                    Creative Tim Officer
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
                                            {{ company.description != null ? company.description :
                                                'There is no description' }}
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
import Loading from 'vue-loading-overlay';
import { mapActions, mapState } from 'pinia';
import { useCompanyStore } from '../stores/user/company';
import Navbar from "../components/common/Navbar.vue"
import CompanyDetailStatsField from '../components/profileDetail/companyDetail/CompanyDetailStatsField.vue';
import CompanyDetailBackgroundField from '../components/profileDetail/companyDetail/CompanyDetailBackgroundField.vue';
import CompanyDetailProfilePhotoField from '../components/profileDetail/companyDetail/CompanyDetailProfilePhotoField.vue'
import Footer from '../components/common/Footer.vue';
import { useUserStore } from '../stores/user';
import { CompanyFollowerService } from '../services/companyFollowerService';
import { useCompanyFollowerStore } from '../stores/followers/companyFollower';


const companyFollowerService = new CompanyFollowerService();

export default {

    created() {
        const companyId = this.$route.params.id
        this.setTargetCompanyById(companyId)
        this.getIsLogin ? this.setCompanyFollowerForCustomer(companyId,this.getActiveUserId) : this.setCompanyFollower(companyId)
        setTimeout(() => {
            this.company = this.getTargetCompany;
            this.isLoading = false
        }, 1000);
        if(this.getIsLogin){
            this.updateButton = this.getActiveUserId == companyId ? true : false
        }
    },
    unmounted() {
        this.company = null
    },

    data() {
        return {
            company: null,
            isLoading: true,
            fullPage: true,
            followerList:[],
            updateButton:false
        }
    },


    methods: {

        followCompany(id) {

            const customerId = this.getActiveUserId
            const followRequest = {
                companyId: id,
                customerId
            }
            companyFollowerService.add(followRequest).then(response => {
                this.setCompanyFollowerForCustomer(id,customerId)
                this.$toast.success("You've successfully followed this company")
            }).catch(error => {
                if (error) {
                    const message = error.response?.data.message
                    this.$toast.error(message)
                }
            })
        },

        unFollowCompany() {
            companyFollowerService.delete(this.getTargetFollowId).then(response => {
                this.$toast.success("You've successfully unfollowed this account")
                setTimeout(() => {
                    this.setCompanyFollowerForCustomer(this.$route.params.id,this.getActiveUserId)
                }, 100);
            })
        },

        ...mapActions(useCompanyStore, ["setTargetCompanyById"]),
        ...mapActions(useCompanyFollowerStore, ["setCompanyFollowerForCustomer","setCompanyFollower"])
    },

    computed: {

        ...mapState(useCompanyStore, ["getTargetCompany"]),
        ...mapState(useUserStore, ["getDefaultProfilePhoto", "getIsLogin", "getActiveUserId","getIsCompanyAccount"]),
        ...mapState(useCompanyFollowerStore, ["getCompanyFollower", "getIsFollowed","getTargetFollowId"])

    },
    components: { Navbar, CompanyDetailStatsField, CompanyDetailBackgroundField,CompanyDetailProfilePhotoField, Footer, Loading }
}
</script>