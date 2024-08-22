<template>
    <div class="relative min-h-screen">
        <div class="absolute inset-0 flex justify-center items-center">
            <div v-if="this.company" class="flex flex-col bg-white rounded-2xl card-shadow  items-center  py-8 px-16 sm:px-32   max-w-2xl lg:py-16">
                <h2 class="mb-4 text-xl font-bold text-gray-900 dark:text-white">Update Company</h2>
                <Form @submit="updateProfile" :validation-schema="companyUpdateValidationSchema">
                    <div class="grid gap-4 sm:grid-cols-2 sm:gap-6">
                        <div>
                            <label for="companyName"
                                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Company
                                Name</label>
                            <Field type="text" name="companyName" id="companyName"
                                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm outline-none rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                placeholder="Type company name" v-model="this.company.companyName" />
                                <ErrorMessage name="companyName" class=" flex justify-center text-sm text-red-500" />
                            </div>
                        <div>
                            <label for="username"
                                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Company
                                Username</label>
                            <Field type="text" name="accountUsername" id="username"
                                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm outline-none rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                placeholder="Type company username" v-model="this.company.username" />
                                <ErrorMessage name="accountUsername" class=" flex justify-center text-sm text-red-500" />
                        </div>
                        <div class="sm:col-span-2">
                            <label for="phoneNumber"
                                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Phone
                                Number</label>
                            <Field disabled type="number" name="accountPhoneNumber" id="phoneNumber"
                                class=" border cursor-not-allowed border-gray-300 bg-gray-300 text-gray-900 text-sm outline-none rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                v-model="this.company.phoneNumber" />
                        </div>
                        <div class="sm:col-span-2">
                            <label for="email"
                                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Email</label>
                            <Field type="text" name="accountEmail" id="email"
                                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm outline-none rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                placeholder="siteAdı@example.com" v-model="this.company.email" />
                                <ErrorMessage name="accountEmail" class=" flex justify-center text-sm text-red-500" />
                        </div>
                        <div >
                            <label for="password"
                                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
                            <Field type="password" name="accountPassword" id="password"
                                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm outline-none rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                v-model="this.company.password" />
                                <ErrorMessage name="accountPassword" class=" flex justify-center text-sm text-red-500" />
                        </div>
                        <div >
                            <label for="confirmPassword"
                                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Confirm Password</label>
                            <Field type="password" name="accountConfirmPassword" id="confirmPassword"
                                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm outline-none rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                v-model="this.company.confirmPassword" />
                                <ErrorMessage name="accountConfirmPassword" class=" flex justify-center text-sm text-red-500" />
                        </div>
                        <div class="sm:col-span-2">
                            <label for="description"
                                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Description</label>
                            <Field as="textarea" name="description" id="description" rows="8"
                                class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 outline-none rounded-lg border border-gray-300 focus:ring-primary-500 focus:border-primary-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                placeholder="Your description here" v-model="this.company.description" />
                        </div>
                    </div>
                    <div class="mt-2">
                        <button type="submit"
                        class="relative left-1/2 -translate-x-1/2 px-5 py-3 overflow-hidden font-medium text-lightgreen bg-gray-100 border border-[#07B29C] rounded-lg shadow-inner group">
                        <span
                            class="absolute top-0 left-0 w-0 h-0 transition-all duration-200 border-t-2 border-lightgreen group-hover:w-full ease"></span>
                        <span
                            class="absolute bottom-0 right-0 w-0 h-0 transition-all duration-200 border-b-2 border-lightgreen group-hover:w-full ease"></span>
                        <span
                            class="absolute top-0 left-0 w-full h-0 transition-all duration-300 delay-200 bg-lightgreen group-hover:h-full ease"></span>
                        <span
                            class="absolute bottom-0 left-0 w-full h-0 transition-all duration-300 delay-200 bg-lightgreen group-hover:h-full ease"></span>
                        <span
                            class="absolute inset-0 w-full h-full duration-300 delay-300 bg-lightgreen opacity-0 group-hover:opacity-100"></span>
                        <span
                            class="relative transition-colors duration-300 delay-200 group-hover:text-white ease">Update Profile</span>

                    </button>
                    </div>
                </Form>
            </div>
        </div>
    </div>
</template>


<script>
import { Form, Field, ErrorMessage } from 'vee-validate'
import { CompanyService } from '../../../services/companyService';
import { companyUpdateSchema } from '../../../validations/formValidations/companyFormValidation';

const companyService = new CompanyService();
export default {

    methods: {
        updateProfile(target){
            
            const updatedCompany={
                id: this.company.id,
                accountStatusId: this.company.statusId,
                ...target

            }

            companyService.updateCompany(updatedCompany).then(response => {
                
                this.$toast.success("Profile information is successfully updated")
            }).catch(error=> {
                const message = error.response.data.message
                this.$toast.error(message)
            })

            
        }
    },

    computed:{
        companyUpdateValidationSchema(){
            return companyUpdateSchema;
        }
    },

    props: ["company"],
    components: { Form, Field, ErrorMessage }
}
</script>