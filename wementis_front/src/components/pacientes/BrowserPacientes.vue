<template>
  <form class="browser-pacientes d-flex flex-wrap">
    <h4 class="w-100">Buscador</h4>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">ID</span>
     <input type="number" class="form-control" name="id" v-model="idPaciente">
    </div>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">Nombre</span>
     <input type="text" class="form-control" name="nombre" v-model="nombre">
    </div>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">Apellidos</span>
     <input type="text" class="form-control" name="apellidos" v-model="apellidos">
    </div>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">Teléfono</span>
     <input type="text" class="form-control" name="telefono" v-model="telefono">
    </div>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">Email</span>
     <input type="text" class="form-control" name="email" v-model="email">
    </div>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">Fecha nac.</span>
     <input type="date" class="form-control" name="fechaNac" v-model="fechaNacimiento">
    </div>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">Género</span>
     <input type="text" class="form-control" name="genero" v-model="genero">
    </div>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">Fecha crea.</span>
     <input type="date" class="form-control" name="fechaCrea" v-model="fechaCreacion">
    </div>

    <button type="button" class="btn btn-outline-secondary mb-3 w-25 m-1" @click="buscarPacientes">
      <i class="bi bi-search me-1"></i>Buscar
    </button>
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

</style>