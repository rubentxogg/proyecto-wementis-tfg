<template>
  <div class="dashboard">
    <p class="text-muted fs-5 text-decoration-underline">Dashboard</p>
    <hr>
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
        <h6 class="mt-1">
          Ganancia total: {{ gananciaTotal }}<i class="bi bi-currency-euro"></i>
        </h6>
      </div>
    </div>

    <hr class="mt-4">

    <div class="d-flex justify-content-evenly mt-5">
      <h6 class="bg-warning p-4 text-light rounded-pill">
        <i class="bi bi-calendar-minus me-2 fs-5"></i>Citas activas: {{ citasActivas.length }}
      </h6>
      <h6 class="bg-success p-4 text-light rounded-pill">
        <i class="bi bi-calendar-check me-2 fs-5"></i>Citas completadas: {{ citasCompletadas.length }}
      </h6>
      <h6 class="bg-danger p-4 text-light rounded-pill">
        <i class="bi bi-calendar-x me-2 fs-5"></i>Citas canceladas: {{ citasCanceladas.length }}</h6>
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
      citasCompletadas: [],
      citasCanceladas: [],
      citasActivas: [],
      gananciaTotal: 0
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
        .then(() => this.calcularGananciaTotal())
        .catch((err) => console.error(err))
        .finally(() => (this.isLoading = false));
    },
    async getCitasPorEstado(idEstado) {
      const params = {
        id: "",
        nombrePaciente: "",
        nombrePsicologo: "",
        nombreTarifa: "",
        idEstado: idEstado,
        fecha: "",
        hora: "",
        cantidadHoras: ""
      };

      this.isLoading = true;
      
      const response = axios
        .get("wementis/v1/citas/", { params })
        .catch((err) => console.error(err))
        .finally(() => this.isLoading = false)
      return (await response).data;
    },
    calcularGananciaTotal() {
      let objetoCantidadTotal = this.ganancias.reduce((prev, curr) => ({cantidad: prev.cantidad + curr.cantidad}));

      this.gananciaTotal = objetoCantidadTotal.cantidad;
    }
  },
  async mounted() {
    this.getPacientes("wementis/v1/pacientes/");
    this.getPsicologos("wementis/v1/psicologos/");
    this.getCitas("wementis/v1/citas/");
    this.getGanancias("wementis/v1/ganancias/");
    this.citasCompletadas = await this.getCitasPorEstado(2);
    this.citasActivas = await this.getCitasPorEstado(1);
    this.citasCanceladas = await this.getCitasPorEstado(3);
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
