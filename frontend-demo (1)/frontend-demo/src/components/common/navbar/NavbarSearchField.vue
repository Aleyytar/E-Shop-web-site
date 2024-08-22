<template>
    <div class="flex ml-auto">
        <form class="flex items-center max-w-sm ">
            <label for="simple-search" class="sr-only">Search</label>
            <div class="relative w-full">
                <div class="absolute inset-y-0 ps-1 start-0 flex items-center  pointer-events-none">
                    <img src="../../../assets/searchbar-icon.png" class="h-10" alt="">
                </div>
                <input v-model="search" type="text" id="simple-search"
                    class="bg-gray-50 outline-none border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-green-600 focus:border-green-600 block w-full ps-12 p-2.5  "
                    placeholder="Search products..." autocomplete="off" />
            </div>
            <button @click="searchProduct(search)" type="submit">
                <div class="flex ">
                    <a href="#" class="p-2 text-gray-400 hover:text-gray-500">
                        <span class="sr-only">Search</span>
                        <MagnifyingGlassIcon class="h-6 w-6" aria-hidden="true" />
                    </a>
                </div>
            </button>
        </form>
    </div>
</template>


<script>
import { MagnifyingGlassIcon } from '@heroicons/vue/24/outline'
import { mapActions } from 'pinia';
import { useNormalProductStore } from '../../../stores/product/normalProduct';

export default {

    data() {
        return {
            search: "",
        }
    },

    methods: {
        searchProduct(value) {

            if (!value == false) {
                this.setFilteredProducts(value)
            } else {
                this.setProducts()
            }

        },

        ...mapActions(useNormalProductStore, ["setFilteredProducts", "setProducts"])
    },






    components: { MagnifyingGlassIcon }
}
</script>