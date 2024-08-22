<template>
    <div class="space-y-2">

        <div v-if="colorList.length > 0"
            class="m-auto sm:m-0 flex flex-wrap gap-3 mt-4 bg-slate-300 p-2 justify-center sm:w-fit">
            <div v-for="color in colorList" :key="color.id">
                <button @click="deleteColor(color.id)" type="button"
                    class="w-10 h-10 border-2 border-white hover:border-gray-800 rounded-full shrink-0"
                    :style="getBgColor(color.name)">
                </button>
            </div>
        </div>

        <div class="flex items-center">
            <input v-model="value" type="color" />
            <button @click="addColor(value)" id="burronNativeColor" type="button"
                class="inline-block rounded bg-blue-600 px-6 py-2.5 text-xs font-medium uppercase leading-tight text-white shadow-md transition duration-150 ease-in-out hover:bg-blue-700 hover:shadow-lg focus:bg-blue-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg">
                Add Color
            </button>
        </div>
    </div>
</template>


<script>
import { ColorService } from '../../services/colorService';
import { useToast } from 'vue-toast-notification';

const $toast = useToast();
const colorService = new ColorService();

export default {

    created() {
        this.fetchColors(this.$route.params.id)
    },

    data() {
        return {
            colorList: [],
            value: "#6590D5"
        }
    },

    methods: {

        fetchColors(id) {
            colorService.getColorByProductId(id).then(response => {
                this.colorList = response.data
            })
        },

        addColor(value) {
            const color = {
                productId: this.$route.params.id,
                name: value
            }

            colorService.add(color).then(response => {

                this.colorList.push(color)
                this.fetchColors(this.$route.params.id)
                $toast.success("Color is added successfully")

            }).catch(error => {
                const message = error.response.data.message
                $toast.error(message)
            })

        },

        deleteColor(id) {
            colorService.delete(id).then(response => {
                this.colorList = this.colorList.filter(color => color.id != id)
            })
        },

        

        getBgColor(color) {

            return `background-color: ${color}`
        }
    },


}
</script>