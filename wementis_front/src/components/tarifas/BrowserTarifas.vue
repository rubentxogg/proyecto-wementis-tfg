<template>
  <form class="browser-tarifas d-flex flex-wrap">
    <h4 class="w-100">Buscador</h4>

    <div class="input-group mb-3 w-25 m-1">
      <span class="input-group-text">ID</span>
      <input type="number" class="form-control" name="id" v-model="idTarifa">
    </div>

    <div class="input-group mb-3 w-25 m-1">
      <span class="input-group-text">Nombre</span>
      <input type="text" class="form-control" name="nombre" v-model="nombre">
    </div>

    <div class="input-group mb-3 w-25 m-1">
      <span class="input-group-text">Precio/h</span>
      <input type="text" class="form-control" name="precioHora" v-model="precioHora">
    </div>

    <div class="input-group mb-3 w-25 m-1 h-fix">
      <span class="input-group-text">Fecha crea.</span>
      <input type="date" class="form-control" name="fechaCrea" v-model="fechaCreacion">
    </div>

    <button type="button" class="btn btn-outline-secondary mb-3" @click="buscarTarifas">
      <i class="bi bi-search me-1"></i>Buscar
    </button>
  </form>
</template>

<script>
export default {
  name: "BrowserTarifas",
  events: ["buscarTarifas"],
  data() {
    return {
      idTarifa: "",
      nombre: "",
      precioHora: "",
      fechaCreacion: ""
    }
  },
  methods: {
    buscarTarifas() {
      this.$emit("buscarTarifas", this.idTarifa, this.nombre, this.precioHora, this.fechaCreacion);
      
      this.idTarifa = "",
      this.nombre = "";
      this.precioHora = "",
      this.fechaCreacion = "";
    }
  }
}
</script>

<style scoped>
button {
  position: relative;
  left: 55%;
  bottom: 65%;
  height: 100%;
}

.h-fix {
  height: 1rem;
}
</style>