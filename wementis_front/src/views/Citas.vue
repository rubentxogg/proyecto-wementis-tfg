<template>
  <div class="citas d-flex flex-column min-vh-100">
    <p class="text-muted fs-6">Citas</p>
    <div class="d-flex justify-content-between">
      <button type="button" :class="buttonBrowserStyles" @click="openCloseFullBrowser">
        <i :class="browserIcon"></i> {{ buttonBrowserText }}
      </button>
      <full-browser-citas @buscarCitas="getCitasPorCampos" v-if="showFullBrowser"/>
      <modal-new-cita @updateTabla="getCitas('wementis/v1/citas/')"/>
    </div>

    <hr>
    <spinner v-if="isLoading"/>
    <table-citas v-else-if="citas.length > 0" :citas="citas" @updateTabla="getCitas('wementis/v1/citas/')"/>
    <h2 v-else class="text-center mt-5">
      Actualmente no existen citas en la BBDD, <br><br>
      pulsa en el botón <span class="text-success"> <i class="bi bi-plus-circle me-1"></i>Añadir</span> situado en la parte superior derecha de la página para añadir tu primer cita
    </h2>

    <footer-wementis />
  </div>
</template>

<script>
import TableCitas from '@/components/citas/TableCitas.vue';
import FullBrowserCitas from '@/components/citas/FullBrowserCitas.vue';
import ModalNewCita from '@/components/citas/ModalNewCita.vue';
import Spinner from '@/components/Spinner.vue';
import FooterWementis from '@/components/FooterWementis.vue';
import axios from 'axios';

export default {
  name: "Citas",
  components: {
    TableCitas,
    FullBrowserCitas,
    ModalNewCita,
    Spinner,
    FooterWementis
  },
  data() {
    return {
      citas: [],
      showFullBrowser: false,
      isLoading: false,
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
        if(!this.showFullBrowser) return "btn btn-primary";
        return "btn btn-outline-primary me-4"
      },
      browserIcon() {
        if(!this.showFullBrowser) return "bi bi-arrows-angle-expand me-1";
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