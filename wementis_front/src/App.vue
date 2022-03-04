<template>
    <!-- v-if="this.$route.name !== 'Home'" to="/" -->
  <div class="app">
    <router-link v-if="this.$route.name !== 'Home'" to="/">Testeo</router-link>
    <router-view />
  </div>
</template>

<script>
export default {
  name: "App",
};
</script>
