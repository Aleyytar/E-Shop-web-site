<template>
    <div class="h-screen bg-create">
        <Navbar/>
        <loading v-model:active="isLoading" :is-full-page="fullPage" />

        <div v-if="this.getAuthorizeForUpdate" class="sm:relative sm:top-1/2 sm:-translate-y-1/2 mt-24 sm:mt-7 ">

            <ProductUpdateForm :targetProduct="targetProduct" :subCategories="subCategories"
                @getManSubCategory="getMenSubCategoryList" @getWomenSubCategory="getWomenSubCategoryList"
                @getUnisexSubCategory="getUnisexSubCategoryList" />
        </div>

        <div v-else>
            <p>NOT REQ</p>
        </div>
    </div>
</template>

<script>
import PhotoUploadDialog from "../components/announcement/PhotoUploadDialog.vue";
import { mapState, mapActions } from "pinia";
import Navbar from "../components/common/Navbar.vue"
import { useUserStore } from "../stores/user";
import { useGlobalProductStore } from "../stores/product";
import { useSubCategoryStore } from "../stores/category/subCategory";
import { NormalProductService } from "../services/normalProductService";
import Loading from 'vue-loading-overlay';
import ProductUpdateForm from "../components/productupdate/ProductUpdateForm.vue"

const normalProductService = new NormalProductService();
const subCategoryStore = useSubCategoryStore();

export default {

    data() {
        return {
            targetProduct: null,
            isLoading: false,
            fullPage: true,
            subCategories: [],
        }
    },

    created() {

        normalProductService.getProductById(this.$route.params.id).then(response => {

            if (this.getCompanyAccountId != response.companyAccountId) {
                this.setAuthorizeForUpdate(false)

            } else {
                this.setAuthorizeForUpdate(true)
                this.isLoading = true;

                this.targetProduct = {
                    ...response,
                }
                delete this.targetProduct.productLikes
                delete this.targetProduct.productDislikes
                delete this.targetProduct.comments
                delete this.targetProduct.username
                delete this.targetProduct.genderName

                subCategoryStore.getAllMenSubCategories()
                subCategoryStore.getAllWomenSubCategories()
                subCategoryStore.getAllUnisexSubCategories()

                setTimeout(() => {
                    this.isLoading = false
                    switch (this.targetProduct.productGenderId) {
                        case 1:
                            this.subCategories = this.getMenSubCategory;
                            break;
                        case 2:
                            this.subCategories = this.getWomenSubCategory;
                            break;
                        case 3:
                            this.subCategories = this.getUnisexSubCategory;
                            break;
                        default:
                            break;
                    }
                }, 3000)
            }
        })
    },

    methods: {

        getMenSubCategoryList() {
            this.subCategories = this.getMenSubCategory;
            this.targetProduct.productSubCategoryId = null;
        },

        getWomenSubCategoryList() {
            this.subCategories = this.getWomenSubCategory;
            this.targetProduct.productSubCategoryId = null;
        },

        getUnisexSubCategoryList() {
            this.subCategories = this.getUnisexSubCategory;
            this.targetProduct.productSubCategoryId = null;
        },

        ...mapActions(useGlobalProductStore, ["setAuthorizeForUpdate"])
    },
    computed: {

        ...mapState(useUserStore, ["getCompanyAccountId"]),
        ...mapState(useGlobalProductStore, ["getAuthorizeForUpdate"]),
        ...mapState(useSubCategoryStore, ["getMenSubCategory", "getWomenSubCategory", "getUnisexSubCategory"]),

    },
    components: { Navbar, Loading, ProductUpdateForm, PhotoUploadDialog }
}
</script>