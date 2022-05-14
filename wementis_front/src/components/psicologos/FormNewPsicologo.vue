<template>
   <form class="form-new-psicologo d-flex flex-wrap">
    <div class="input-group mb-3">
     <span class="input-group-text">Nombre</span>
     <input type="text" class="form-control" name="nombre" v-model="nombre" maxlength="25" placeholder="Ej. Rubén">
     <i v-if="isCorrectNombre" class="bi bi-check fs-3 text-success"></i>
     <i v-else class="bi bi-x fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Apellidos</span>
     <input type="text" class="form-control" name="apellidos" v-model="apellidos" maxlength="25" placeholder="Ej. García">
     <i v-if="isCorrectApellidos" class="bi bi-check fs-3 text-success"></i>
     <i v-else class="bi bi-x fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Teléfono</span>
     <input type="tel" class="form-control" name="telefono" v-model="telefono" maxlength="9" placeholder="9 Dígitos">
     <i v-if="isCorrectTelefono" class="bi bi-check fs-3 text-success"></i>
     <i v-else class="bi bi-x fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Email</span>
     <input type="email" class="form-control" name="email" v-model="email" placeholder="example@hotmail.com">
     <i v-if="isCorrectEmail" class="bi bi-check fs-3 text-success"></i>
     <i v-else class="bi bi-x fs-3 text-danger"></i>
    </div>

     <div class="modal-footer w-100">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" @click="resetForm">Cancelar</button>
        <button type="button" :class="isFormValidationCorrect" data-bs-dismiss="modal" @click="anadirPsicologo">Guardar</button>
     </div>
  </form>
</template>

<script>
import axios from 'axios';

export default {
  name: "FormNewPsicologo",
  events: ["updateTabla"],
  data() {
    return {
      nombre: "",
      apellidos: "",
      telefono: "",
      email: "",
      regNombre: /^[\w|á|é|í|ó|ú]+[\s]?[\w|á|é|í|ó|ú]*[\s]?[\w|á|é|í|ó|ú]*$/, // Juan José
      regNumeros: /\d+/,
      regTelefono: /^[\d]{9}$/,
      regEmail: /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/
    };
  },
  methods: {
    anadirPsicologo() {
      const psicologo = {
        nombre: this.nombre,
        apellidos: this.apellidos,
        telefono: this.telefono,
        email: this.email,
        activo: 1
      }
      
      axios
        .post("http://localhost:8080/wementis/v1/psicologos/", psicologo)
        .then(() => this.nombre = "", this.apellidos = "", this.telefono = "", this.email = "")
        .then(() => {
          this.$emit("updateTabla");
          this.successAlert();
        })
        .catch(() => this.errorAlert());
    },
    resetForm() {
      this.nombre = "",
      this.apellidos = "",
      this.email = "",
      this.telefono = ""
    },
    successAlert() {
      this.$toast.open({
      message: "Psicólogo añadido con éxito",
      type: "success",
      duration: 5000,
      dismissible: true,
      });
    },
    errorAlert() {
      this.$toast.open({
      message: "No se ha podido añadir el psicólogo",
      type: "error",
      duration: 5000,
      dismissible: true,
      });
    },
  },
  computed: {
    isCorrectNombre() {
      if(!this.regNombre.test(this.nombre) || this.regNumeros.test(this.nombre)) return false;
      return true;
    },
    isCorrectApellidos() {
      if(!this.regNombre.test(this.apellidos) || this.regNumeros.test(this.apellidos)) return false;
      return true;
    },
    isCorrectTelefono() {
      if(!this.regTelefono.test(this.telefono)) return false;
      return true;
    },
    isCorrectEmail() {
      if(!this.regEmail.test(this.email)) return false;
      return true;
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