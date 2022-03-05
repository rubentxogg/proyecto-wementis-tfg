import { createRouter, createWebHistory } from 'vue-router'

import axios from "axios";

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/Home.vue'),
  },
  {
    path: '/testeo',
    name: 'Testeo',
    component: () => import('../views/Testeo.vue'),
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

router.afterEach(async () => {
  let estado = "";

  try {
    await axios.get("wementis/v1/estados/1").then((response) => (estado = response.data));
    if(typeof estado !== 'object' && router.currentRoute.value.path !== "/") throw Error;
  } catch(err) {
    router.push("/");
  }
})

export default router
