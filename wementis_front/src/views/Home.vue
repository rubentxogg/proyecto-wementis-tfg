<template>
  <div>
    <div class="row row-cols-2">
      <h1>WeMentis</h1>
      <form-login />
    </div>

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
