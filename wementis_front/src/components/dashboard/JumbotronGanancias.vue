<template>
  <div class="jumbotron-pacientes mb-4 bg-light rounded-3 border border-3">
    <div class="container-fluid py-5">
      <h3 class="display-6 fw-bold text-center">Últimas ganancias</h3>
      <hr class="mb-5">
      <div v-if="ultimasGanancias.length > 0">
        <h5 v-for="ganancia in ultimasGanancias" :key="ganancia.idPaciente || ganancia.id" class="mb-3">
          <span class="d-inline-block bg-teal rounded-circle me-1"></span> {{ ganancia.fechaCreacion }} 
          <i class="bi bi-caret-right"></i> ID Cita: {{ ganancia.cita.id }} 
          <i class="bi bi-caret-right"></i> {{ new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(ganancia.cantidad) }}
        </h5>
      </div>
      
      <h4 v-else><i class="bi bi-exclamation-triangle me-1"></i>Todavía no existen ganancias, completa una cita para recibir una ganancia.</h4>
    </div>
  </div>
</template>

<script>
export default {
  name: "JumbotronGanancias",
  props: ["ganancias"],
  data() {
    return {
      ultimasGanancias: []
    }
   },
   mounted() {
      this.ultimasGanancias = this.ganancias.slice(Math.max(this.ganancias.length - 5, 0));
   }
}
</script>

<style scoped>
span {
  width: .5em; 
  height: .5em;
}
</style>