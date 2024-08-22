
<template>
    <div class="mt-16 shadow-[0_2px_10px_-3px_rgba(6,81,237,0.3)] p-6">
        <h3 class="text-lg font-bold text-[#333]">Reviews(10)</h3>
        <div class="grid md:grid-cols-2 gap-12 mt-6">
            
            <ProductDetailRatingField />

            <ProductDetailCommentField />
        </div>
    </div>
</template>

<script>
import ProductDetailCommentField from './ProductDetailCommentField.vue';
import ProductDetailRatingField from './ProductDetailRatingField.vue';

export default {
    

    components:{ProductDetailRatingField,ProductDetailCommentField}
}
</script>