<template>
  <div class="tarifas d-flex flex-column min-vh-100">
    <p class="text-muted fs-5 text-decoration-underline">Tarifas</p>

    <div class="d-flex justify-content-between">
      <button type="button" :class="buttonBrowserStyles" @click="openCloseBrowser">
        <i :class="browserIcon"></i> {{ buttonBrowserText }}
      </button>
      <browser-tarifas @buscarTarifas="getTarifasPorCampos" v-if="showBrowser"/>
      <modal-new-tarifa @updateTabla="getTarifas('wementis/v1/tarifas/')"/>
    </div>

    <hr>
    <spinner v-if="isLoading"/>
    <table-tarifas v-else-if="tarifas.length > 0" :tarifas="tarifas" @updateTabla="getTarifas('wementis/v1/tarifas/')"/>
    <h2 v-else class="text-center mt-5">
      Actualmente no existen tarifas en la BBDD, <br><br>
      pulsa en el botón <span class="text-success"> <i class="bi bi-plus-circle me-1"></i>Añadir</span> situado en la parte superior derecha de la página para añadir tu primer tarifa
    </h2>

    <footer-wementis />
  </div>
</template>

<script>
import TableTarifas from '@/components/tarifas/TableTarifas.vue';
import BrowserTarifas from '@/components/tarifas/BrowserTarifas.vue';
import ModalNewTarifa from '@/components/tarifas/ModalNewTarifa.vue';
import Spinner from '@/components/Spinner.vue';
import FooterWementis from '@/components/FooterWementis.vue';
import axios from 'axios';

export default {
  name: "Tarifas",
  components: {
    TableTarifas,
    BrowserTarifas,
    ModalNewTarifa,
    Spinner,
    FooterWementis
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
    getTarifasPorCampos(idTarifa, nombre, precioHora, fechaCreacion) {
      const params = {
        id: idTarifa,
        nombre: nombre,
        precioHora: precioHora,
        fechaCreacion: fechaCreacion
      }
      axios
        .get("wementis/v1/tarifas/", { params })
        .then((response) => this.tarifas = response.data)
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
    this.getTarifas('wementis/v1/tarifas/');
  }

}
</script>

<style>

</style>