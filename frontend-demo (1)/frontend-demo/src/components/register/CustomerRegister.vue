<template>
    <div class="container h-full p-10 m-auto">
        <div class="flex h-full flex-wrap items-center justify-center text-neutral-800 dark:text-neutral-200">
            <div class="w-full">
                <div class="block rounded-lg bg-white form-shadow dark:bg-neutral-800">
                    <div class="g-0 lg:flex lg:flex-wrap">
                        <!-- Left column container-->
                        <div class="px-4 md:px-0 lg:w-6/12  ">
                            <div class="md:mx-6 md:p-12 mb-4 sm:mb-0">
                                <!--Logo-->
                                <div class="text-center">
                                    <img class="mx-auto h-40 w-auto" src="../../assets/mainLogo1.png"
                                        alt="Your Company" />
                                    <h4 class="mb-4  text-xl font-semibold">
                                        We are The Lotus Team
                                    </h4>
                                </div>

                                <Form @submit="registerAsCustomer(userData)" :validation-schema="customerValidationSchema"
                                    class="space-y-1">
                                    <span class="flex justify-center font-semibold">Sign up as a Customer</span>
                                    <div class="flex justify-center">

                                        <Field name="firstName" v-model="userData.firstName" autocomplete="off"
                                            placeholder="First Name"
                                            class="block w-1/4 outline-none rounded-md border-0 ps-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-green-600 sm:text-sm sm:leading-6" />


                                        <Field name="lastName" v-model="userData.lastName" autocomplete="off"
                                            placeholder="Last Name"
                                            class="block w-1/4 outline-none rounded-md border-0 ps-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-green-600 sm:text-sm sm:leading-6" />


                                    </div>
                                    <ErrorMessage class="flex justify-center text-sm text-red-500" name="firstName" />
                                    <ErrorMessage class="flex justify-center text-sm text-red-500" name="lastName" />

                                    <Field name="email" v-model="userData.accountEmail" autocomplete="off"
                                        placeholder="Email"
                                        class="block w-1/2 m-auto outline-none rounded-md border-0 ps-4 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-green-600 sm:text-sm sm:leading-6" />
                                    <ErrorMessage class="flex justify-center text-sm text-red-500" name="email" />

                                    <Field name="username" v-model="userData.accountUsername" autocomplete="off"
                                        placeholder="Username"
                                        class="block w-1/2 m-auto outline-none rounded-md border-0 ps-4 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-green-600 sm:text-sm sm:leading-6" />
                                    <ErrorMessage class="flex justify-center text-sm text-red-500" name="username" />

                                    <Field name="phoneNumber" v-model="userData.accountPhoneNumber" autocomplete="off"
                                        placeholder="Phone Number"
                                        class="block w-1/2 m-auto outline-none rounded-md border-0 ps-4 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-green-600 sm:text-sm sm:leading-6" />
                                    <ErrorMessage class="flex justify-center text-sm text-red-500" name="phoneNumber" />

                                    <Field type="password" name="password" v-model="userData.accountPassword" autocomplete="off"
                                        placeholder="Password"
                                        class="block w-1/2 m-auto outline-none rounded-md border-0 ps-4 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-green-600 sm:text-sm sm:leading-6" />
                                    <ErrorMessage class="flex justify-center text-sm text-red-500" name="password" />

                                    <Field type="password" name="confirmPassword" v-model="userData.accountConfirmPassword"
                                        autocomplete="off" placeholder="Confirm Password"
                                        class="block w-1/2 m-auto outline-none rounded-md border-0 ps-4 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-green-600 sm:text-sm sm:leading-6" />
                                    <ErrorMessage class="flex justify-center text-sm text-red-500"
                                        name="confirmPassword" />

                                    <button :disabled="isSuccess"
                                        class="mb-3 block w-1/2 m-auto rounded px-6 pb-2 pt-2.5 text-xs font-bold  leading-normal text-gray-500 shadow-dark-3 transition duration-150 ease-in-out hover:shadow-dark-2 focus:shadow-dark-2 focus:outline-none focus:ring-0 active:shadow-dark-2 dark:shadow-black/30 dark:hover:shadow-dark-strong dark:focus:shadow-dark-strong dark:active:shadow-dark-strong"
                                        type="submit" data-twe-ripple-init data-twe-ripple-color="light" style="
                        background: linear-gradient(to right, #07B29C, #00CCB9, #00C6B4, #00B8A2,#00AEA0);">
                                        Sign up
                                    </button>
                                </Form>



                                <div class="flex items-center justify-center  mt-5">
                                    <p class=" text-center text-sm text-gray-500">Have an account? <router-link
                                            :to="{ path: '/login' }"
                                            class="cursor-pointer font-bold leading-6  hover:text-black">
                                            Login
                                        </router-link></p>

                                </div>

                                <div class="flex items-center justify-center  ">
                                    <p class=" text-center text-sm text-gray-500">
                                        I'm a company,
                                        <span @click="changeRegisterForm"
                                            class="cursor-pointer font-bold leading-6  hover:text-black">Sign up
                                        </span>
                                    </p>
                                </div>
                            </div>
                        </div>

                        <!-- Right column container with background and description-->
                        <div class="flex items-center rounded-b-lg lg:w-6/12 lg:rounded-e-lg lg:rounded-bl-none"
                            style="background: linear-gradient(to right, #07B29C, #00CCB9, #00C6B4, #00B8A2,#00AEA0);">
                            <div class="px-4 py-6 text-gray-700 md:mx-6 md:p-12">
                                <h4 class="mb-6 text-xl font-semibold">
                                    We are more than just a company
                                </h4>
                                <p class="text-sm">
                                    Lorem ipsum dolor sit amet, consectetur adipisicing
                                    elit, sed do eiusmod tempor incididunt ut labore et
                                    dolore magna aliqua. Ut enim ad minim veniam, quis
                                    nostrud exercitation ullamco laboris nisi ut aliquip ex
                                    ea commodo consequat.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

import { Form, Field, ErrorMessage } from "vee-validate"
import { mapActions } from "pinia";
import { useGlobalStore } from "../../stores";
import { useToast } from 'vue-toast-notification';
import { CustomerService } from "../../services/customerService";
import { registerCustomerSchema } from "../../validations/formValidations/customerFormValidation";

const $toast = useToast();
const customerService = new CustomerService();

export default {

    data() {
        return {
            userData: {
                firstName: "",
                lastName: "",
                accountEmail: "",
                accountPhoneNumber: "",
                accountUsername: "",
                accountPassword: "",
                accountConfirmPassword: ""
            },
            isSuccess : false
        }
    },

    methods: {


        registerAsCustomer(user) {

            const customer = user;
            
            customerService.addCustomer(customer).then(result => {

                this.isSuccess = true

                $toast.success('Account created!', {
                    position: "top",
                });
                setTimeout(() => {
                    this.$router.push({ path: "/login" })
                }, 1500);

            }).catch(error => {
                console.log(error);
                
                const message = error.response.data.message
                $toast.error(message)
            })

        },

        ...mapActions(useGlobalStore, ["changeRegisterForm"]),
    },

    computed: {

        customerValidationSchema() {
            return registerCustomerSchema;
        }

    },


    components: { Form, Field, ErrorMessage }

}
</script>