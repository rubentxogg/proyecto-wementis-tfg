<template>
  <div class="psicologos">
    <p class="text-muted fs-4 text-decoration-underline">Psicólogos</p>

    <hr>
    <spinner v-if="isLoading"/>
    <table-psicologos v-else :psicologos="psicologos"/>
  </div>
</template>

<script>
import TablePsicologos from '@/components/psicologos/TablePsicologos.vue';
import Spinner from '@/components/Spinner.vue';
import axios from 'axios';

export default {
    name: "Psicologos",
    components: {
      TablePsicologos,
      Spinner
    },
    data() {
      return {
        psicologos: [],
        showBrowser: false,
        isLoading: false
      }
    },
    methods: {
      getPsicologos(url) {
        this.isLoading = true;
        axios
          .get(url)
          .then((response) => this.psicologos = response.data)
          .catch((err) => console.error(err))
          .finally(() => this.isLoading = false);
      }
    },
    mounted() {
      this.getPsicologos("wementis/v1/psicologos/");
    }
}
</script>

<style>

</style>