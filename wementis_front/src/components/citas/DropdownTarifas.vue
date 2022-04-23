<template>
  <div class="dropdown-tarifas btn-group">
    <button type="button" :class="checkTarifasIsEmpty" data-bs-toggle="dropdown" aria-expanded="false">
      <i class="bi bi-cash-coin me-1"></i> Tarifas
    </button>
    <ul class="dropdown-menu dropdown-menu-dark">
      <li v-for="tarifa in tarifas" :key="tarifa.idTarifa || tarifa.id">
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
  computed: {
    checkTarifasIsEmpty() {
      if(this.tarifas.length > 0) return "btn btn-primary dropdown-toggle";
      return "btn btn-primary dropdown-toggle disabled";
    }
  },
  mounted() {
    this.getTarifas("wementis/v1/tarifas/");
  }
}
</script>

<style>

</style>