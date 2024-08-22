<template>
    <router-link :to="{ path: `/product/${product.id}` }">
        <div class="bg-white rounded-lg overflow-hidden shadow-lg ring-2 ring-green-500 ring-opacity-40 ">
            <div class="relative">
                <img class="w-full h-52 object-scale-down " :src="product.productPhotos[0].url"
                    alt="Product Image">
                <div class="absolute top-0 right-0 bg-lightgreen text-white px-2 py-1 m-2 rounded-md text-sm font-medium">
                    SALE
                </div>
            </div>
            <div class="p-4">
                <h3 class="text-lg font-medium mb-2">{{ product.name }}</h3>
                <p class="text-gray-600 text-sm mb-4 truncate">{{product.description}}</p>
                <div class="flex items-center justify-between">
                    <span class="font-bold text-md">${{ product.minPrice }} - ${{ product.maxPrice }}</span>
                    <button class="bg-lightgreen hover:bg-green-500 text-white font-bold py-2 px-4 rounded">
                        Buy Now
                    </button>
                </div>
            </div>
        </div>
    </router-link>
</template>


<script>

export default {


    props: ["product"]

}
</script>