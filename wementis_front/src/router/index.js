import { createRouter, createWebHistory } from 'vue-router'

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

export default router
