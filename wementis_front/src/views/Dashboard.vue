<template>
  <div class="dashboard">
    <p class="text-muted fs-5 text-decoration-underline">Dashboard</p>
    <hr>
    <spinner v-if="isHeaderLoading"/>
    <header-dashboard  v-else :citas="citas" :pacientes="pacientes" :psicologos="psicologos" :gananciaTotal="gananciaTotal"/>
    <hr class="mt-4">

    <spinner v-if="isSectionLoading"/>
    <section-citas-estados v-else :citasActivas="citasActivas" :citasCompletadas="citasCompletadas" :citasCanceladas="citasCanceladas"/>

    <div class="jumbo-container container d-flex justify-content-between">
      <jumbotron-pacientes class="w-75 me-5"  :pacientes="pacientes" v-if="pacientes.length > 0"/>
      <jumbotron-ganancias class="w-75" :ganancias="ganancias" v-if="ganancias.length > 0"/>
    </div>

  </div>
</template>

<script>
import HeaderDashboard from '@/components/dashboard/HeaderDashboard.vue';
import SectionCitasEstados from '@/components/dashboard/SectionCitasEstados.vue';
import JumbotronGanancias from '@/components/dashboard/JumbotronGanancias.vue';
import JumbotronPacientes from '@/components/dashboard/JumbotronPacientes.vue';
import Spinner from '@/components/Spinner.vue';
import axios from "axios";

export default {
  name: "Dashboard",
  components: {
    HeaderDashboard,
    SectionCitasEstados,
    JumbotronGanancias,
    JumbotronPacientes,
    Spinner
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
      gananciaTotal: 0,
      isHeaderLoading: false,
      isSectionLoading: false
    };
  },
  methods: {
    getPacientes(url) {
      this.isHeaderLoading = true;
      axios
        .get(url)
        .then((response) => (this.pacientes = response.data))
        .catch((err) => console.error(err))
        .finally(() => (this.isHeaderLoading = false));
    },
    getPsicologos(url) {
      this.isHeaderLoading = true;
      axios
        .get(url)
        .then((response) => (this.psicologos = response.data))
        .catch((err) => console.error(err))
        .finally(() => (this.isHeaderLoading = false));
    },
    getCitas(url) {
      this.isHeaderLoading = true;
      axios
        .get(url)
        .then((response) => (this.citas = response.data))
        .catch((err) => console.error(err))
        .finally(() => (this.isHeaderLoading = false));
    },
    getGanancias(url) {
      this.isHeaderLoading = true;
      axios
        .get(url)
        .then((response) => (this.ganancias = response.data))
        .then(() => this.calcularGananciaTotal())
        .catch((err) => console.error(err))
        .finally(() => (this.isHeaderLoading = false));
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
      
      this.isSectionLoading = true;

      const response = axios
        .get("wementis/v1/citas/", { params })
        .catch((err) => console.error(err))
        .finally(() => this.isSectionLoading = false);
        
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
.jumbo-container {
  margin-top: 4rem;
}
</style>
