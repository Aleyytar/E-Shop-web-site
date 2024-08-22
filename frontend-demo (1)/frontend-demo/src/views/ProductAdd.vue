<template>
    <div class="h-screen bg-create  flex justify-center items-center">
        <div class="p-20 bg-white form-shadow border-lightgreen border-2 rounded-2xl">
            <p class="text-center text-[2.5em] font-semibold">Create Product</p>

            <Form @submit="addProduct" :validation-schema="productAddFormValidationSchema">
                <div class="grid md:grid-cols-2 mx-auto my-5 md:gap-6">

                    <label for="productType"
                        class="block my-auto text-center  sm:text-start mb-2 text-sm font-medium text-gray-900 ">Choose
                        a product type</label>
                    <Field name="productType" v-model="productType"
                        class="outline-none bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-green-500 focus:border-green-500 block w-full p-2.5 "
                        as="select">
                        <option value="1" selected>Normal</option>
                        <option value="2">Special</option>

                    </Field>
                </div>

                <div class="relative items-center z-0 w-full mb-5 group">
                    <Field placeholder="Product Name" name="productName" autocomplete="off"
                        class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none   focus:outline-none focus:ring-0 focus:border-green-500 peer" />
                </div>
                <ErrorMessage class="flex justify-center text-sm text-red-500" name="productName" />


                <div class="flex items-center justify-around mb-4">
                    <Field @click="getMenSubCategoryList"  :value="1"
                        name="productGenderId" type="radio"
                        class="w-4 h-4 outline-none text-blue-600 bg-gray-100 border-gray-300  dark:focus:ring-blue-600 dark:ring-offset-gray-800 dark:bg-gray-700 dark:border-gray-600" />
                    For men
                    <Field @click="getWomenSubCategoryList"  :value="2"
                        name="productGenderId" type="radio"
                        class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 dark:bg-gray-700 dark:border-gray-600" />
                    For women
                    <Field @click="getUnisexSubCategoryList"  :value="3"
                        name="productGenderId" type="radio"
                        class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 dark:bg-gray-700 dark:border-gray-600" />
                    For unisex
                </div>
                <ErrorMessage class="flex justify-center text-sm text-red-500" name="productGenderId"  />


                <div class="grid md:grid-cols-2 mx-auto  md:gap-6">
                    <label for="subCategoryId"
                        class="block my-auto text-center  sm:text-start mb-2 text-sm font-medium text-gray-900">Choose
                        a sub category</label>

                    <Field  v-model="subCategoryId" name="productSubCategoryId"  as="select"
                        class="outline-none bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-green-500 focus:border-green-500 block w-full p-2.5 ">
                        <option v-for="subCategory in subCategory" :value="subCategory.id">{{ subCategory.name }}
                        </option>
                    </Field>

                </div>
                <ErrorMessage class="flex justify-center text-sm text-red-500" name="productSubCategoryId" />


                <div class="grid md:grid-cols-2 md:gap-6">
                    <div class="relative z-0 w-full mb-4 sm:mb-0 group">
                        <Field placeholder="Min Price" name="productMinPrice" type="number"
                            autocomplete="off" 
                            class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none focus:outline-none focus:ring-0 focus:border-green-500 peer" />
                    </div>

                    <div class="relative z-0 w-full mb-4 sm:mb-0 group">
                        <Field placeholder="Max Price" name="productMaxPrice" type="number"
                            autocomplete="off"
                            class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none focus:outline-none focus:ring-0 focus:border-green-500 peer" />
                    </div>
                </div>
                <ErrorMessage class="flex justify-center text-sm text-red-500" name="productMinPrice" />
                <ErrorMessage class="flex justify-center text-sm text-red-500" name="productMaxPrice" />


                <div class="relative z-0 w-full mb-5 group">
                    <Field placeholder="Product description..." 
                        name="productDescription" rows="4" as="textarea"
                        class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none  focus:outline-none focus:ring-0 focus:border-green-500 peer" />
                </div>
                <ErrorMessage class="flex justify-center text-sm text-red-500" name="productDescription" />



                <div>
                    <button type="submit"
                    class="cursor-pointer left-1/2 translate-x-[-50%] relative inline-flex items-center justify-center p-4 px-6 py-3 overflow-hidden font-medium  text-white transition duration-300 ease-out border-2  rounded-full shadow-md group">
                    <span
                        class="absolute inset-0 flex items-center justify-center w-full h-full text-white duration-300 -translate-x-full bg-green-500 group-hover:translate-x-0 ease">
                        <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24"
                            xmlns="http://www.w3.org/2000/svg">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="M14 5l7 7m0 0l-7 7m7-7H3"></path>
                        </svg>
                    </span>
                    <span
                        class="absolute flex items-center justify-center w-full h-full  transition-all duration-300 bg-lightgreen transform group-hover:translate-x-full ease">Add
                        Product</span>
                    <span class="relative invisible">Add Product</span>
                </button>
                </div>
            </Form>
        </div>
    </div>
