<template>
    <div class="h-screen">
        <Navbar />
        <header class="bg-white shadow mx-auto max-w-7xl px-4 py-10 sm:px-6 lg:px-8" />
        <div class="mx-auto max-w-7xl py-6 sm:px-6 lg:px-8">
            <div class="mx-auto max-w-2xl px-4 lg:max-w-7xl lg:px-8">
                <TabGroup>
                    <AnnouncementTab />
                    <TabPanels>
                        <TabPanel>
                            <ActiveProductTabView />
                        </TabPanel>
                        <TabPanel>
                            <AwaitingProductTabView />
                        </TabPanel>
                        <TabPanel>
                            <PassiveProductTabView />
                        </TabPanel>
                    </TabPanels>
                </TabGroup>
            </div>
        </div>
    </div>
</template>

<script>
import { TabGroup, TabPanels, TabPanel } from '@headlessui/vue'
import Navbar from "../components/common/Navbar.vue";
import AnnouncementTab from "../components/announcement/AnnouncementTab.vue";
import ActiveProductTabView from "../components/announcement/ActiveProductTabView.vue";
import AwaitingProductTabView from '../components/announcement/AwaitingProductTabView.vue';
import PassiveProductTabView from '../components/announcement/PassiveProductTabView.vue';


export default {

    components: {
        TabGroup,
        TabPanels,
        TabPanel,
        Navbar,
        AnnouncementTab,
        ActiveProductTabView,
        AwaitingProductTabView,
        PassiveProductTabView
    },
}
</script>