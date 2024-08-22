<template>
    <div>
        <div class="mb-4">
            <span class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Product Images</span>
            <div class="grid grid-cols-3 gap-4 mb-4">
                <div v-for="image in productPhotos"
                    class="relative p-2 bg-gray-100 rounded-lg sm:w-36 sm:h-36 dark:bg-gray-700">
                    <img :src="image.url" alt="imac image" class="h-full w-full" />
                    <button type="button" @click="deleteImage(image.id)"
                        class="absolute text-red-600 dark:text-red-500 hover:text-red-500 dark:hover:text-red-400 bottom-1 left-1">
                        <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewbox="0 0 20 20"
                            xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                d="M9 2a1 1 0 00-.894.553L7.382 4H4a1 1 0 000 2v10a2 2 0 002 2h8a2 2 0 002-2V6a1 1 0 100-2h-3.382l-.724-1.447A1 1 0 0011 2H9zM7 8a1 1 0 012 0v6a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v6a1 1 0 102 0V8a1 1 0 00-1-1z"
                                clip-rule="evenodd" />
                        </svg>
                        <span class="sr-only">Remove image</span>
                    </button>
                </div>

            </div>
            <div>
                <button @click="this.changeShowProductAddDialog"
                    class="inline-flex w-full sm:w-1/2 items-center justify-center h-11 px-4 py-2 bg-green-600 hover:bg-green-700 text-white text-sm font-medium rounded-md"
                    type="button">
                    <label
                        class="inline-flex bg-transparent cursor-pointer items-center justify-center  h-11 px-4 py-2 bg-green-600 hover:bg-green-700 text-white text-sm font-medium rounded-md">
                        <svg xmlns="http://www.w3.org/2000/svg" class="w-6 mr-2 fill-white inline" viewBox="0 0 32 32">
                            <path
                                d="M23.75 11.044a7.99 7.99 0 0 0-15.5-.009A8 8 0 0 0 9 27h3a1 1 0 0 0 0-2H9a6 6 0 0 1-.035-12 1.038 1.038 0 0 0 1.1-.854 5.991 5.991 0 0 1 11.862 0A1.08 1.08 0 0 0 23 13a6 6 0 0 1 0 12h-3a1 1 0 0 0 0 2h3a8 8 0 0 0 .75-15.956z"
                                data-original="#000000" />
                            <path
                                d="M20.293 19.707a1 1 0 0 0 1.414-1.414l-5-5a1 1 0 0 0-1.414 0l-5 5a1 1 0 0 0 1.414 1.414L15 16.414V29a1 1 0 0 0 2 0V16.414z"
                                data-original="#000000" />
                        </svg>
                        Upload
                    </label>
                </button>
            </div>
        </div>
        <PhotoUploadDialog @fetch-photos="fetchPhotos" :productId="productId" />
    </div>
</template>


<script>
import { mapActions } from "pinia";
import { ProductPhotoService } from "../../services/productPhotoService";
import { useGlobalStore } from "../../stores";
import PhotoUploadDialog from "../../components/announcement/PhotoUploadDialog.vue";

const productPhotoService = new ProductPhotoService();
export default {

    created() {
        productPhotoService.getPhotosByProductId(this.$route.params.id).then(response =>{
            this.productPhotos = response.data
        })

        this.productId = this.$route.params.id
    },

    data() {
        return {
            productPhotos:[],
            productId: null
        }
    },

    methods: {
        deleteImage(id){
            productPhotoService.deletePhoto(id).then(response => {
                this.productPhotos = this.productPhotos.filter(photo => photo.id != id)
            })
        },

        fetchPhotos(){
            productPhotoService.getPhotosByProductId(this.productId).then(response => {
                this.productPhotos = response.data
            })
        },

        ...mapActions(useGlobalStore, ["changeShowProductAddDialog"]),
    },

    components:{PhotoUploadDialog}
   
}
</script>