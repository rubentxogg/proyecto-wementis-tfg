<template>
  <div class="citas">
    <p class="text-muted fs-5 text-decoration-underline">Citas</p>
    <div class="d-flex justify-content-between">
      <button type="button" :class="buttonBrowserStyles" @click="openCloseBrowser">
        <i :class="browserIcon"></i> {{ buttonBrowserText }}
      </button>
      <browser-citas @buscarCitas="getCitasPorCampos" v-if="showBrowser"/>
      <modal-new-cita @updateTabla="getCitas('wementis/v1/citas/')"/>
    </div>

    <hr>
    <spinner v-if="isLoading"/>
    <table-citas v-else :citas="citas" @updateTabla="getCitas('wementis/v1/citas/')"/>
  </div>
</template>

<script>
import TableCitas from '@/components/citas/TableCitas.vue';
import ModalNewCita from '@/components/citas/ModalNewCita.vue';
import Spinner from '@/components/Spinner.vue';
import axios from 'axios';

export default {
  name: "Citas",
  components: {
    TableCitas,
    ModalNewCita,
    Spinner
  },
  data() {
    return {
      citas: [],
      showBrowser: false,
      isLoading: false
    }
  },
  methods: {
    getCitas(url) {
      this.isLoading = true;
      axios
        .get(url)
        .then((response) => this.citas = response.data)
        .catch((err) => console.error(err))
        .finally(() => this.isLoading = false);
    }
  },
  computed: {
      buttonBrowserText() {
        if(!this.showBrowser) return "Abrir buscador";
        return "Cerrar buscador"
      },
      buttonBrowserStyles() {
        if(!this.showBrowser) return "btn btn-primary";
        return "btn btn-outline-primary me-4"
      },
      browserIcon() {
        if(!this.showBrowser) return "bi bi-arrows-angle-expand me-1";
        return "bi bi-arrows-angle-contract me-1"
      }
    },
    mounted() {
      this.getCitas("wementis/v1/citas/");
    }
}
</script>

<style>

</style>