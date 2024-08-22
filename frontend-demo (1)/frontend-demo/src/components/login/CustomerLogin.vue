<template>
  <div class="rounded-md px-20 py-5 form-shadow  sm:px-40 sm:py-20 bg-gray-50 drop-shadow-lg">
    <div class="sm:mx-auto sm:w-full sm:max-w-sm">
      <img class="mx-auto h-40 w-auto" src="../../assets/mainLogo1.png" alt="Your Company" />
      <h2 class="mt-2 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">Sign in as Customer</h2>
    </div>

    <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm ">

      <Form @submit="loginAsCustomer(userData)" :validation-schema="customerValidationSchema">
        <label for="email" class="block text-sm font-medium leading-6 text-gray-900">Email address</label>
        <Field name="email" v-model="userData.email" autocomplete="off"
          class="block w-full outline-none rounded-md border-0 ps-4 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-green-600 sm:text-sm sm:leading-6" />


        <ErrorMessage class="text-red" name="email" />
        <label for="password" class="block text-sm font-medium leading-6 text-gray-900">Password</label>
        <Field type="password" name="password" v-model="userData.password"
          class="block w-full outline-none rounded-md border-0 ps-4 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-green-600 sm:text-sm sm:leading-6" />
        <ErrorMessage name="password" />

        <div>
          <button v-if="!isSuccess"
            class="flex mt-5 w-full justify-center rounded-md bg-lightgreen transition-colors px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Sign
            in</button>

          <button v-else type="button" disabled
            class="flex mt-5 w-full justify-center rounded-md bg-green-700   transition-colors px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">
            <img src="../../assets/loading.svg" class="text-white animate-spin w-5 my-auto mr-3 ..." alt="">
            Processing...
          </button>

        </div>
      </Form>

      <p class="mt-10 text-center text-sm text-gray-500">
        I'm a company,
        <span @click="changeLoginForm" class="cursor-pointer font-bold leading-6  hover:text-black">login
        </span>
      </p>

      <p class=" text-center text-sm text-gray-500">I'm new here, <router-link :to="{ path: '/register' }"
          class="cursor-pointer font-bold leading-6  hover:text-black">
          sign up
        </router-link></p>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'pinia';
import { ErrorMessage, Field, Form } from 'vee-validate';
import { useGlobalStore } from '../../stores';
import { CustomerService } from '../../services/customerService';
import { useUserStore } from '../../stores/user';
import { loginCustomerSchema } from '../../validations/formValidations/customerFormValidation';

const customerService = new CustomerService();

export default {

  data() {
    return {
      userData: {
        email: "",
        password: ""
      },
      isSuccess: false,
    }
  },

  methods: {

    loginAsCustomer(user) {
      
      customerService.checkCustomerFields(user.email).then(response => {

        const result = response.data;

        if (result.email != null) {

          if (result.password == user.password) {
            customerService.getCustomerById(result.id).then(response => {
              
              const customer = response
              delete customer.customerFollowers;
              delete customer.favoriteProducts;

              this.setActiveCustomerUser(customer)
              this.isSuccess = true

              this.$toast.success("You have successfully logged in")


              setTimeout(() => {
                this.$router.push({ path: "/" })
              }, 1500);

            })

          } else {
            this.$toast.error("Password is not correct")
          }
        } else {
          this.$toast.error("There is no such customer account")
        }
      })

    },

    ...mapActions(useUserStore, ["setActiveCustomerUser"]),
    ...mapActions(useGlobalStore, ["changeLoginForm"])
  },

  computed: {

    customerValidationSchema() {
      return loginCustomerSchema
    }

  },

  components: { ErrorMessage, Field, Form }


}
</script>