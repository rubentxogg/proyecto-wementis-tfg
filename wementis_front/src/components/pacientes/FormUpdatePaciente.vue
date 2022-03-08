<template>
   <form class="form-update-paciente d-flex flex-wrap">
    <div class="input-group mb-3">
     <span class="input-group-text">Nombre</span>
     <input type="text" class="form-control" name="nombre" :placeholder="paciente.nombre" v-model="nombre">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Apellidos</span>
     <input type="text" class="form-control" name="apellidos" :placeholder="paciente.apellidos" v-model="apellidos">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Teléfono</span>
     <input type="text" class="form-control" name="telefono" :placeholder="paciente.telefono" v-model="telefono">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Email</span>
     <input type="text" class="form-control" name="email" :placeholder="paciente.email" v-model="email">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Fecha nac.</span>
     <input type="date" class="form-control" name="fechaNac" :placeholder="paciente.fechaNacimiento" v-model="fechaNacimiento">
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
    </div>

     <div class="modal-footer w-100">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-success" data-bs-dismiss="modal" @click="actualizarPaciente">Guardar</button>
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
      fechaNacimiento: ""
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
          fechaCreacion: this.paciente.fechaCreacion})
        .then(() => this.$emit("updateTabla"))
        .catch((err) => console.error(err));
    }
  },
  computed: {
      generoMasculinoIsChecked() {
         if(this.paciente.genero === 'M') return true;
         return false;
      },
      generoFemeninoIsChecked() {
         if(this.paciente.genero === 'F') return true;
         return false;
      }
  }
}
</script>

<style>

</style>