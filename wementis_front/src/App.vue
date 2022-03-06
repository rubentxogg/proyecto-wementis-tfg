<template>
  <div class="app container-fluid">
    <div class="row">
      <side-nav-menu v-if="this.$route.name !== 'Home'" class="col-3" />
      <router-view class="col bg-standard" />
    </div>
  </div>
</template>

<script>
import SideNavMenu from "@/components/SideNavMenu.vue";

export default {
  name: "App",
  components: {
    SideNavMenu,
  },
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500&display=swap');

* {
  font-family: 'Ubuntu', sans-serif;
}

.bg-standard {
  background: rgb(255, 251, 251)
}
</style>
