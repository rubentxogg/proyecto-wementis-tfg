import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import VueToast from 'vue-toast-notification';

import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';

import 'bootstrap-icons/font/bootstrap-icons.css';
import 'vue-toast-notification/dist/theme-sugar.css';


createApp(App).use(router).use(VueToast).mount('#app')
