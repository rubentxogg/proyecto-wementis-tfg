<template>
  <div>
    <header-home class="mb-fix"/>

    <div class="p-fix row row-cols-2 mb-4">
      <jumbotron-wementis/>
      <form-login />
    </div>

    <icon-grid />
  </div>
</template>

<script>
import HeaderHome from '@/components/HeaderHome.vue';
import JumbotronWementis from '@/components/JumbotronWementis.vue';
import FormLogin from '@/components/FormLogin.vue';
import IconGrid from '@/components/IconGrid.vue';

export default {
  name: "Home",
  components: {
    HeaderHome,
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

.mb-fix {
  margin-bottom: 6rem !important;
}
</style>
