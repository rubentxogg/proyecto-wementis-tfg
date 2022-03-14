<template>
  <div class="dropdown-pacientes btn-group">
    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      <i class="bi bi-people me-1"></i> Pacientes
    </button>
    <ul class="dropdown-menu dropdown-menu-dark">
      <li v-for="paciente in pacientes" :key="paciente.idPaciente || paciente.id">
        <a class="dropdown-item" @click="seleccionarPaciente(paciente)">{{paciente.idPaciente || paciente.id}} - {{ paciente.nombre }}</a>
        <hr class="dropdown-divider" />
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "DrowpdownPacientes",
  events: ["seleccionPaciente"],
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
    },
    seleccionarPaciente(paciente) {
      this.$emit("seleccionPaciente", paciente);
    }
  },
  mounted() {
    this.getPacientes("wementis/v1/pacientes/");
  }
}
</script>

<style>

</style>