<template>
   <form class="form-new-tarifa d-flex flex-wrap">
    <div class="input-group mb-3">
     <span class="input-group-text">Nombre</span>
     <input type="text" class="form-control" name="nombre" v-model="nombre">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Precio/h</span>
     <input type="number" class="form-control" name="precioHora" v-model="precioHora">
    </div>

     <div class="modal-footer w-100">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-success" data-bs-dismiss="modal" @click="anadirTarifa">Guardar</button>
     </div>
  </form>
</template>

<script>
import axios from 'axios';

export default {
  name: "FormNewTarifa",
  events: ["updateTabla"],
  data() {
    return {
      nombre: "",
      precioHora: ""
    };
  },
  methods: {
    anadirTarifa() {
      const tarifa = {
        nombre: this.nombre,
        precioHora: this.precioHora
      }
      
      axios
        .post("wementis/v1/tarifas/", tarifa)
        .then(() => this.nombre = "", this.precioHora = "")
        .then(() => this.$emit("updateTabla"))
        .catch((err) => console.error(err));
    }
  }
}
</script>

<style>

</style>