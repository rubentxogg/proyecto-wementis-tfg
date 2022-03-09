<template>
   <form class="form-new-cita d-flex flex-wrap">
    <div class="input-group mb-3">
     <span class="input-group-text">SELECT PACIENTE</span>
     <input type="text" class="form-control" name="nombre" v-model="nombre">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">SELECT PSICÓLOGO</span>
     <input type="text" class="form-control" name="apellidos" v-model="apellidos">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">SELECT TARIFA</span>
     <input type="text" class="form-control" name="telefono" v-model="telefono">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Hora</span>
     <input type="text" class="form-control" name="email" v-model="email">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Fecha</span>
     <input type="date" class="form-control" name="fechaNac" v-model="fechaNacimiento">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Cantidad/h</span>
     <input type="number" class="form-control" name="email" v-model="email">
    </div>

     <div class="modal-footer w-100">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-success" data-bs-dismiss="modal" @click="anadirPaciente">Guardar</button>
     </div>
  </form>
</template>

<script>
import axios from 'axios';

export default {
  name: "FormNewCita",
  events: ["updateTabla"],
  data() {
    return {
      nombre: "",
      apellidos: "",
      telefono: "",
      email: "",
      fechaNacimiento: "",
      genero: "",
    };
  },
  methods: {
    anadirPaciente() {
      const paciente = {
        nombre: this.nombre,
        apellidos: this.apellidos,
        telefono: this.telefono,
        email: this.email,
        fechaNacimiento: this.fechaNacimiento,
        genero: this.genero
      }
      
      axios
        .post("wementis/v1/pacientes/", paciente)
        .then(() => this.nombre = "", this.apellidos = "", this.telefono = "", this.email = "", this.fechaNacimiento = "", this.genero = "")
        .then(() => this.$emit("updateTabla"))
        .catch((err) => console.error(err));
    }
  }
}
</script>

<style>

</style>