<template>
    <div class="bg-white">
        <div v-if="this.getProducts.length > 0" class="mx-auto max-w-2xl px-4 lg:max-w-7xl lg:px-8">
            <div class="mt-6 grid grid-cols-1 gap-x-6 gap-y-10 sm:grid-cols-2 lg:grid-cols-4 xl:gap-x-8">
                <div v-for="product in this.getProducts" :key="product.id" class="group relative">
                    <ProductItem :product="product" />
                </div>
            </div>
        </div>

        <div v-else class="mt-5">
            <h1 class="text-center text-3xl sm:text-4xl font-bold ">No active products...</h1>
        </div>
    </div>
</template>

<script>
import { mapActions, mapState } from 'pinia';
import ProductItem from './ProductItem.vue';
import Navbar from './common/Navbar.vue';
import { useNormalProductStore } from '../stores/product/normalProduct';

export default {
    
    created(){
        this.setProducts()
    },

    methods: {
        
        ...mapActions(useNormalProductStore,["setProducts"])
    },

    computed:{

        ...mapState(useNormalProductStore,["getProducts"])
    },

    components: { Navbar, ProductItem }
}
</script>