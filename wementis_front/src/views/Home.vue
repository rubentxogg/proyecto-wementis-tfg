<template>
  <div>
    <div class="p-fix row row-cols-2">
      <jumbotron-wementis/>
      <form-login />
    </div>

    <icon-grid />
  </div>
</template>

<script>
import JumbotronWementis from '@/components/JumbotronWementis.vue';
import FormLogin from '@/components/FormLogin.vue';
import IconGrid from '@/components/IconGrid.vue';

export default {
  name: "Home",
  components: {
    JumbotronWementis,
    FormLogin,
    IconGrid
  },
};
</script>

<style scoped>
.p-fix {
  padding-left: 14rem;
  padding-right: 14rem;
}
</style>
