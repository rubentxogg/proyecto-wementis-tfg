<template>
   <form class="form-update-paciente d-flex flex-wrap">
    <div class="input-group mb-3">
     <span class="input-group-text">Nombre</span>
     <input type="text" class="form-control" name="nombre" maxlength="25" :placeholder="paciente.nombre" v-model="nombre">
     <i v-if="isCorrectNombre" class="bi bi-check fs-3 text-success"></i>
     <i v-else class="bi bi-x fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Apellidos</span>
     <input type="text" class="form-control" name="apellidos" maxlength="25" :placeholder="paciente.apellidos" v-model="apellidos">
     <i v-if="isCorrectApellidos" class="bi bi-check fs-3 text-success"></i>
     <i v-else class="bi bi-x fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Teléfono</span>
     <input type="tel" class="form-control" name="telefono" maxlength="9" :placeholder="paciente.telefono" v-model="telefono">
     <i v-if="isCorrectTelefono" class="bi bi-check fs-3 text-success"></i>
     <i v-else class="bi bi-x fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Email</span>
     <input type="email" class="form-control" name="email" :placeholder="paciente.email" v-model="email">
     <i v-if="isCorrectEmail" class="bi bi-check fs-3 text-success"></i>
     <i v-else class="bi bi-x fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Fecha nac.</span>
     <input :type="checkIsDateOnFocus" class="form-control date" name="fechaNac" :placeholder="paciente.fechaNacimiento" 
      v-model="fechaNacimiento" @focus="isDateOnFocus = true" @blur="isDateOnFocus = false">
     <i v-if="isCorrectFechaNacimiento" class="bi bi-check fs-3 text-success"></i>
     <i v-else class="bi bi-x fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3 m-1">
      <span class="input-group-text me-4">Género</span>
     
      <div class="form-check form-check-inline align-self-center">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="masculino" value="M" :checked="generoMasculinoIsChecked" v-model="genero">
        <label class="form-check-label" for="masculino">Masculino</label>
      </div>

      <div class="form-check form-check-inline align-self-center">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="femenino" value="F" :checked="generoFemeninoIsChecked" v-model="genero">
        <label class="form-check-label" for="femenino">Femenino</label>
      </div>

      <i v-if="isCorrectGenero" class="bi bi-check fs-3 text-success"></i>
      <i v-else class="bi bi-x fs-3 text-danger"></i>
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
  name: "FormUpdatePaciente",
  props: ["paciente"],
  events: ["updateTabla"],
  data() {
    return {
      nombre: "",
      apellidos: "",
      telefono: "",
      email: "",
      fechaNacimiento: "",
      genero: "",
      regNombre: /(^[\w|á|é|í|ó|ú]+[\s]?[\w|á|é|í|ó|ú]*[\s]?[\w|á|é|í|ó|ú]*$)?/, // Juan José
      regNumeros: /(\d+)/,
      regTelefono: /^([\d]{9})?$/,
      regEmail: /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/,
      regFechaNacimiento: /^[\d]{2,4}-[\d]{2}-[\d]{2,4}$/,
      regEspacios: /^\s+/,
      isDateOnFocus: false
    }
  },
  methods: {
    actualizarPaciente() {
      axios
        .put("wementis/v1/pacientes/", { 
          idPaciente: this.paciente.idPaciente || this.paciente.id,
          nombre: this.nombre || this.paciente.nombre,
          apellidos: this.apellidos || this.paciente.apellidos,
          telefono: this.telefono || this.paciente.telefono,
          email: this.email || this.paciente.email,
          fechaNacimiento: this.fechaNacimiento || this.paciente.fechaNacimiento,
          genero: this.genero || this.paciente.genero,
          fechaCreacion: this.paciente.fechaCreacion,
          activo: this.paciente.activo})
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
      this.telefono = "",
      this.fechaNacimiento = ""
      this.genero = this.generoMasculinoIsChecked ? "M" : "F";
    },
    successAlert() {
      this.$toast.open({
      message: "Paciente actualizado con éxito",
      type: "success",
      duration: 5000,
      dismissible: true,
      });
    },
    errorAlert() {
      this.$toast.open({
      message: "No se ha podido actualizar el paciente",
      type: "error",
      duration: 5000,
      dismissible: true,
      });
    },
  },
  computed: {
    generoMasculinoIsChecked() {
      if(this.paciente.genero === 'M') return true;
      return false;
    },
    generoFemeninoIsChecked() {
       if(this.paciente.genero === 'F') return true;
       return false;
    },
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
    isCorrectFechaNacimiento() {
      if(this.regFechaNacimiento.test(this.fechaNacimiento) || this.fechaNacimiento === "") return true;
      return false;
    },
    isCorrectGenero() {
      if(!this.genero === "" || !this.genero === "M" || !this.genero === "F") return false;
      return true;
    },
    isFormValidationCorrect() {
      if(this.isCorrectNombre && this.isCorrectApellidos && this.isCorrectTelefono && this.isCorrectEmail
        && this.isCorrectFechaNacimiento && this.isCorrectGenero) return "btn btn-success";
      return "btn btn-outline-success disabled";
    },
    checkIsDateOnFocus() {
      if(this.isDateOnFocus) return "date";
      return "text";
    }
  }
}
</script>

<style scoped>
div i{
  position: absolute;
  right: 0.5rem;
}

input[type="date"] + i {
  position: absolute;
  right: 2rem;
}

.date {
  cursor: pointer;
}
</style>