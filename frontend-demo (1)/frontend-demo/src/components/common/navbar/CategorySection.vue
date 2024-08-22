<template>
    <Popover v-for="(category, index) in categories" :key="index" class="flex" v-slot="{ open }">
        <div class="relative flex">
            <PopoverButton
                :class="[open ? 'border-green-600 text-green-600 outline-none' : 'outline-none border-transparent text-gray-700 hover:text-gray-800', 'relative z-10 -mb-px flex items-center border-b-2 pt-px text-sm font-medium transition-colors duration-200 ease-out']">
                {{ category.name }}</PopoverButton>
        </div>

        <transition enter-active-class="transition ease-out duration-200" enter-from-class="opacity-0"
            enter-to-class="opacity-100" leave-active-class="transition ease-in duration-150"
            leave-from-class="opacity-100" leave-to-class="opacity-0">
            <PopoverPanel class="absolute inset-x-0 z-40 top-full text-sm text-gray-500">
                <div class="absolute inset-0 top-1/2  bg-white shadow" aria-hidden="true" />

                <div class="relative bg-white">
                    <div class="mx-auto max-w-7xl px-8">
                        <div class="grid grid-cols-2 gap-x-8 gap-y-10 py-16">
                            <div class="col-start-2 grid grid-cols-2 gap-x-8">
                                <div v-for="photo in category.categories" :key="photo.name"
                                    class="group relative text-base sm:text-sm">
                                    <div
                                        class="aspect-h-1 aspect-w-1 overflow-hidden rounded-lg bg-gray-100 group-hover:opacity-75">
                                        <img :src="photo.imageSrc" :alt="photo.imageAlt"
                                            class="object-cover object-center" />
                                    </div>
                                    <a :href="photo.href" class="mt-6 block font-medium text-gray-900">
                                        <span class="absolute inset-0 z-10" aria-hidden="true" />
                                        {{ photo.name }}
                                    </a>
                                    <p aria-hidden="true" class="mt-1">Shop now</p>
                                </div>
                            </div>
                            <div class="row-start-1 grid grid-cols-3 gap-x-8 gap-y-10 text-sm">
                                <div v-for="category in category.categories" :key="category.name">
                                    <p :id="`${category.name}-heading`" class="font-medium text-gray-900">{{
                                        category.name
                                        }}
                                    </p>
                                    <ul role="list" :aria-labelledby="`${category.name}-heading`"
                                        class="mt-6 space-y-6 sm:mt-4 sm:space-y-4">
                                        <li v-for="item in category.subCategories" :key="item.name" class="flex">
                                            <a href="#" class="hover:text-gray-800">{{ item.name
                                                }}</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </PopoverPanel>
        </transition>
    </Popover>
</template>

<script>
import {PopoverButton, PopoverPanel,Popover} from '@headlessui/vue'


export default {

    data() {
        return {
            open: true,
        }
    },
    props: ["categories", "index"],
    components: {PopoverButton, PopoverPanel,Popover}

}
</script>