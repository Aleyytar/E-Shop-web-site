<template>
    <div v-if="awaitingProducts.length > 0">
        <ul class="mt-5">
            <li v-for="(awaitingProduct, index) in awaitingProducts" :key="index"
                class="flex justify-between border-2 border-yellow-500 gap-x-6 my-3 py-5 card-shadow bg-gray-200 rounded-2xl px-5">
                <div class="flex min-w-0 gap-x-4">
                    <div class="space-y-3">
                        <img class="w-36 h-36 flex-none rounded-3xl bg-gray-50"
                            :src="awaitingProduct.productPhotos == 0 ? defaultPhoto : awaitingProduct.productPhotos[0].url"
                            alt="" />
                        <button v-if="awaitingProduct.productPhotos.length > 0"
                            @click="makeActiveProduct(awaitingProduct)"
                            class="inline-flex items-center justify-center w-36 h-11 px-4 py-2 bg-green-600 hover:bg-green-700 text-white text-sm font-medium rounded-md">
                            <svg fill="#ffffff" version="1.1" class="w-5 h-5 mr-1"
                                xmlns:sketch="http://www.bohemiancoding.com/sketch/ns"
                                xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                                viewBox="0 0 24 24" xml:space="preserve" stroke="#ffffff">
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
                    </div>
                    <div class="min-w-0 flex-auto">
                        <p class="text-md   font-semibold leading-6 text-gray-900">{{ awaitingProduct.name }}
                        </p>
                        <p class="mt-1  truncate text-xs leading-5 text-gray-500">{{ awaitingProduct.description }}
                        </p>
                    </div>

                </div>

                <div class="hidden shrink-0 sm:flex flex-col justify-center items-end space-y-1">
                    <button @click="makePassiveProduct(awaitingProduct)"
                        class="inline-flex items-center justify-center w-36 h-11 px-4 py-2 bg-red-600 hover:bg-red-800 text-white text-sm font-medium rounded-md">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 mr-2" fill="none" viewBox="0 0 24 24"
                            stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                        </svg>
                    </button>


                    <router-link :to="{ name: 'ProductUpdatePage', params: { id: awaitingProduct.id } }">
                        <button
                            class="inline-flex items-center justify-center w-36 h-11 px-4 py-2 bg-blue-600 hover:bg-blue-700 text-white text-sm font-medium rounded-md">
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                                stroke="currentColor" class="w-5 h-5 mr-2">
                                <path stroke-linecap="round" stroke-linejoin="round"
                                    d="M16.023 9.348h4.992v-.001M2.985 19.644v-4.992m0 0h4.992m-4.993 0 3.181 3.183a8.25 8.25 0 0 0 13.803-3.7M4.031 9.865a8.25 8.25 0 0 1 13.803-3.7l3.181 3.182m0-4.991v4.99" />
                            </svg>
                            Update
                        </button>
                    </router-link>

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
                            enter-from-class="transform opacity-0 scale-95"
                            enter-to-class="transform opacity-100 scale-100"
                            leave-active-class="transition ease-in duration-75"
                            leave-from-class="transform opacity-100 scale-100"
                            leave-to-class="transform opacity-0 scale-95">
                            <MenuItems
                                class="absolute right-0 z-10 mt-2 w-48 origin-top-right rounded-md bg-gray-200 py-1 shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none">
                                <MenuItem v-slot="{ active }">
                                <button @click="makePassiveProduct(awaitingProduct)" class="text-start w-full"
                                    :class="[active ? 'bg-gray-100' : '', 'block px-4 py-2 text-sm text-gray-700']">Passive</button>
                                </MenuItem>
                                <MenuItem v-slot="{ active }">
                                <router-link :to="{ name: 'ProductUpdatePage', params: { id: awaitingProduct.id } }">
                                    <button class="text-start w-full"
                                    :class="[active ? 'bg-gray-100' : '', 'block px-4 py-2 text-sm text-gray-700']">Update</button>
                                </router-link>
                                </MenuItem>
                            </MenuItems>
                        </transition>
                    </Menu>

                </div>
            </li>
        </ul>
    </div>

    <div v-else class="flex justify-center items-center">
        <h2 class="font-bold text-2xl">There is no awaiting product...</h2>
    </div>
</template>

<script>
import { Menu, MenuButton, MenuItems, MenuItem } from '@headlessui/vue';
import { useCompanyStore } from '../../stores/user/company';
import { NormalProductService } from '../../services/normalProductService';
import { mapActions, mapState } from 'pinia';
import { useUserStore } from '../../stores/user';
import { useGlobalStore } from '../../stores';

const normalProductService = new NormalProductService();

export default {

    created() {
        this.getAwaitingProductsByCompanyId(this.getActiveUser.id)
        setTimeout(() => {
            this.awaitingProducts = this.getAwaitingProducts;
        }, 100);
    },

    data() {
        return {
            defaultPhoto: "/default-product.png",
            awaitingProducts: []
        }
    },

    methods: {

        makeActiveProduct(product) {
            const updatedProduct = {
                id: product.id,
                productId: product.productId,
                productCompanyId: product.productCompanyId,
                productSubCategoryId: product.productSubCategoryId,
                productGenderId: product.genderId,
                productName: product.name,
                productDescription: product.description,
                productMinPrice: product.minPrice,
                productMaxPrice: product.maxPrice,
                productStatusId: 1
            }
            normalProductService.update(updatedProduct).then(response => {
                this.awaitingProducts = this.awaitingProducts.filter(awaitingProduct => awaitingProduct.id != updatedProduct.id)
            })
        },

        makePassiveProduct(product) {
            const updatedProduct = {
                id: product.id,
                productId: product.productId,
                productCompanyId: product.productCompanyId,
                productSubCategoryId: product.productSubCategoryId,
                productGenderId: product.genderId,
                productName: product.name,
                productDescription: product.description,
                productMinPrice: product.minPrice,
                productMaxPrice: product.maxPrice,
                productStatusId: 2
            }
            normalProductService.update(updatedProduct).then(response => {
                this.awaitingProducts = this.awaitingProducts.filter(awaitingProduct => awaitingProduct.id != updatedProduct.id)
            })


        },

        ...mapActions(useCompanyStore, ["getAwaitingProductsByCompanyId"]),
        ...mapActions(useGlobalStore, ["changeShowProductAddDialog"]),
    },
    computed: {
        ...mapState(useCompanyStore, ["getAwaitingProducts"]),
        ...mapState(useUserStore, ["getActiveUser", "getCompanyAccountId"]),
    },

    components: { Menu, MenuButton, MenuItems, MenuItem }

}
</script>