<template>
  <form class="form-update-tarifa d-flex flex-wrap">
    <div class="input-group mb-3">
     <span class="input-group-text">Nombre</span>
     <input type="text" class="form-control" name="nombre" :placeholder="tarifa.nombre" v-model="nombre">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Precio/h</span>
     <input type="number" class="form-control" name="precioHora" :placeholder="tarifa.precioHora" v-model="precioHora">
    </div>

    <div class="modal-footer w-100">
       <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
       <button type="button" class="btn btn-success" data-bs-dismiss="modal" @click="actualizarTarifa">Guardar</button>
    </div>
  </form>
</template>

<script>
import axios from 'axios';

export default {
  name: "FormUpdateTarifa",
  props: ["tarifa"],
  events: ["updateTabla"],
  data() {
      return {
          nombre: "",
          precioHora: ""
      }
  },
  methods: {
    actualizarTarifa() {
      axios
        .put("wementis/v1/tarifas/", { 
          idTarifa: this.tarifa.idTarifa || this.tarifa.id,
          nombre: this.nombre || this.tarifa.nombre,
          precioHora: this.precioHora || this.tarifa.precioHora,
          fechaCreacion: this.tarifa.fechaCreacion})
        .then(() => this.$emit("updateTabla"))
        .catch((err) => console.error(err));
    }
  }
}
</script>

<style>

</style>