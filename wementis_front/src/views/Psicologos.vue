<template>
  <div class="psicologos">
    <p class="text-muted fs-4 text-decoration-underline">Psicólogos</p>

    <div class="d-flex justify-content-between">
      <button type="button" :class="buttonBrowserStyles" @click="openCloseBrowser">
        <i :class="browserIcon"></i> {{ buttonBrowserText }}
      </button>
      <browser-psicologos @buscarPsicologos="getPsicologosPorCampos" v-if="showBrowser"/>
      <modal-new-psicologo @updateTabla="getPsicologos('wementis/v1/psicologos/')"/>
    </div>

    <hr>
    <spinner v-if="isLoading"/>
    <table-psicologos v-else :psicologos="psicologos" @updateTabla="getPsicologos('wementis/v1/psicologos/')"/>
  </div>
</template>

<script>
import TablePsicologos from '@/components/psicologos/TablePsicologos.vue';
import ModalNewPsicologo from '@/components/psicologos/ModalNewPsicologo.vue';
import Spinner from '@/components/Spinner.vue';
import axios from 'axios';

export default {
    name: "Psicologos",
    components: {
      TablePsicologos,
      ModalNewPsicologo,
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