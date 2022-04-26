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
  methods: {
    checkIsLoginError() {
      if(this.$route.query.error) return this.errorAlert();
    },
    errorAlert() {
      this.$toast.open({
      message: "Email o contraseña incorrectos",
      type: "error",
      duration: 5000,
      dismissible: true,
      position: "top"
      });
    },
  },
  mounted() {
    this.checkIsLoginError();
  }
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
