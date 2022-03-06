<template>
  <div class="pacientes">
      <h5 class="text-muted">Pacientes</h5>
      <table-pacientes :pacientes="pacientes"/>
  </div>
</template>

<script>
import TablePacientes from '@/components/TablePacientes.vue';
import axios from 'axios';

export default {
    name: "Pacientes",
    components: {
      TablePacientes
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

<style>

</style>