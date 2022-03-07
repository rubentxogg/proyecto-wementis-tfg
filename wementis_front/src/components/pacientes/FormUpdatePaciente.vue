<template>
   <form class="form-update-paciente d-flex flex-wrap">
    <div class="input-group mb-3">
     <span class="input-group-text">Nombre</span>
     <input type="text" class="form-control" name="nombre" :value="paciente.nombre">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Apellidos</span>
     <input type="text" class="form-control" name="apellidos" :value="paciente.apellidos">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Teléfono</span>
     <input type="text" class="form-control" name="telefono" :value="paciente.telefono">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Email</span>
     <input type="text" class="form-control" name="email" :value="paciente.email">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Fecha nac.</span>
     <input type="date" class="form-control" name="fechaNac" :value="paciente.fechaNacimiento">
    </div>

    <div class="input-group mb-3 m-1">
      <span class="input-group-text me-4">Género</span>
     
      <div class="form-check form-check-inline align-self-center">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="masculino" value="M" :checked="generoMasculinoIsChecked">
        <label class="form-check-label" for="masculino">Masculino</label>
      </div>

      <div class="form-check form-check-inline align-self-center">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="femenino" value="F" :checked="generoFemeninoIsChecked">
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
  methods: {
    actualizarPaciente() {
      const paciente = {
        idPaciente: this.idPaciente,
        nombre: this.nombre,
        apellidos: this.apellidos,
        telefono: this.telefono,
        email: this.email,
        fechaNacimiento: this.fechaNacimiento,
        genero: this.genero,
        fechaCreacion: this.fechaCreacion
      }
      
      axios
        .put("wementis/v1/pacientes/", paciente)
        .then(() => this.idPaciente = "", this.nombre = "", this.apellidos = "", this.telefono = "", this.email = "", 
            this.fechaNacimiento = "", this.genero = "", this.fechaCreacion = "")
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