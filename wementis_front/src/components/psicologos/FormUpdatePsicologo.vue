<template>
  <form class="form-update-psicologo d-flex flex-wrap">
    <div class="input-group mb-3">
     <span class="input-group-text">Nombre</span>
     <input type="text" class="form-control" name="nombre" maxlength="25" :placeholder="psicologo.nombre" v-model="nombre">
     <i v-if="isCorrectNombre" class="bi bi-check2-circle fs-3 text-success"></i>
     <i v-else class="bi bi-backspace fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Apellidos</span>
     <input type="text" class="form-control" name="apellidos" maxlength="25" :placeholder="psicologo.apellidos" v-model="apellidos">
     <i v-if="isCorrectApellidos" class="bi bi-check2-circle fs-3 text-success"></i>
     <i v-else class="bi bi-backspace fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Teléfono</span>
     <input type="tel" class="form-control" name="telefono" maxlength="9" :placeholder="psicologo.telefono" v-model="telefono">
     <i v-if="isCorrectTelefono" class="bi bi-check2-circle fs-3 text-success"></i>
     <i v-else class="bi bi-backspace fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Email</span>
     <input type="email" class="form-control" name="email" :placeholder="psicologo.email" v-model="email">
     <i v-if="isCorrectEmail" class="bi bi-check2-circle fs-3 text-success"></i>
     <i v-else class="bi bi-backspace fs-3 text-danger"></i>
    </div>

    <div class="modal-footer w-100">
       <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" @click="resetForm">Cancelar</button>
       <button type="button" :class="isFormValidationCorrect" data-bs-dismiss="modal" @click="actualizarPaciente">Guardar</button>
    </div>
  </form>
</template>

<script>
import axios from 'axios';

export default {
  name: "FormUpdatePsicologo",
  props: ["psicologo"],
  events: ["updateTabla"],
  data() {
    return {
      nombre: "",
      apellidos: "",
      telefono: "",
      email: "",
      regNombre: /(^[\w|á|é|í|ó|ú]+[\s]?[\w|á|é|í|ó|ú]*[\s]?[\w|á|é|í|ó|ú]*$)?/, // Juan José
      regNumeros: /(\d+)/,
      regTelefono: /^([\d]{9})?$/,
      regEmail: /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/,
      regEspacios: /^\s+/
    }
  },
  methods: {
    actualizarPaciente() {
      axios
        .put("wementis/v1/psicologos/", { 
          idPsicologo: this.psicologo.idPsicologo || this.psicologo.id,
          nombre: this.nombre || this.psicologo.nombre,
          apellidos: this.apellidos || this.psicologo.apellidos,
          telefono: this.telefono || this.psicologo.telefono,
          email: this.email || this.psicologo.email,
          fechaCreacion: this.psicologo.fechaCreacion})
        .then(() => this.$emit("updateTabla"))
        .catch((err) => console.error(err));
    },
    resetForm() {
      this.nombre = "",
      this.apellidos = "",
      this.email = "",
      this.telefono = ""
    }
  },
  computed: {
    isCorrectNombre() {
      if(!this.regNombre.test(this.nombre) || this.regNumeros.test(this.nombre) || this.regEspacios.test(this.nombre)) return false;
      return true;
    },
    isCorrectApellidos() {
      if(!this.regNombre.test(this.apellidos) || this.regNumeros.test(this.apellidos) || this.regEspacios.test(this.apellidos)) return false;
      return true;
    },
    isCorrectTelefono() {
      if(!this.regTelefono.test(this.telefono)) return false;
      return true;
    },
    isCorrectEmail() {
      if(this.email === "" || this.regEmail.test(this.email)) return true;
      return false;
    },
    isFormValidationCorrect() {
      if(this.isCorrectNombre && this.isCorrectApellidos && this.isCorrectTelefono && this.isCorrectEmail) return "btn btn-success";
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