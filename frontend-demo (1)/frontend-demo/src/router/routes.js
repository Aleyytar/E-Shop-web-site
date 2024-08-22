
const routes = [

    {
        path: "/",
        name:"HomePage",
        component:() => import("/src/views/Home.vue")
    },
    {
        path: "/login",
        name:"LoginPage",
        component:() => import("/src/views/Login.vue")
    },
    {
        path: "/register",
        name:"RegisterPage",
        component:() => import("/src/views/Register.vue")
    },
    {
        path: "/productadd",
        name:"ProductAddPage",
        component:() => import("/src/views/ProductAdd.vue")
    },
    {
        path: "/myproducts",
        name:"MyProductPage",
        component:() => import("/src/views/Announcement.vue")
    },
    {
        path: "/updateproduct/:id",
        name:"ProductUpdatePage",
        component:() => import("/src/views/ProductUpdate.vue"),
    },
    {
        path: "/product/:id",
        name:"ProductDetailPage",
        component:() => import("/src/views/ProductDetail.vue"),
    },
    {
        path: "/company/:id",
        name:"CompanyDetailPage",
        component:() => import("/src/views/CompanyDetail.vue"),
    },
    {
        path: "/company/:id/info",
        name:"CompanyStatsPage",
        component:() => import("/src/views/CompanyStats.vue"),
    },
    {
        path: "/company/:id/settings",
        name:"CompanyProfileUpdatePage",
        component:() => import("/src/views/CompanyProfileUpdate.vue"),
    },
    {
        path: "/customer/:id",
        name:"CustomerDetailPage",
        component:() => import("/src/views/CustomerDetail.vue"),
    },
    {
        path: "/customer/:id/info",
        name:"CustomerStatsPage",
        component:() => import("/src/views/CustomerStats.vue"),
    },
    {
        path: "/customer/:id/settings",
        name:"CustomerProfileUpdatePage",
        component:() => import("/src/views/CustomerProfileUpdate.vue"),
    },
    
]

export default routes;