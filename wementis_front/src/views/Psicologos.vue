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
import BrowserPsicologos from '@/components/psicologos/BrowserPsicologos.vue';
import ModalNewPsicologo from '@/components/psicologos/ModalNewPsicologo.vue';
import Spinner from '@/components/Spinner.vue';
import axios from 'axios';

export default {
    name: "Psicologos",
    components: {
      TablePsicologos,
      BrowserPsicologos,
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
      },
      getPsicologosPorCampos(idPsicologo, nombre, apellidos, telefono, email, fechaCreacion) {
        const params = {
          id: idPsicologo,
          nombre: nombre,
          apellidos: apellidos,
          telefono: telefono,
          email: email,
          fechaCreacion: fechaCreacion
        }

        axios
          .get("wementis/v1/psicologos/", { params })
          .then((response) => this.psicologos = response.data)
          .catch((err) => console.error(err));
      },
      openCloseBrowser() {
        this.showBrowser = !this.showBrowser;
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
      this.getPsicologos("wementis/v1/psicologos/");
    }
}
</script>

<style>

</style>