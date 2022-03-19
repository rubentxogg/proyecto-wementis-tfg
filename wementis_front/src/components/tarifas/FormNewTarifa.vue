<template>
   <form class="form-new-tarifa d-flex flex-wrap">
    <div class="input-group mb-3">
     <span class="input-group-text">Nombre</span>
     <input type="text" class="form-control" name="nombre" maxlength="25" v-model="nombre" placeholder="Ej. Bienvenida">
     <i v-if="isCorrectNombre" class="bi bi-check2-circle fs-3 text-success"></i>
     <i v-else class="bi bi-backspace fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Precio/h</span>
     <input type="text" class="form-control" name="precioHora" v-model="precioHora" placeholder="Dígitos">
     <i v-if="isCorrectPrecioHora" class="bi bi-check2-circle fs-3 text-success"></i>
     <i v-else class="bi bi-backspace fs-3 text-danger"></i>
    </div>

     <div class="modal-footer w-100">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" @click="resetForm">Cancelar</button>
        <button type="button" :class="isFormValidationCorrect" data-bs-dismiss="modal" @click="anadirTarifa">Guardar</button>
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
      precioHora: "",
      regNombre: /^[\w|á|é|í|ó|ú]+[\s]?[\w|á|é|í|ó|ú]*[\s]?[\w|á|é|í|ó|ú]*$/,
      regNumeros: /^\d+$/,
    };
  },
  methods: {
    anadirTarifa() {
      const tarifa = {
        nombre: this.nombre,
        precioHora: this.precioHora,
        activo: 1
      }
      
      axios
        .post("wementis/v1/tarifas/", tarifa)
        .then(() => this.nombre = "", this.precioHora = "")
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
      if(!this.regNombre.test(this.nombre) || this.regNumeros.test(this.nombre)) return false;
      return true;
    },
    isCorrectPrecioHora() {
      if(!this.regNumeros.test(this.precioHora)) return false;
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