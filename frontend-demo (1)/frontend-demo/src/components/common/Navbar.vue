<template>
    <div class="bg-white fixed top-0 w-full z-20">
        <!-- Mobile menu -->
        <TransitionRoot as="template" :show="open">
            <Dialog as="div" class="relative z-40 lg:hidden" @close="open = false">
                <TransitionChild as="template" enter="transition-opacity ease-linear duration-300"
                    enter-from="opacity-0" enter-to="opacity-100" leave="transition-opacity ease-linear duration-300"
                    leave-from="opacity-100" leave-to="opacity-0">
                    <div class="fixed inset-0 bg-black bg-opacity-25" />
                </TransitionChild>

                <div class="fixed inset-0 z-40 flex">
                    <TransitionChild as="template" enter="transition ease-in-out duration-300 transform"
                        enter-from="-translate-x-full" enter-to="translate-x-0"
                        leave="transition ease-in-out duration-300 transform" leave-from="translate-x-0"
                        leave-to="-translate-x-full">
                        <DialogPanel
                            class="relative flex w-full max-w-xs flex-col overflow-y-auto bg-white pb-12 shadow-xl">
                            <div class="flex px-4 pb-2 pt-5">
                                <button type="button"
                                    class="relative -m-2 inline-flex items-center justify-center rounded-md p-2 text-gray-400"
                                    @click="open = false">
                                    <span class="absolute -inset-0.5" />
                                    <span class="sr-only">Close menu</span>
                                    <XMarkIcon class="h-6 w-6" aria-hidden="true" />
                                </button>
                            </div>

                            <!-- Links -->
                            <TabGroup as="div" class="mt-2">
                                <div class="border-b border-gray-200">
                                    <TabList class="-mb-px flex space-x-8 px-4">
                                        <Tab as="template" v-for="category in getCategoryList" :key="category.name"
                                            v-slot="{ selected }">
                                            <button
                                                :class="[selected ? 'border-indigo-600 text-indigo-600' : 'border-transparent text-gray-900', 'flex-1 whitespace-nowrap border-b-2 px-1 py-4 text-base font-medium']">{{
                                                    category.name }}</button>
                                        </Tab>
                                    </TabList>
                                </div>
                                <TabPanels as="template">
                                    <div v-for="(category) in getCategoryList" :key="category.name">

                                        <TabPanel class="space-y-10 px-4 pb-8 pt-10 ">

                                            <div class="grid grid-cols-2 gap-x-4">
                                                <div v-for="item in featured" :key="item.name"
                                                    class="group relative text-sm">
                                                    <div
                                                        class="aspect-h-1 aspect-w-1 overflow-hidden rounded-lg bg-gray-100 group-hover:opacity-75">
                                                        <img :src="item.imageSrc" :alt="item.imageAlt"
                                                            class="object-cover object-center" />
                                                    </div>
                                                    <a :href="item.href" class="mt-6 block font-medium text-gray-900">
                                                        <span class="absolute inset-0 z-10" aria-hidden="true" />
                                                        {{ item.name }}
                                                    </a>
                                                    <p aria-hidden="true" class="mt-1">Shop now</p>
                                                </div>
                                            </div>
                                            <div>

                                                <div v-for="(lastCategory, index) in category.categories" :key="index">
                                                    <p :id="`${index}-${index}-heading-mobile`"
                                                        class="font-medium text-gray-900 pt-5">{{ lastCategory.name }}
                                                    </p>
                                                    <ul role="list"
                                                        :aria-labelledby="`${index}-${index}-heading-mobile`"
                                                        class="mt-3 flex flex-col space-y-2">
                                                        <li v-for="(subCategory, index) in lastCategory.subCategories"
                                                            :key="index" class="flow-root">
                                                            <a href="#" class="-m-2 block p-2 text-gray-500">{{
                                                                subCategory.name }}</a>
                                                        </li>
                                                    </ul>
                                                </div>

                                            </div>
                                        </TabPanel>
                                    </div>

                                </TabPanels>
                            </TabGroup>

                            <!-- <div class="space-y-6 border-t border-gray-200 px-4 py-6">
                                <div v-for="page in navigation.pages" :key="page.name" class="flow-root">
                                    <a :href="page.href" class="-m-2 block p-2 font-medium text-gray-900">{{ page.name
                                        }}</a>
                                </div>
                            </div> -->

                            <div v-if="getIsLogin" class="block sm:hidden space-y-6 border-t border-gray-200 px-4 py-6">
                                <div class="flow-root">
                                    <a href="#" class="-m-2 block p-2 font-medium text-gray-900">Your Profile</a>
                                    <a @click="removeActiveUser" href="#"
                                        class="-m-2 block p-2 font-medium text-gray-900">Sign out</a>

                                </div>
                            </div>

                            <div v-else class="space-y-6 border-t border-gray-200 px-4 py-6">
                                <div class="flow-root">
                                    <router-link :to="{ path: '/login' }"
                                        class="-m-2 block p-2 font-medium text-gray-900">Sign in</router-link>
                                </div>
                                <div class="flow-root">
                                    <router-link :to="{ path: '/register' }"
                                        class="-m-2 block p-2 font-medium text-gray-900">Create account</router-link>
                                </div>
                            </div>

                        </DialogPanel>
                    </TransitionChild>
                </div>
            </Dialog>
        </TransitionRoot>

        <header class="relative bg-white">
            <p
                class="flex h-10 items-center justify-center bg-lightgreen px-4 text-sm font-medium text-white sm:px-6 lg:px-8">
                Yeni ürünler geldi!
            </p>

            <nav aria-label="Top" class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
                <div class="border-b border-gray-200">
                    <div class="flex sm:h-16 items-center">
                        <button type="button" class="relative rounded-md bg-white p-2 text-gray-400 lg:hidden"
                            @click="open = true">
                            <span class="absolute -inset-0.5" />
                            <span class="sr-only">Open menu</span>
                            <Bars3Icon class="h-6 w-6" aria-hidden="true" />
                        </button>

                        <!-- Logo -->
                        <div class=" flex lg:ml-0">
                            <a href="#">
                                <span class="sr-only">Your Company</span>
                                <img class="h-16 sm:h-20 w-auto" src="../../assets/mainLogo1.png" alt="" />
                            </a>
                        </div>

                        <!-- Flyout menus -->
                        <PopoverGroup class="hidden lg:ml-8 lg:block lg:self-stretch">
                            <div class="flex h-full space-x-8">
                                <CategorySection :categories="getCategoryList" />
                            </div>
                        </PopoverGroup>


                        <!-- Search -->
                        <NavbarSearchField />

                        <div class="ml-auto flex items-center">
                            <Profile v-if="getIsLogin" class="hidden sm:block" />
                            <div v-else class="hidden lg:flex lg:flex-1 lg:items-center lg:justify-end lg:space-x-6">
                                <router-link :to="{ path: '/login' }"
                                    class="text-sm font-medium text-gray-700 hover:text-gray-800">Sign in</router-link>
                                <router-link :to="{ path: '/register' }"
                                    class="text-sm font-medium bg-lightgreen text-white hover:text-gray-50 px-2 py-3 rounded-ss-2xl rounded-se-sm rounded-es-sm rounded-ee-2xl ">
                                    Create
                                    account
                                </router-link>

                                <span class="h-6 w-px bg-gray-200" aria-hidden="true" />
                            </div>

                            <!-- Cart -->
                            <div v-if="getIsLogin"  class="ml-4 flow-root lg:ml-6">

                                <router-link v-if="getIsCompanyAccount" :to="{path:'/productadd'}" class="hidden sm:block relative items-center justify-start px-2 py-2 overflow-hidden font-medium transition-all bg-white rounded hover:bg-white group">
                                    <span
                                        class="w-48 h-48 rounded rotate-[-40deg] bg-lightgreen absolute bottom-0 left-0 -translate-x-full ease-out duration-500 transition-all translate-y-full mb-9 ml-9 group-hover:ml-0 group-hover:mb-32 group-hover:translate-x-0"></span>
                                    <span
                                        class="relative w-full text-left text-black transition-colors duration-300 ease-in-out group-hover:text-white">Add Product</span>
                                
                                </router-link>
                                
                                <a v-else href="#" class="group -m-2 flex items-center p-2">
                                    <ShoppingBagIcon
                                        class="h-6 w-6 flex-shrink-0 text-gray-400 group-hover:text-gray-500"
                                        aria-hidden="true" />
                                    <span
                                        class="ml-2 text-sm font-medium text-gray-700 group-hover:text-gray-800">0</span>
                                    <span class="sr-only">items in cart, view bag</span>
                                </a>

                                
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
        </header>
    </div>
