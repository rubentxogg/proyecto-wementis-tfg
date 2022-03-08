<template>
  <div class="pacientes">
      <p class="text-muted">Pacientes</p>
      
      <div class="d-flex justify-content-between">
        <button type="button" :class="buttonBrowserStyles" @click="openCloseBrowser">
          <i :class="browserIcon"></i> {{ buttonBrowserText }}
        </button>
        <browser-pacientes @buscarPacientes="getPacientesPorCampos" v-if="showBrowser"/>
        <modal-new-paciente @updateTabla="getPacientes('wementis/v1/pacientes/')"/>
      </div>

      <hr>
      <table-pacientes :pacientes="pacientes" @updateTabla="getPacientes('wementis/v1/pacientes/')"/>
  </div>
</template>

<script>
import TablePacientes from '@/components/pacientes/TablePacientes.vue';
import BrowserPacientes from '@/components/pacientes/BrowserPacientes.vue';
import ModalNewPaciente from '@/components/pacientes/ModalNewPaciente.vue';
import axios from 'axios';

export default {
    name: "Pacientes",
    components: {
      TablePacientes,
      BrowserPacientes,
      ModalNewPaciente
    },
    data() {
      return {
        pacientes: [],
        showBrowser: false
      }
    },
    methods: {
      getPacientes(url) {
        axios
          .get(url)
          .then((response) => this.pacientes = response.data)
          .catch((err) => console.error(err));
      },
      getPacientesPorCampos(idPaciente, nombre, apellidos, telefono, email, fechaNacimiento, genero, fechaCreacion) {
        const params = {
          id: idPaciente,
          nombre: nombre,
          apellidos: apellidos,
          telefono: telefono,
          email: email,
          fechaNacimiento: fechaNacimiento,
          genero: genero,
          fechaCreacion: fechaCreacion
        }

        axios
          .get("wementis/v1/pacientes/", { params })
          .then((response) => this.pacientes = response.data)
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
      this.getPacientes("wementis/v1/pacientes/");
    }
}
</script>

<style>
</style>