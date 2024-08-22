import { createRouter, createWebHashHistory } from "vue-router";
import routes from "./routes";
import { useUserStore } from "../stores/user/index";
import { setActivePinia } from "pinia";
import { useGlobalProductStore } from "../stores/product";

const router = createRouter({
  routes,
  history: createWebHashHistory(),
});

const notRequiredLoginRoutes = ["HomePage","RegisterPage", "LoginPage","ProductDetailPage","CompanyDetailPage","CompanyStatsPage","CustomerDetailPage","CustomerStatsPage"];
const fundamentalRoutes = ["RegisterPage", "LoginPage"];
const onlyForCompanyRoutes= ["ProductAddPage","MyProductPage","ProductUpdatePage","CompanyProfileUpdatePage"]
const onlyForCustomerRoutes = ["CustomerProfileUpdatePage"]

router.beforeEach((to, from, next) => {
    
    setActivePinia(useUserStore());

    const isLogin = useUserStore().getIsLogin;
    const isCompanyAccount = useUserStore().getIsCompanyAccount;

    if(fundamentalRoutes.indexOf(to.name) > -1 && isLogin) next(false);

    if(onlyForCompanyRoutes.indexOf(to.name) > -1 && isCompanyAccount) next(true)
    
    if(onlyForCustomerRoutes.indexOf(to.name) > -1 && isLogin && !isCompanyAccount) next(true)
  
    if(notRequiredLoginRoutes.indexOf(to.name) > -1 ) next()
  
});

export default router;
