<template>
    <ul v-if="getPassiveProducts.length > 0"  class="mt-5">
        <li v-for="passiveProduct in passiveProducts" :key="passiveProduct.id" class="flex justify-between border-2 border-red-500 gap-x-6 my-3 py-5 card-shadow bg-gray-200 rounded-2xl px-5">
            <div class="flex min-w-0 gap-x-4 ">
                <img class="w-36 h-36 flex-none rounded-3xl bg-gray-50" :src="passiveProduct.productPhotos.length > 0 ? passiveProduct.productPhotos[0].url : '/default-product.png'" alt="" />
                <div class="min-w-0 flex-auto">
                    <p class="text-md font-semibold leading-6 text-gray-900">{{ passiveProduct.name }}
                    </p>
                    <p class="mt-1 truncate text-xs leading-5 text-gray-500">{{ passiveProduct.description }}
                    </p>
                </div>
            </div>
            <div class="hidden shrink-0 sm:flex flex-col justify-center items-end space-y-1">

                <button v-if="passiveProduct.productPhotos.length > 0" @click="makeActiveProduct(passiveProduct)"
                    class="inline-flex items-center justify-center w-36 h-11 px-4 py-2 bg-green-600 hover:bg-green-700 text-white text-sm font-medium rounded-md">
                    <svg fill="#ffffff" version="1.1" class="w-5 h-5 mr-1"
                            xmlns:sketch="http://www.bohemiancoding.com/sketch/ns" xmlns="http://www.w3.org/2000/svg"
                            xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" xml:space="preserve"
                            stroke="#ffffff">
                            <g id="SVGRepo_bgCarrier" stroke-width="0" />
                            <g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round" />
                            <g id="SVGRepo_iconCarrier">
                                <g id="active">
                                    <path d="M8.6,20.1l-7.8-8l1.4-1.4l6.4,6.5L21.8,3.9l1.4,1.4L8.6,20.1z" />
                                </g>
                            </g>

                        </svg>
                    Active 
                </button>
                <button @click="makeAwaitProduct(passiveProduct)"
                    class="inline-flex items-center justify-center w-36 h-11 px-4 py-2 bg-yellow-500 hover:bg-yellow-600 text-white text-sm font-medium rounded-md">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                        stroke="currentColor" class="w-5 h-5 mr-2">
                        <path stroke-linecap="round" stroke-linejoin="round"
                            d="M16.023 9.348h4.992v-.001M2.985 19.644v-4.992m0 0h4.992m-4.993 0 3.181 3.183a8.25 8.25 0 0 0 13.803-3.7M4.031 9.865a8.25 8.25 0 0 1 13.803-3.7l3.181 3.182m0-4.991v4.99" />
                    </svg>
                    Await
                </button>

            </div>

            <div class="sm:hidden my-auto">
                <Menu as="div" class="relative ml-3">
                    <div class="flex items-center justify-centery">
                        <MenuButton
                            class="outline-none relative flex rounded-full bg-white text-sm focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800">
                            <span class="absolute -inset-1.5" />
                            <span class="sr-only">Open menu</span>
                            <img class="h-6 w-6 rounded-full" src="../../assets/menu-dropdown.png" alt="" />
                        </MenuButton>
                    </div>
                    <transition enter-active-class="transition ease-out duration-100"
                        enter-from-class="transform opacity-0 scale-95" enter-to-class="transform opacity-100 scale-100"
                        leave-active-class="transition ease-in duration-75"
                        leave-from-class="transform opacity-100 scale-100"
                        leave-to-class="transform opacity-0 scale-95">
                        <MenuItems
                            class="absolute right-0 z-10 mt-2 w-48 origin-top-right rounded-md bg-gray-200 py-1 shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none">
                            <MenuItem v-slot="{ active }">
                            <a @click="makeActiveProduct(passiveProduct)"
                                :class="[active ? 'bg-gray-100' : '', 'block px-4 py-2 text-sm text-gray-700']">Active</a>
                            </MenuItem>
                            <MenuItem v-slot="{ active }">
                            <a @click="makeAwaitProduct(passiveProduct)"
                                :class="[active ? 'bg-gray-100' : '', 'block px-4 py-2 text-sm text-gray-700']">Await</a>
                            </MenuItem>

                        </MenuItems>
                    </transition>
                </Menu>

            </div>
        </li>
    </ul>
    <div v-else class="flex justify-center items-center">
        <h2 class="font-bold text-2xl">There is no passive product...</h2>
    </div>
</template>

<script>

import { Menu, MenuButton, MenuItems, MenuItem } from '@headlessui/vue';
import { mapActions, mapState } from 'pinia';
import { useCompanyStore } from '../../stores/user/company';
import { useUserStore } from '../../stores/user';
import { NormalProductService } from '../../services/normalProductService';

const normalProductService = new NormalProductService()

export default {

    created() {
        this.getPassiveProductsByCompanyId(this.getActiveUserId)

        setTimeout(() => {
            this.passiveProducts = this.getPassiveProducts;
        }, 100);
    },

    data() {
        return {
            passiveProducts:[]
        }
    },

    methods:{

        makeActiveProduct(product){
            const updatedProduct = {
                id: product.id,
                productId: product.productId,
                productCompanyId:product.productCompanyId,
                productSubCategoryId: product.productSubCategoryId,
                productGenderId: product.genderId,
                productName: product.name,
                productDescription:product.description,
                productMinPrice: product.minPrice,
                productMaxPrice: product.maxPrice,
                productStatusId: 1
            }
            normalProductService.update(updatedProduct).then(response => {
                this.passiveProducts = this.passiveProducts.filter(passiveProduct => passiveProduct.id != updatedProduct.id)
            })
        },

        makeAwaitProduct(product){
            const updatedProduct = {
                id: product.id,
                productId: product.productId,
                productCompanyId:product.productCompanyId,
                productSubCategoryId: product.productSubCategoryId,
                productGenderId: product.genderId,
                productName: product.name,
                productDescription:product.description,
                productMinPrice: product.minPrice,
                productMaxPrice: product.maxPrice,
                productStatusId: 3
            }
            normalProductService.update(updatedProduct).then(response => {
                this.passiveProducts = this.passiveProducts.filter(passiveProduct => passiveProduct.id != updatedProduct.id)
            })
        },

        ...mapActions(useCompanyStore,["getPassiveProductsByCompanyId"]),
    },

    computed:{


        ...mapState(useCompanyStore,["getPassiveProducts"]),
        ...mapState(useUserStore,["getActiveUserId"])

    },
    
    components: { Menu, MenuButton, MenuItems, MenuItem }
    
}
</script>