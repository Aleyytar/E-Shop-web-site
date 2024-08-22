<template>
    <TabList>
        <div class="border-b  border-gray-200 dark:border-gray-700">
            <ul class="flex justify-center  sm:justify-normal flex-wrap -mb-px text-sm font-medium text-center text-gray-500 dark:text-gray-400">
                <Tab v-for="(tab,index) in tabs" class="outline-none" v-slot="{ selected }">
                    <li class="me-2 " :key="index" >
                        <a
                            class="inline-flex items-center justify-center p-4 border-b-2 rounded-t-lg hover:text-gray-600  duration-300 transition-colors  dark:hover:text-gray-300 group" :class="[selected ? 'border-b-lightgreen' : '']">
                            <div class="h-3 w-3 rounded-full mr-3" :class="tab.status" />{{tab.name}}
                        </a>
                    </li>
                </Tab>
            </ul>
        </div>
    </TabList>
</template>


<script>

import {TabList, Tab} from '@headlessui/vue'

export default {

    data() {
        return {
            tabs:[
             {
                name:"Active Products",
                status:"bg-lightgreen"
             },
             {
                name:"Awaiting Products",
                status:"bg-yellow-500"
             },
             {
                name:"Passive Products",
                status:"bg-red-500"
             }
            ]
        }
    },



    components:{TabList, Tab}
}
</script>