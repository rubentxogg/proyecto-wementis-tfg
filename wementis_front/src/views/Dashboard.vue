<template>
  <div class="dashboard">
    <p class="text-muted fs-5 text-decoration-underline">Dashboard</p>

    <div class="d-flex justify-content-evenly mt-4">
      <div class="d-flex align-items-center">
        <span class="bg-primary rounded-circle me-1 d-flex justify-content-center align-items-center text-light">
          <i class="bi bi-calendar-week fs-5"></i>
        </span>
        <h6 class="mt-1">Citas: {{ citas.length }}</h6>
      </div>

      <div class="d-flex align-items-center">
        <span class="bg-indigo rounded-circle me-1 d-flex justify-content-center align-items-center text-light">
          <i class="bi bi-people fs-5"></i>
        </span>
        <h6 class="mt-1">Pacientes: {{ pacientes.length }}</h6>
      </div>

      <div class="d-flex align-items-center">
        <span class="bg-pink rounded-circle me-1 d-flex justify-content-center align-items-center text-light">
          <i class="bi bi-bandaid fs-5"></i>
        </span>
        <h6 class="mt-1">Psicólogos: {{ psicologos.length }}</h6>
      </div>

      <div class="d-flex align-items-center">
        <span class="bg-success rounded-circle me-1 d-flex justify-content-center align-items-center text-light">
          <i class="bi bi-piggy-bank fs-4"></i>
        </span>
        <h6 class="mt-1">Ganancias totales: {{ ganancias.length }}</h6>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Dashboard",
  data() {
    return {
      pacientes: [],
      psicologos: [],
      citas: [],
      ganancias: [],
    };
  },
  methods: {
    getPacientes(url) {
      this.isLoading = true;
      axios
        .get(url)
        .then((response) => (this.pacientes = response.data))
        .catch((err) => console.error(err))
        .finally(() => (this.isLoading = false));
    },
    getPsicologos(url) {
      this.isLoading = true;
      axios
        .get(url)
        .then((response) => (this.psicologos = response.data))
        .catch((err) => console.error(err))
        .finally(() => (this.isLoading = false));
    },
    getCitas(url) {
      this.isLoading = true;
      axios
        .get(url)
        .then((response) => (this.citas = response.data))
        .catch((err) => console.error(err))
        .finally(() => (this.isLoading = false));
    },
    getGanancias(url) {
      this.isLoading = true;
      axios
        .get(url)
        .then((response) => (this.ganancias = response.data))
        .catch((err) => console.error(err))
        .finally(() => (this.isLoading = false));
    },
  },
  mounted() {
    this.getPacientes("wementis/v1/pacientes/");
    this.getPsicologos("wementis/v1/psicologos/");
    this.getCitas("wementis/v1/citas/");
    this.getGanancias("wementis/v1/ganancias/");
  },
};
</script>

<style scoped>
span {
  width: 2.5em;
  height: 2.5em;
}

.bg-pink {
  background-color: #d63384;
}

.bg-indigo {
  background-color: #6610f2;
}
</style>
