<template>
    <ul role="list" class="p-6 divide-y divide-slate-200 ">
        <li v-for="product in this.getActiveProducts" class="flex py-4 first:pt-0 last:pb-0 ">
            <img class="h-20 w-20 rounded-full bg-white" :src="product.productPhotos[0].url" alt="" />
            <div class="flex justify-between items-center w-full">
                <div class="ml-3 overflow-hidden">
                    <p class="text-sm font-medium text-slate-900">{{ product.name }}</p>
                    <p class="w-32 sm:w-64 truncate">{{product.description }}</p>
                </div>
                <router-link :to="{path:`/product/${product.id}`}" class="relative p-0 sm:px-3 sm:py-3 text-center overflow-hidden font-medium text-[#07B29C] bg-gray-100 border border-gray-100 rounded-lg shadow-inner group">
                    <span
                        class="absolute top-0 left-0 w-0 h-0 transition-all duration-200 border-t-2 border-[#07B29C] group-hover:w-full ease"></span>
                    <span
                        class="absolute bottom-0 right-0 w-0 h-0 transition-all duration-200 border-b-2 border-[#07B29C] group-hover:w-full ease"></span>
                    <span
                        class="absolute top-0 left-0 w-full h-0 transition-all duration-300 delay-200 bg-[#07B29C] group-hover:h-full ease"></span>
                    <span
                        class="absolute bottom-0 left-0 w-full h-0 transition-all duration-300 delay-200 bg-[#07B29C] group-hover:h-full ease"></span>
                    <span
                        class="absolute inset-0 w-full h-full duration-300 delay-300 bg-[#07B29C] opacity-0 group-hover:opacity-100"></span>
                    <span class="relative transition-colors duration-300 delay-200 group-hover:text-white ease">See
                        details</span>
                    </router-link>
            </div>
        </li>
    </ul>
</template>

<script>
import { mapActions, mapState } from 'pinia';
import { useUserStore } from '../../../stores/user';
import { useCompanyStore } from '../../../stores/user/company';



export default {

    created() {
        this.getActiveProductsByCompanyId(this.$route.params.id)
    },

    methods: {
        ...mapActions(useCompanyStore, ["getActiveProductsByCompanyId"])
    },

    computed: {

        ...mapState(useCompanyStore, ["getActiveProducts"]),
        ...mapState(useUserStore, ["getDefaultProfilePhoto"])
    }



}

</script>