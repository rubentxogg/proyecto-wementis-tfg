<template>
  <div class="psicologos d-flex flex-column min-vh-100">
    <p class="text-muted fs-6">Psicólogos</p>

    <div class="d-flex justify-content-between">
      <button type="button" :class="buttonBrowserStyles" @click="openCloseBrowser">
        <i :class="browserIcon"></i> {{ buttonBrowserText }}
      </button>
      <browser-psicologos @buscarPsicologos="getPsicologosPorCampos" v-if="showBrowser"/>
      <modal-new-psicologo @updateTabla="getPsicologos('wementis/v1/psicologos/')"/>
    </div>

    <hr>
    <spinner v-if="isLoading"/>
    <table-psicologos v-else-if="psicologos.length > 0" :psicologos="psicologos" @updateTabla="getPsicologos('wementis/v1/psicologos/')"/>
    <h2 v-else class="text-center mt-5">
      Actualmente no existen psicólogos en la BBDD, <br><br>
      pulsa en el botón <span class="text-success"> <i class="bi bi-person-plus me-1"></i>Añadir</span> situado en la parte superior derecha de la página para añadir tu primer psicólogo
    </h2>

    <footer-wementis />
  </div>
</template>

<script>
import TablePsicologos from '@/components/psicologos/TablePsicologos.vue';
import BrowserPsicologos from '@/components/psicologos/BrowserPsicologos.vue';
import ModalNewPsicologo from '@/components/psicologos/ModalNewPsicologo.vue';
import Spinner from '@/components/Spinner.vue';
import FooterWementis from '@/components/FooterWementis.vue';
import axios from 'axios';

export default {
  name: "Psicologos",
  components: {
    TablePsicologos,
    BrowserPsicologos,
    ModalNewPsicologo,
    FooterWementis,
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