</template>


<script>
import {
    Dialog, DialogPanel, Popover, PopoverButton, PopoverGroup, PopoverPanel, Tab, TabGroup, TabList,
    TabPanel, TabPanels, TransitionChild, TransitionRoot,
} from '@headlessui/vue'
import { Bars3Icon, MagnifyingGlassIcon, ShoppingBagIcon, XMarkIcon } from '@heroicons/vue/24/outline'
import CategorySection from "../../components/common/navbar/CategorySection.vue"

import { mapActions, mapState } from 'pinia';
import Profile from './navbar/Profile.vue';
import { useCategoryStore } from '../../stores/category';
import { useUserStore } from '../../stores/user';
import NavbarSearchField from './navbar/NavbarSearchField.vue';

const categoryStore = useCategoryStore();

export default {

    mounted() {

        categoryStore.getAllMenCategory();
        categoryStore.getAllWomenCategory();
        categoryStore.getAllUnisexCategory();

    },

    data() {
        return {
            open: false,
            featured: [
                {
                    name: 'New Arrivals',
                    href: '#',
                    imageSrc: 'https://tailwindui.com/img/ecommerce-images/mega-menu-category-01.jpg',
                    imageAlt: 'Models sitting back to back, wearing Basic Tee in black and bone.',
                },
                {
                    name: 'Basic Tees',
                    href: '#',
                    imageSrc: 'https://tailwindui.com/img/ecommerce-images/mega-menu-category-02.jpg',
                    imageAlt: 'Close up of Basic Tee fall bundle with off-white, ochre, olive, and black tees.',
                },
            ]
            ,

        }
    },

    methods: {

        ...mapActions(useUserStore, ["removeActiveUser"])

    },

    computed: {

        ...mapState(useCategoryStore, ["getCategoryList"]),
        ...mapState(useUserStore, ["getIsLogin", "getIsCompanyAccount"])

    },

    components: {
        Dialog, DialogPanel, Popover, PopoverButton, PopoverGroup, PopoverPanel, Tab, TabGroup, TabList, TabPanel,
        TabPanels, TransitionChild, TransitionRoot, Bars3Icon, MagnifyingGlassIcon, ShoppingBagIcon, XMarkIcon,
        CategorySection, Profile,NavbarSearchField
    }

}
</script>
