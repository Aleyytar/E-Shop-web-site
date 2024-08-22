import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router'
import { createPinia } from 'pinia';
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'
import ToastPlugin from 'vue-toast-notification';
import 'vue-toast-notification/dist/theme-bootstrap.css';
import 'vue-loading-overlay/dist/css/index.css';
import { useToast } from 'vue-toast-notification';

const toast = useToast();
const pinia = createPinia()

pinia.use(piniaPluginPersistedstate)

const app = createApp(App)
app.use(pinia)

app.use(router)

app.use(ToastPlugin)

app.config.globalProperties.$toast = toast
app.mount('#app')
