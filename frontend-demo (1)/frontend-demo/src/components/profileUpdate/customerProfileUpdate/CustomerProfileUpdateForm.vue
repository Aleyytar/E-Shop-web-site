<template>
    <div class="relative min-h-screen">
        <div class="absolute inset-0 flex justify-center items-center">
            <div v-if="this.customer"
                class="flex flex-col bg-white rounded-2xl card-shadow  items-center  py-8 px-16 sm:px-32   max-w-2xl lg:py-16">
                <h2 class="mb-4 text-xl font-bold text-gray-900 dark:text-white">Update Customer</h2>
                <Form @submit="updateProfile" :validation-schema="customerUpdateValidationSchema">
                    <div class="grid gap-4 sm:grid-cols-2 sm:gap-6">
                        <div>
                            <label for="firstName"
                                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">First Name</label>
                            <Field type="text" name="firstName" id="firstName"
                                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm outline-none rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                placeholder="Type customer name" v-model="this.customer.firstName" />
                            <ErrorMessage name="firstName" class=" flex justify-center text-sm text-red-500" />
                        </div>

                        <div>
                            <label for="lastName"
                                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">First Name</label>
                            <Field type="text" name="lastName" id="lastName"
                                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm outline-none rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                placeholder="Type customer last name" v-model="this.customer.lastName" />
                            <ErrorMessage name="lastName" class=" flex justify-center text-sm text-red-500" />
                        </div>

                        <div class="sm:col-span-2">
                            <label for="username"
                                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Customer
                                Username</label>
                            <Field type="text" name="accountUsername" id="username"
                                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm outline-none rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                placeholder="Type customer username" v-model="this.customer.username" />
                            <ErrorMessage name="accountUsername" class=" flex justify-center text-sm text-red-500" />
                        </div>
                        <div class="sm:col-span-2">
                            <label for="phoneNumber"
                                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Phone
                                Number</label>
                            <Field disabled type="number" name="accountPhoneNumber" id="phoneNumber"
                                class=" border cursor-not-allowed border-gray-300 bg-gray-300 text-gray-900 text-sm outline-none rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                v-model="this.customer.phoneNumber" />
                        </div>
                        <div class="sm:col-span-2">
                            <label for="email"
                                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Email</label>
                            <Field type="text" name="accountEmail" id="email"
                                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm outline-none rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                placeholder="siteAdı@example.com" v-model="this.customer.email" />
                            <ErrorMessage name="accountEmail" class=" flex justify-center text-sm text-red-500" />
                        </div>
                        <div>
                            <label for="password"
                                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
                            <Field type="password" name="accountPassword" id="password"
                                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm outline-none rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                v-model="this.customer.password" />
                            <ErrorMessage name="accountPassword" class=" flex justify-center text-sm text-red-500" />
                        </div>
                        <div>
                            <label for="confirmPassword"
                                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Confirm
                                Password</label>
                            <Field type="password" name="accountConfirmPassword" id="confirmPassword"
                                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm outline-none rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                v-model="this.customer.confirmPassword" />
                            <ErrorMessage name="accountConfirmPassword" class=" flex justify-center text-sm text-red-500" />
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
                                class="relative transition-colors duration-300 delay-200 group-hover:text-white ease">Update
                                Profile</span>
                        </button>
                    </div>
                </Form>
            </div>
        </div>
    </div>
</template>

<script>
import { Form, Field, ErrorMessage } from 'vee-validate'
import { updateCustomerSchema } from '../../../validations/formValidations/customerFormValidation';
import { CustomerService } from '../../../services/customerService';

const customerService = new CustomerService();

export default {

    created() {
        console.log(this.customer);
    },

    methods: {
        updateProfile(target) {
            const updatedCustomer = {
                id: this.customer.id,
                accountStatusId: this.customer.statusId,
                ...target
            }

            customerService.updateCustomer(updatedCustomer).then(response => {

                this.$toast.success("Profile information is successfully updated")

            }).catch(error => {
                const message = error.response.data.message
                this.$toast.error(message)
            })
        }
    },

    computed: {

        customerUpdateValidationSchema() {
            return updateCustomerSchema;
        }
    },

    props: ["customer"],

    components: { Form, Field, ErrorMessage }
}
</script>