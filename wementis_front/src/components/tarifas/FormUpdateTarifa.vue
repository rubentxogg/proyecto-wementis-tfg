<template>
  <form class="form-update-tarifa d-flex flex-wrap">
    <div class="input-group mb-3">
     <span class="input-group-text">Nombre</span>
     <input type="text" class="form-control" name="nombre" :placeholder="tarifa.nombre" v-model="nombre">
     <i v-if="isCorrectNombre" class="bi bi-check2-circle fs-3 text-success"></i>
     <i v-else class="bi bi-backspace fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Precio/h</span>
     <input type="text" class="form-control" name="precioHora" :placeholder="tarifa.precioHora" v-model="precioHora">
     <i v-if="isCorrectPrecioHora" class="bi bi-check2-circle fs-3 text-success"></i>
     <i v-else class="bi bi-backspace fs-3 text-danger"></i>
    </div>

    <div class="modal-footer w-100">
       <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" @click="resetForm">Cancelar</button>
       <button type="button" :class="isFormValidationCorrect" data-bs-dismiss="modal" @click="actualizarTarifa">Guardar</button>
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
          precioHora: "",
          regNombre: /(^[\w|á|é|í|ó|ú]+[\s]?[\w|á|é|í|ó|ú]*[\s]?[\w|á|é|í|ó|ú]*$)?/,
          regPrecioHora: /^(\d+)?$/,
          regNumeros: /(\d+)/,
          regEspacios: /^\s+/,
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
    },
    resetForm() {
      this.nombre = "",
      this.precioHora = ""
    }
  },
  computed: {
    isCorrectNombre() {
      if(!this.regNombre.test(this.nombre) || this.regNumeros.test(this.nombre) || this.regEspacios.test(this.nombre)) return false;
      return true;
    },
    isCorrectPrecioHora() {
      if(!this.regPrecioHora.test(this.precioHora)) return false;
      return true;
    },
    isFormValidationCorrect() {
      if(this.isCorrectNombre && this.isCorrectPrecioHora) return "btn btn-success";
      return "btn btn-outline-success disabled";
    }
  }
}
</script>

<style scoped>
div i{
  position: absolute;
  right: 0.5rem;
}
</style>