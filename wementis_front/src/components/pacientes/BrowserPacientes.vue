<template>
  <form class="browser-pacientes">
    <div class="input-group">
      <input type="number" class="form-control m-1" name="id" v-model="idPaciente" placeholder="ID">
      <input type="text" class="form-control m-1" name="nombre" v-model="nombre" placeholder="Nombre">
      <input type="text" class="form-control m-1" name="apellidos" v-model="apellidos" placeholder="Apellidos">
      <input type="text" class="form-control m-1" name="telefono" v-model="telefono" placeholder="Teléfono">
      <input type="text" class="form-control m-1" name="email" v-model="email" placeholder="Email">
    </div>

    <div class="input-group">
      <label for="fechaNac" class="d-flex align-self-center m-1">Fecha nac.</label>
      <input type="date" class="form-control m-1" name="fechaNac" v-model="fechaNacimiento" placeholder="Fecha nac.">
      
      <label for="fechaCrea" class="d-flex align-self-center m-1">Fecha crea.</label>
      <input type="date" class="form-control m-1" name="fechaCrea" v-model="fechaCreacion" placeholder="Fecha crea.">
      
      <div class="form-check form-check-inline align-self-center m-1 w-md-50">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="masculino" value="M" v-model="genero">
        <label class="form-check-label" for="masculino">Masculino</label>
      </div>

      <div class="form-check form-check-inline align-self-center m-1">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="femenino" value="F" v-model="genero">
        <label class="form-check-label" for="femenino">Femenino</label>
      </div>
    </div>

    <div class="input-group mt-3 d-flex justify-content-end">
      <button type="button" class="btn btn-outline-secondary" @click="buscarPacientes">
        <i class="bi bi-search me-1"></i>Buscar
      </button>
    </div>
  </form>
</template>

<script>
export default {
  name: "BrowserPacientes",
  events: ["buscarPacientes"],
  data() {
    return {
      idPaciente: "",
      nombre: "",
      apellidos: "",
      telefono: "",
      email: "",
      fechaNacimiento: "",
      genero: "",
      fechaCreacion: ""
    }
  },
  methods: {
    buscarPacientes() {
      this.$emit("buscarPacientes", this.idPaciente, this.nombre, this.apellidos, this.telefono, this.email, this.fechaNacimiento, this.genero, this.fechaCreacion);
      
      this.idPaciente = "",
      this.nombre = "";
      this.apellidos = "",
      this.telefono = "",
      this.email = "",
      this.fechaNacimiento = "";
      this.genero = "",
      this.fechaCreacion = "";
    }
  }
}
</script>

<style scoped>
.form-control {
  border: 2px solid rgba(0, 0, 0, 0.103);
  text-align: center;
  border-radius: 9px !important;
}
</style>