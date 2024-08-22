<template>
    <div class="lg:col-span-3 w-full lg:sticky top-0 text-center">
        <div class="px-4 py-10 rounded-xl shadow-[0_2px_10px_-3px_rgba(6,81,237,0.3)] relative">
            <img :src="this.productPhotos[this.currentIndex].url" alt="Product" class="w-3/5 m-auto rounded object-cover" />
            <button type="button" class="absolute top-4 right-4">
                <svg xmlns="http://www.w3.org/2000/svg" width="20px" fill="#ccc" class="mr-1 hover:fill-[#333]"
                    viewBox="0 0 64 64">
                    <path
                        d="M45.5 4A18.53 18.53 0 0 0 32 9.86 18.5 18.5 0 0 0 0 22.5C0 40.92 29.71 59 31 59.71a2 2 0 0 0 2.06 0C34.29 59 64 40.92 64 22.5A18.52 18.52 0 0 0 45.5 4ZM32 55.64C26.83 52.34 4 36.92 4 22.5a14.5 14.5 0 0 1 26.36-8.33 2 2 0 0 0 3.27 0A14.5 14.5 0 0 1 60 22.5c0 14.41-22.83 29.83-28 33.14Z"
                        data-original="#000000"></path>
                </svg>
            </button>
        </div>

        <div class="mt-6  p-2 w-fit flex flex-wrap justify-center gap-6 mx-auto">
            <div v-for="(photo,index) in this.productPhotos" class="bg-gray-200 rounded-xl p-4 shadow-[0_2px_10px_-3px_rgba(6,81,237,0.3)]">
                <img :src="photo.url" @click="changePhoto(index)" alt="Product2" class="w-24 cursor-pointer" />
            </div>
            
        </div>
    </div>
</template>

<script>
export default {

    data() {
        return {
            currentIndex: 0,
            photos: []
        }
    },

    methods: {
        changePhoto(index){
            this.currentIndex = index
        }
    },
    props: ["productPhotos"]
}
</script>