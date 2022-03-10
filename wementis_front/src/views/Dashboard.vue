<template>
  <div class="dashboard">
    <p class="text-muted fs-5 text-decoration-underline">Dashboard</p>
    <hr>
    <header-dashboard :citas="citas" :pacientes="pacientes" :psicologos="psicologos" :gananciaTotal="gananciaTotal"/>
    <hr class="mt-4">
    
    <section-citas-estados :citasActivas="citasActivas" :citasCompletadas="citasCompletadas" :citasCanceladas="citasCanceladas"/>
  </div>
</template>

<script>
import HeaderDashboard from '@/components/dashboard/HeaderDashboard.vue';
import SectionCitasEstados from '@/components/dashboard/SectionCitasEstados.vue';
import axios from "axios";

export default {
  name: "Dashboard",
  components: {
    HeaderDashboard,
    SectionCitasEstados
  },
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

</style>
