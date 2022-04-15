import { createRouter, createWebHistory } from 'vue-router'

import axios from "axios";

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/Home.vue'),
  },
  {
    path: '/:error',
    name: 'HomeLoginError',
    component: () => import('../views/Home.vue'),
  },
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: () => import('../views/Dashboard.vue'),
  },
  {
    path: '/pacientes',
    name: 'Pacientes',
    component: () => import('../views/Pacientes.vue'),
  },
  {
    path: '/psicologos',
    name: 'Psicologos',
    component: () => import('../views/Psicologos.vue'),
  },
  {
    path: '/tarifas',
    name: 'Tarifas',
    component: () => import('../views/Tarifas.vue'),
  },
  {
    path: '/citas',
    name: 'Citas',
    component: () => import('../views/Citas.vue'),
  },
  {
    path: '/informe',
    name: 'Informe',
    component: () => import('../views/Informe.vue'),
  }
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
