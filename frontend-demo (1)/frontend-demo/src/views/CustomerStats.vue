<template>
    <div class="bg-login h-screen">
        <Navbar />
        <header class="bg-white shadow mx-auto max-w-7xl px-4 py-10 sm:px-6 lg:px-8" />
        <div class="bg-white mx-auto max-w-7xl py-6 sm:px-6 lg:px-8">
            <div class="mx-auto max-w-2xl px-4 lg:max-w-3xl lg:px-8">
                <TabGroup>
                    <ProfileFollowerTabView />
                    <TabPanels>
                        <TabPanel>
                            <CustomerFollowerList />
                        </TabPanel>
                        <TabPanel>
                            <CustomerFollowingList />
                        </TabPanel>
                    </TabPanels>
                </TabGroup>
            </div>
        </div>
    </div>
</template>

<script>
import AnnouncementTab from "../components/announcement/AnnouncementTab.vue";
import Navbar from "../components/common/Navbar.vue"
import CustomerFollowerList from "../components/profileFollower/customerFollower/CustomerFollowerList.vue"
import CustomerFollowingList from "../components/profileFollower/customerFollower/CustomerFollowingList.vue";
import ProfileFollowerTabView from "../components/profileFollower/ProfileFollowerTab.vue"
import { TabGroup, TabPanels, TabPanel } from '@headlessui/vue'

export default {

    components: { Navbar,CustomerFollowerList,CustomerFollowingList,AnnouncementTab, TabGroup, TabPanel, TabPanels,ProfileFollowerTabView }
}
</script>