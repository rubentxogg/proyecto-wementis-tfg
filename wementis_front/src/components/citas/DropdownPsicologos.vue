<template>
  <div class="dropdown-psicologos btn-group">
    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
       <i class="bi bi-bandaid me-1"></i> Psicólogos
    </button>
    <ul class="dropdown-menu dropdown-menu-dark">
      <li v-for="psicologo in psicologos" :key="psicologo.idPsicologo || psicologo.id">
        <a class="dropdown-item" @click="seleccionarPsicologo(psicologo)">{{psicologo.idPsicologo || psicologo.id}} - {{ psicologo.nombre }}</a>
        <hr class="dropdown-divider" />
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "DrowpdownPsicologos",
  events: ["seleccionPsicologo"],
  data() {
    return {
      psicologos: []
    }
  },
  methods: {
    getPsicologos(url) {
      axios
        .get(url)
        .then((response) => this.psicologos = response.data)
        .catch((err) => console.error(err));
    },
    seleccionarPsicologo(psicologo) {
      this.$emit("seleccionPsicologo", psicologo);
    }
  },
  mounted() {
    this.getPsicologos("wementis/v1/psicologos/");
  }
}
</script>

<style>

</style>