</template>

<script>
import { Form, Field, ErrorMessage } from 'vee-validate'
import { Menu, MenuButton, MenuItem, MenuItems } from '@headlessui/vue'
import { ChevronDownIcon } from '@heroicons/vue/20/solid'
import { useSubCategoryStore } from '../stores/category/subCategory'
import { useUserStore } from '../stores/user'
import { mapState } from 'pinia'
import { productAddSchema } from '../validations/formValidations/productFormValidation'
import { NormalProductService } from '../services/normalProductService'
import { useToast } from 'vue-toast-notification';
import { SpecialProductService } from '../services/specialProductService'

const $toast = useToast();
const subCategoryStore = useSubCategoryStore();
const normalProductService = new NormalProductService();
const specialProductService = new SpecialProductService();

export default {

    created() {
        subCategoryStore.getAllMenSubCategories()
        subCategoryStore.getAllWomenSubCategories()
        subCategoryStore.getAllUnisexSubCategories()
        setTimeout(() => {
            this.subCategory = this.getMenSubCategory
        }, 100);
    },

    data() {
        return {
            productType: 1,
            subCategory: [],
            subCategoryId: null
        }
    },

    methods: {

        addProduct(userData) {

            if (this.productType == 1) {

                const product = {
                    productCompanyId: this.getActiveUser.id,
                    ...userData
                }
                delete product.productType

                normalProductService.add(product).then(result => {

                    $toast.success("Product is added")
                    $toast.info("After product add, you should add product photos and colors",{dismissible:false,duration:4000})

                }).catch(error => {
                    const message = error.response.data.message
                    $toast.error(message)
                })
                console.log(product);



            } else {

                const product = {
                    productCompanyId: this.getActiveUser.id,
                    ...userData
                }
                delete product.productType

                specialProductService.add(product).then(result => {

                    $toast.success("Special Product is added")
                    $toast.info("After product add, you should add product photos and colors",{dismissible:false,duration:4000})


                }).catch(error => {
                    const message = error.response.data.message
                    $toast.error(message)
                })

            }

        },

        getMenSubCategoryList() {
            this.subCategory = this.getMenSubCategory;
            this.subCategoryId = null
        },

        getWomenSubCategoryList() {
            this.subCategory = this.getWomenSubCategory;
            this.subCategoryId = null
        },

        getUnisexSubCategoryList() {
            this.subCategory = this.getUnisexSubCategory;
            this.subCategoryId = null
        }
    },

    computed: {

        productAddFormValidationSchema() {
            return productAddSchema;
        },

        ...mapState(useSubCategoryStore, ["getMenSubCategory", "getWomenSubCategory", "getUnisexSubCategory"]),
        ...mapState(useUserStore, ["getActiveUser"])

    },

    components: { Menu, MenuButton, MenuItem, MenuItems, ChevronDownIcon, Form, Field, ErrorMessage }

}
</script>