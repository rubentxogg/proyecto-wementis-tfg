<template>
  <div>
    <h1>This is Home</h1>
    <form-login />
    <icon-grid />
  </div>
</template>

<script>
import FormLogin from "@/components/FormLogin.vue";
import IconGrid from '@/components/IconGrid.vue';

export default {
  name: "Home",
  components: {
    FormLogin,
    IconGrid
  },
};
</script>

<style></style>
