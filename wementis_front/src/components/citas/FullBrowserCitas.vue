<template>
  <form class="full-browser-citas d-flex flex-wrap">
    <h4 class="w-100">Buscador</h4>

    <div class="input-group mb-3 w-25 m-1">
      <span class="input-group-text">ID</span>
      <input type="number" class="form-control" name="id" v-model="id" title="ID de la cita">
    </div>

    <div class="input-group mb-3 w-25 m-1">
      <span class="input-group-text">Paciente</span>
      <input type="text" class="form-control" name="pacienteNombre" placeholder="Nombre" v-model="pacienteNombre" title="Nombre del paciente">
    </div>

    <div class="input-group mb-3 w-25 m-1">
      <span class="input-group-text">Psicólogo</span>
      <input type="text" class="form-control" name="psicologoNombre" placeholder="Nombre" v-model="psicologoNombre" title="Nombre del psicólogo">
    </div>

    <div class="input-group mb-3 w-25 m-1">
      <span class="input-group-text">Tarifa</span>
      <input type="text" class="form-control" name="tarifaNombre" placeholder="Nombre" v-model="tarifaNombre" title="Nombre de la tarifa">
    </div>

    <div class="input-group mb-3 w-25 m-1">
      <span class="input-group-text">Fecha</span>
      <input type="date" class="form-control" name="email" v-model="fecha" title="Fecha de la cita">
    </div>

    <div class="input-group mb-3 w-25 m-1">
      <span class="input-group-text">Hora</span>
      <input type="time" class="form-control" name="fechaNac" placeholder="hh:mm" v-model="hora" title="Hora de la cita">
    </div>

    <div class="input-group mb-3 w-25 m-1 h-fix">
      <span class="input-group-text">Duración/h</span>
      <input type="number" class="form-control" name="fechaCrea" v-model="cantidadHoras" title="Nº horas de duración">
    </div>

    <div class="input-group w-50 mb-3 m-1 h-fix">
      <span class="input-group-text ">Estado</span>

      <div class="form-check form-check-inline align-self-center">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="activa" value="1" v-model="estado">
        <label class="form-check-label text-warning" for="activa">Activa</label>
      </div>
     
      <div class="form-check form-check-inline align-self-center">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="completada" value="2" v-model="estado">
        <label class="form-check-label text-success" for="completada">Completada</label>
      </div>

      <div class="form-check form-check-inline align-self-center">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="cancelada" value="3" v-model="estado">
        <label class="form-check-label text-danger" for="cancelada">Cancelada</label>
      </div>
    </div>

    <button type="button" class="btn btn-outline-secondary mb-3" @click="buscarCitas">
      <i class="bi bi-search me-1"></i>Buscar
    </button>
  </form>
</template>

<script>
export default {
  name: "FullBrowserCitas",
  events: ["buscarCitas"],
  data() {
    return {
      id: "",
      pacienteNombre: "",
      psicologoNombre: "",
      tarifaNombre: "",
      estado: "",
      fecha: "",
      hora: "",
      cantidadHoras: ""
    }
  },
  methods: {
    buscarCitas() {
      this.$emit("buscarCitas", this.id, this.pacienteNombre, this.psicologoNombre, this.tarifaNombre, this.estado,
        this.fecha, this.hora, this.cantidadHoras);
      
      this.id = "",
      this.pacienteNombre = "";
      this.psicologoNombre = "",
      this.tarifaNombre = "",
      this.estado = "",
      this.fecha = "";
      this.hora = "",
      this.cantidadHoras = "";
    }
  }
}
</script>

<style scoped>
button {
  position: relative;
  left: 4%;
  bottom: 72%;
  height: 100%;
}

.h-fix {
  height: 1rem;
}
</style>