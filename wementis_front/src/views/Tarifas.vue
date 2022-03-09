<template>
  <div class="tarifas">
    <p class="text-muted fs-4 text-decoration-underline">Tarifas</p>

    <hr>
    <spinner v-if="isLoading"/>
    <table-tarifas v-else :tarifas="tarifas" @updateTabla="getTarifas('wementis/v1/tarifas/')"/>
  </div>
</template>

<script>
import TableTarifas from '@/components/tarifas/TableTarifas.vue';
import Spinner from '@/components/Spinner.vue';
import axios from 'axios';

export default {
  name: "Tarifas",
  components: {
    TableTarifas,
    Spinner
  },
  data() {
    return {
      tarifas: [],
      showBrowser: false,
      isLoading: false
    }
  },
  methods: {
    getTarifas(url) {
      this.isLoading = true;
      axios
        .get(url)
        .then((response) => this.tarifas = response.data)
        .catch((err) => console.error(err))
        .finally(() => this.isLoading = false);
    },
  },
  mounted() {
    this.getTarifas('wementis/v1/tarifas/');
  }

}
</script>

<style>

</style>