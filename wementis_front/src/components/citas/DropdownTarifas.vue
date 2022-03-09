<template>
  <div class="dropdown-tarifas btn-group dropstart">
    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      <i class="bi bi-wallet2 ms-2 me-1"></i> Tarifas
    </button>
    <ul class="dropdown-menu">
      <li v-for="tarifa in tarifas" :key="tarifa.idTarifa || tarifa.id" class="text-center">
        <a class="dropdown-item" @click="seleccionarTarifa(tarifa)">{{tarifa.idTarifa || tarifa.id}} - {{ tarifa.nombre }}</a>
        <hr class="dropdown-divider" />
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "DrowpdownTarifas",
  events: ["seleccionTarifa"],
  data() {
    return {
      tarifas: []
    }
  },
  methods: {
    getTarifas(url) {
      axios
        .get(url)
        .then((response) => this.tarifas = response.data)
        .catch((err) => console.error(err));
    },
    seleccionarTarifa(tarifa) {
      this.$emit("seleccionTarifa", tarifa);
    }
  },
  mounted() {
    this.getTarifas("wementis/v1/tarifas/");
  }
}
</script>

<style>

</style>