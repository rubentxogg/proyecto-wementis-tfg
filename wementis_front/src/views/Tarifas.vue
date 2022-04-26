<template>
  <div class="tarifas d-flex flex-column min-vh-100">
    <p class="text-muted fs-6">Tarifas</p>
    <div class="d-flex justify-content-between">
      <div class="accordion me-3" id="accordionTarifas">
        <div class="accordion-item">
          <button class="accordion-button accordion-header d-flex justify-content-between" id="headingOne" :class="buttonBrowserStyles" @click="openCloseBrowser" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
            <span>{{ buttonBrowserText }}</span> <i :class="browserIcon"></i> 
          </button>
          
          <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionTarifas">
            <div class="accordion-body">
              <browser-tarifas @buscarTarifas="getTarifasPorCampos"/>
            </div>
         </div>

        </div>
      </div>

      <modal-new-tarifa @updateTabla="getTarifas('wementis/v1/tarifas/')"/>
    </div>

    <hr>
    <spinner v-if="isLoading"/>
    <table-tarifas v-else-if="tarifas.length > 0" :tarifas="tarifas" @updateTabla="getTarifas('wementis/v1/tarifas/')"/>
    <h2 v-else-if="isSearchPorCampos" class="text-center mt-5 text-muted">No se han encontrado tarifas con tus criterios de búsqueda.</h2>
    <h3 v-else class="text-center mt-5 text-muted">
      Actualmente no existen tarifas en la BBDD, <br><br>
      pulsa en el botón <span class="text-success">[<i class="bi bi-plus-circle me-1"></i>Añadir]</span> situado en la parte superior derecha de la página para añadir tu primer tarifa
    </h3>

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
      isLoading: false,
      isSearchPorCampos: false
    }
  },
  methods: {
    getTarifas(url) {
      this.isSearchPorCampos = false;
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

      this.isSearchPorCampos = true;
      
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
      if(!this.showBrowser) return "bg-primary text-light p-1 ps-3";
      return "btn btn-outline-primary p-1 ps-3 me-4"
    },
    browserIcon() {
      if(!this.showBrowser) return "bi bi bi-arrows-expand ms-2 fs-5 me-2";
      return "bi bi bi-arrows-collapse fs-5"
    }
  },
  mounted() {
    this.getTarifas('wementis/v1/tarifas/');
  }

}
</script>

<style>

</style>