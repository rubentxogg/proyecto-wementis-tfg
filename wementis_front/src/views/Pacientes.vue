<template>
  <div class="pacientes">
      <p class="text-muted">Pacientes</p>
      
      <div class="d-flex justify-content-between">
        <browser-pacientes @buscarPacientes="getPacientesPorCampos"/>
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
      }
    },
    mounted() {
      this.getPacientes("wementis/v1/pacientes/");
    }
}
</script>

<style>
</style>