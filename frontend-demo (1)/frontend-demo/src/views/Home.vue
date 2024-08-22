<template>
  <div class="min-h-full flex flex-col h-screen">

    <Navbar/>
    <header class="bg-white shadow mx-auto max-w-7xl px-4 py-9 sm:px-6 lg:px-8" />
    <main class="mb-auto">
      <div class="mx-auto max-w-7xl py-6 sm:px-6 lg:px-8">

        <ProductList />

      </div>
    </main>
    <Footer/>
    
  </div>
</template>

<script>
import ProductList from "../components/ProductList.vue";
import Navbar from "../components/common/Navbar.vue"
import Footer from "../components/common/Footer.vue"


export default{
  

  components: {Navbar,ProductList,Footer}

}

</script>