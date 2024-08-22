<template>
  <div>
    <Navbar />
    <loading v-if="!product" v-model:active="isLoading" :is-full-page="fullPage" />
    <div v-else class="font-sans  mt-14">
      <div class="p-6 lg:max-w-7xl max-w-4xl mx-auto">
        <div class="grid items-start grid-cols-1 lg:grid-cols-5 gap-12 shadow-[0_2px_10px_-3px_rgba(6,81,237,0.3)] p-6">

          <ProductDetailPhotoField :productPhotos="product.productPhotos" />

          <div class="lg:col-span-2">

            <div class="flex items-center gap-4">
              <router-link :to="{path:`/company/${this.product.companyId}`}">
                <img class="w-20 h-20 rounded-full" :src="this.product.companyProfilePhotoUrl" alt="">
              </router-link>

              <div class="font-medium dark:text-white">
                <div>{{ this.product.companyName }}</div>
                <div class="text-sm text-gray-500 dark:text-gray-400">Producing Company</div>
              </div>
            </div>

            <h2 class="text-2xl font-extrabold text-[#333]">{{ product?.name }}</h2>
            <div class="flex flex-wrap gap-4 mt-4">
              <p class="text-[#333] text-3xl font-bold">${{ product?.minPrice }} - ${{ product?.maxPrice }} </p>
            </div>



            <div class="flex space-x-2 mt-4">
              <svg v-for="i in 4" class="w-5 fill-[#333]" viewBox="0 0 14 13" fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M7 0L9.4687 3.60213L13.6574 4.83688L10.9944 8.29787L11.1145 12.6631L7 11.2L2.8855 12.6631L3.00556 8.29787L0.342604 4.83688L4.5313 3.60213L7 0Z" />
              </svg>
              <svg class="w-5 fill-[#CED5D8]" viewBox="0 0 14 13" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M7 0L9.4687 3.60213L13.6574 4.83688L10.9944 8.29787L11.1145 12.6631L7 11.2L2.8855 12.6631L3.00556 8.29787L0.342604 4.83688L4.5313 3.60213L7 0Z" />
              </svg>
              <h4 class="text-[#333] text-base">500 Reviews</h4>
            </div>

            <ProductDetailColorField :productColors="product.productColors" />

            <div class="flex flex-wrap gap-4 mt-10">
              <button type="button"
                class="min-w-[200px] px-4 py-3 bg-[#333] hover:bg-[#111] text-white text-sm font-semibold rounded">Buy
                now</button>
              <button type="button"
                class="min-w-[200px] px-4 py-2.5 border border-[#333] bg-transparent hover:bg-gray-50 text-[#333] text-sm font-semibold rounded">Add
                to cart</button>
            </div>
          </div>
        </div>

        <div class="mt-16 shadow-[0_2px_10px_-3px_rgba(6,81,237,0.3)] p-6">
          <h3 class="text-lg font-bold text-[#333]">Product information</h3>
          <p>{{ product.description }}</p>
        </div>

        <ProductDetailReviewField />

      </div>
    </div>
  </div>

</template>


<script>
import { NormalProductService } from '../services/normalProductService';
import ProductDetailPhotoField from '../components/productDetail/ProductDetailPhotoField.vue';
import Loading from 'vue-loading-overlay';
import ProductDetailColorField from '../components/productDetail/ProductDetailColorField.vue';
import Navbar from '../components/common/Navbar.vue'
import ProductDetailReviewField from '../components/productDetail/ProductDetailReviewField.vue';
import { mapState } from 'pinia';
import { useUserStore } from '../stores/user';

const normalProductService = new NormalProductService();

export default {

  created() {
    normalProductService.getProductById(this.$route.params.id).then(response => {
      this.product = response
      this.product.companyProfilePhotoUrl == null ? this.product.companyProfilePhotoUrl = this.getDefaultProfilePhoto : null
    })
  },

  data() {
    return {
      product: null,
      isLoading: true,
      fullPage: true,
    }
  },

  computed: {

    ...mapState(useUserStore, ["getDefaultProfilePhoto"])
  },

  components: { ProductDetailPhotoField, Loading, ProductDetailColorField, Navbar, ProductDetailReviewField }
}
</script>