<template>
  <div class="psicologos d-flex flex-column min-vh-100">
    <p class="text-muted fs-6">Psicólogos</p>
    <div class="d-flex justify-content-between">
      <div class="accordion me-3" id="accordionPsicologos">
        <div class="accordion-item">

         <button class="accordion-button accordion-header d-flex justify-content-between" id="headingOne" :class="buttonBrowserStyles" @click="openCloseBrowser" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
           <span>{{ buttonBrowserText }}</span> <i :class="browserIcon"></i> 
         </button>

         <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionPsicologos">
            <div class="accordion-body">
              <browser-psicologos @buscarPsicologos="getPsicologosPorCampos"/>
            </div>
         </div>

        </div>
      </div>

      <modal-new-psicologo @updateTabla="getPsicologos('wementis/v1/psicologos/')"/>
    </div>

    <hr>
    <spinner v-if="isLoading"/>
    <table-psicologos v-else-if="psicologos.length > 0" :psicologos="psicologos" @updateTabla="getPsicologos('wementis/v1/psicologos/')"/>
    <h2 v-else-if="isSearchPorCampos" class="text-center mt-5 text-muted">No se han encontrado psicólogos con tus criterios de búsqueda.</h2>
    <h3 v-else class="text-center mt-5">
      Actualmente no existen psicólogos en la BBDD, <br><br>
      pulsa en el botón <span class="text-success">[<i class="bi bi-person-plus me-1"></i>Añadir]</span> situado en la parte superior derecha de la página para añadir tu primer psicólogo
    </h3>

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
      isLoading: false,
      isSearchPorCampos: false
    }
  },
  methods: {
    getPsicologos(url) {
      this.isSearchPorCampos = false;
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

      this.isSearchPorCampos = true;
      
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
      if(!this.showBrowser) return "bg-primary text-light p-1 ps-3";
      return "btn btn-outline-primary p-1 ps-3 me-4"
    },
    browserIcon() {
      if(!this.showBrowser) return "bi bi bi-arrows-expand ms-2 fs-5 me-2";
      return "bi bi bi-arrows-collapse fs-5"
    }
  },
  mounted() {
    this.getPsicologos("wementis/v1/psicologos/");
  }
}
</script>

<style>

</style>