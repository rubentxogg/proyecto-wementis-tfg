<template>
  <div class="citas d-flex flex-column min-vh-100">
    <p class="text-muted fs-6">Citas</p>

    <div class="d-flex justify-content-between">
      <div class="accordion me-3" id="accordionCitas">
        <div class="accordion-item">

          <button class="accordion-button accordion-header d-flex justify-content-between" id="headingOne" :class="buttonBrowserStyles" @click="openCloseFullBrowser" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
           <span>{{ buttonBrowserText }}</span> <i :class="browserIcon"></i> 
          </button>

          <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionCitas">
             <div class="accordion-body">
               <full-browser-citas @buscarCitas="getCitasPorCampos"/>
             </div>
          </div>
        </div>
      </div>

      <modal-new-cita @updateTabla="getCitas('wementis/v1/citas/')"/>
    </div>

    <div class="d-flex mt-3">
      <browser-citas-por-fecha-y-id-estado v-if="!showFullBrowser" @buscarCitas="getCitasPorFechaYIdEstado"/>
    </div>

    <hr>
    <spinner v-if="isLoading"/>
    <table-citas v-else-if="citas.length > 0" :citas="citas" @updateTabla="getCitas('wementis/v1/citas/')"/>
    <h2 v-else-if="isSearchPorCampos" class="text-center mt-5 text-muted">No se han encontrado citas con tus criterios de búsqueda.</h2>
    <h3 v-else class="text-center mt-5">
      Actualmente no existen citas en la BBDD, <br><br>
      pulsa en el botón <span class="text-success">[<i class="bi bi-plus-circle me-1"></i>Añadir]</span> situado en la parte superior derecha de la página para añadir tu primer cita
    </h3>

    <footer-wementis />
  </div>
</template>

<script>
import TableCitas from '@/components/citas/TableCitas.vue';
import FullBrowserCitas from '@/components/citas/FullBrowserCitas.vue';
import ModalNewCita from '@/components/citas/ModalNewCita.vue';
import Spinner from '@/components/Spinner.vue';
import FooterWementis from '@/components/FooterWementis.vue';
import BrowserCitasPorFechaYIdEstado from '@/components/citas/BrowserCitasPorFechaYIdEstado.vue';
import axios from 'axios';

export default {
  name: "Citas",
  components: {
    TableCitas,
    FullBrowserCitas,
    ModalNewCita,
    Spinner,
    FooterWementis,
    BrowserCitasPorFechaYIdEstado
  },
  data() {
    return {
      citas: [],
      showFullBrowser: false,
      isLoading: false,
      isSearchPorCampos: false
    }
  },
  methods: {
    getCitas(url) {
      this.isSearchPorCampos = false;
      this.isLoading = true;
      axios
        .get(url)
        .then((response) => this.citas = response.data)
        .catch((err) => console.error(err))
        .finally(() => this.isLoading = false);
    },
    getCitasPorCampos(id, pacienteNombre, psicologoNombre, tarifaNombre, estado, fecha, hora, cantidadHoras) {
      const params = {
        id: id,
        nombrePaciente: pacienteNombre,
        nombrePsicologo: psicologoNombre,
        nombreTarifa: tarifaNombre,
        idEstado: estado,
        fecha: fecha,
        hora: hora,
        cantidadHoras: cantidadHoras
      };

      this.isSearchPorCampos = true;
      
      axios
        .get("wementis/v1/citas/", { params })
        .then((response) => this.citas = response.data)
        .catch((err) => console.error(err));
    },
    getCitasPorFechaYIdEstado(fecha, idEstado) {
      const params = {
        fecha: fecha,
        idEstado: idEstado
      }

      this.isSearchPorCampos = true;

      axios
        .get("wementis/v1/citas/", { params })
        .then((response) => this.citas = response.data)
        .catch((err) => console.error(err));
    },
    openCloseFullBrowser() {
      this.showFullBrowser = !this.showFullBrowser;
    }
  },
  computed: {
    buttonBrowserText() {
      if(!this.showFullBrowser) return "Abrir buscador";
      return "Cerrar buscador"
    },
    buttonBrowserStyles() {
      if(!this.showFullBrowser) return "bg-primary text-light p-1 ps-3";
      return "btn btn-outline-primary p-1 ps-3 me-4"
    },
    browserIcon() {
      if(!this.showFullBrowser) return "bi bi bi-arrows-expand ms-2 fs-5 me-2";
      return "bi bi bi-arrows-collapse fs-5"
    }
  },
  mounted() {
    this.getCitas("wementis/v1/citas/");
  }
}
</script>

<style>

</style>