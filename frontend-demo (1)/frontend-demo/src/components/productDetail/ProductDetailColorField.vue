<template>
    <div v-if="this.productColors.length > 0" class="mt-10">
        <h3 class="text-lg font-bold text-gray-800">Choose a Color</h3>
        <div class="flex flex-wrap gap-3 mt-4">
            <button v-for="color in this.productColors" :key="color.id" type="button"
                class="w-10 h-10 border-2 border-white hover:border-gray-800 rounded-full shrink-0"
                :style="getBgColor(color.colorName)"></button>

        </div>
    </div>
</template>


<script>
export default {


    methods: {
        getBgColor(name) {
            return `background-color: ${name}`
        }
    },

    props: ["productColors"]

}
</script>