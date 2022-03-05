<template>
  <div class="app">
    <side-nav-menu v-if="this.$route.name !== 'Home'"/>
    <router-view />
  </div>
</template>

<script>
import SideNavMenu from '@/components/SideNavMenu.vue';

export default {
  name: "App",
  components: {
    SideNavMenu
  }
};
</script>
