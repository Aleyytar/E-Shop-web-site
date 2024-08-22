<template>
    <Form @submit="updateProduct" :validation-schema="productUpdateFormValidationSchema" v-if="targetProduct"
        id="drawer-update-product"
        class="sm:relative sm:left-1/2 sm:-translate-x-1/2  max-w-5xl p-4 border-lightgreen border-2 rounded-2xl bg-white dark:bg-gray-800"
        tabindex="-1" aria-labelledby="drawer-update-product-label" aria-hidden="true">
        <h5 id="drawer-label"
            class="inline-flex items-center mb-6 text-sm font-semibold text-gray-500 uppercase dark:text-gray-400">
            Update Product</h5>
        <div class="grid gap-4 sm:grid-cols-3 sm:gap-6 ">
            <div class="space-y-4 sm:col-span-2 sm:space-y-6">
                <div>
                    <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Product
                        Name</label>
                    <Field name="productName" v-model="targetProduct.name" type="text" id="name"
                        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                        placeholder="Type product name" required="" autocomplete="off" />
                    <ErrorMessage name="productName" class=" flex justify-center text-sm text-red-500" />
                </div>
                <div>
                    <label for="description"
                        class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Description</label>
                    <div
                        class="w-full border border-gray-200 rounded-lg bg-gray-50 dark:bg-gray-700 dark:border-gray-600">
                        <div class="flex items-center justify-between px-3 py-2 border-b dark:border-gray-600">
                            <div class="flex flex-wrap items-center divide-gray-200 sm:divide-x dark:divide-gray-600">
                                <div class="flex items-center space-x-1 sm:pr-4">
                                    <button type="button"
                                        class="p-2 text-gray-500 rounded cursor-pointer hover:text-gray-900 hover:bg-gray-100 dark:text-gray-400 dark:hover:text-white dark:hover:bg-gray-600">
                                        <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewbox="0 0 20 20"
                                            xmlns="http://www.w3.org/2000/svg">
                                            <path fill-rule="evenodd"
                                                d="M10 18a8 8 0 100-16 8 8 0 000 16zM7 9a1 1 0 100-2 1 1 0 000 2zm7-1a1 1 0 11-2 0 1 1 0 012 0zm-.464 5.535a1 1 0 10-1.415-1.414 3 3 0 01-4.242 0 1 1 0 00-1.415 1.414 5 5 0 007.072 0z"
                                                clip-rule="evenodd" />
                                        </svg>
                                        <span class="sr-only">Add emoji</span>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class=" px-4 py-3 bg-white rounded-b-lg dark:bg-gray-800">
                            <Field name="productDescription" v-model="targetProduct.description" id="description"
                                rows="8"
                                class="outline-none block w-full px-0 text-sm text-gray-800 bg-white border-0 dark:bg-gray-800 focus:ring-0 dark:text-white dark:placeholder-gray-400"
                                placeholder="Write product description here" as="textarea" />
                        </div>
                    </div>
                    <ErrorMessage name="productDescription" class="flex justify-center text-sm text-red-500" />
                </div>
                <ProductUpdatePhotoField />
            </div>
            <div class="space-y-4 sm:space-y-6">
                <div>
                    <label for="product-brand"
                        class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Brand</label>
                    <input readonly v-model="targetProduct.companyName" type="text" id="product-brand" disabled
                        class="border border-gray-300 bg-gray-300 cursor-not-allowed text-gray-900 text-sm rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                        placeholder="Product Brand" />
                </div>
                <div class="flex items-center justify-around mb-4">
                    <Field @click="this.$emit('getManSubCategory')" v-model="targetProduct.productGenderId" :value="1"
                        name="productGenderId" type="radio"
                        class="w-4 h-4 outline-none text-blue-600 bg-gray-100 border-gray-300  dark:focus:ring-blue-600 dark:ring-offset-gray-800 dark:bg-gray-700 dark:border-gray-600" />
                    For men
                    <Field @click="this.$emit('getWomenSubCategory')" v-model="targetProduct.productGenderId" :value="2"
                        name="productGenderId" type="radio"
                        class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 dark:bg-gray-700 dark:border-gray-600" />
                    For women
                    <Field @click="this.$emit('getUnisexSubCategory')" v-model="targetProduct.productGenderId"
                        :value="3" name="productGenderId" type="radio"
                        class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 dark:bg-gray-700 dark:border-gray-600" />
                    For unisex
                </div>
                <ErrorMessage name="productGenderId" class="flex justify-center text-sm text-red-500" />
                <div>
                    <label for="category"
                        class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Category</label>
                    <Field name="productSubCategoryId" v-model="targetProduct.productSubCategoryId" as="select"
                        class="outline-none bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-green-500 focus:border-green-500 block w-full p-2.5 ">
                        <option v-for="subCategory in subCategories" :value="subCategory.id">{{ subCategory.name }}
                        </option>
                    </Field>
                    <ErrorMessage name="productSubCategoryId" class="flex justify-center text-sm text-red-500" />
                </div>
                <div>
                    <label for="min-price" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Min
                        Price</label>
                    <Field name="productMinPrice" v-model="targetProduct.minPrice" type="number" id="min-price"
                        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                        placeholder="Ex. 12" />
                    <ErrorMessage name="productMinPrice" class="flex justify-center text-sm text-red-500" />
                </div>
                <div>
                    <label for="max-price" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Max
                        Price</label>
                    <Field name="productMaxPrice" v-model="targetProduct.maxPrice" type="number" id="max-price"
                        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                        placeholder="Ex. 12" />
                    <ErrorMessage name="productMaxPrice" class="flex justify-center text-sm text-red-500" />
                </div>

                <ProductUpdateColorField />


            </div>
        </div>
        <div class="grid grid-cols-2 gap-4 mt-6 sm:w-1/2">
            <button
                class="text-white bg-green-600 hover:bg-green-700 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">Update
                product</button>
        </div>
    </Form>
</template>

<script>
import { Form, Field, ErrorMessage } from 'vee-validate'
import { productUpdateSchema } from "../../validations/formValidations/productFormValidation";
import ProductUpdatePhotoField from "../productupdate/ProductUpdatePhotoField.vue"
import ProductUpdateColorField from './ProductUpdateColorField.vue';
import {NormalProductService} from '../../services/normalProductService'

const normalProductService = new NormalProductService();

export default {
    methods: {
        updateProduct(product) {
            
            const data = {
                id:this.targetProduct.id,
                productId:this.targetProduct.productId,
                productCompanyId : this.targetProduct.companyId,
                productStatusId: this.targetProduct.productStatusId,
                ...product
            }
            
            normalProductService.update(data).then(response => {
                this.$toast.success("Product is updated successfully")
            }).catch(error => {
                const message = error.response.data.message
                this.$toast.error(message)
            })

        },
    },
    computed: {
        productUpdateFormValidationSchema() {
            return productUpdateSchema;
        },
    },

    props: ['targetProduct', 'subCategories'],
    components: { Form, Field, ErrorMessage, ProductUpdatePhotoField,ProductUpdateColorField }
}
</script>