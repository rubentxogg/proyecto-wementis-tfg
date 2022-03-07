<template>
  <div class="pacientes">
      <p class="text-muted">Pacientes</p>
      
      <div class="d-flex justify-content-between">
        <browser-pacientes />

        <button type="button" class="btn btn-success d-flex justify-content-center btn-anadir align-self-end mb-1">
          <i class="bi bi-person-plus me-1 align-self-center"></i>
          <span class="align-self-center">Añadir</span>
        </button>
      </div>

      <hr>
      <table-pacientes :pacientes="pacientes"/>
  </div>
</template>

<script>
import TablePacientes from '@/components/pacientes/TablePacientes.vue';
import BrowserPacientes from '@/components/pacientes/BrowserPacientes.vue';
import axios from 'axios';

export default {
    name: "Pacientes",
    components: {
      TablePacientes,
      BrowserPacientes
    },
    data() {
      return {
        pacientes: []
      }
    },
    methods: {
      getPacientes(url) {
        axios
          .get(url)
          .then((response) => this.pacientes = response.data)
          .catch((err) => console.error(err));
      }
    },
    mounted() {
      this.getPacientes("wementis/v1/pacientes/");
    }
}
</script>

<style scoped>
.btn-anadir {
  height: 3rem;
}
</style>