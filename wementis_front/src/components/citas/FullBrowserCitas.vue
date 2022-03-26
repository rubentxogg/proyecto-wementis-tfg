<template>
  <form class="full-browser-citas d-flex flex-wrap">
    <div class="input-group">
      <input type="number" class="form-control form-control-browser m-1" name="id" v-model="id" placeholder="ID" title="ID de la cita">
      <input type="text" class="form-control form-control-browser m-1" name="pacienteNombre" placeholder="Paciente" v-model="pacienteNombre" title="Nombre del paciente">
      <input type="text" class="form-control form-control-browser m-1" name="psicologoNombre" placeholder="Psicólogo" v-model="psicologoNombre" title="Nombre del psicólogo">
      <input type="text" class="form-control form-control-browser m-1" name="tarifaNombre" placeholder="Tarifa" v-model="tarifaNombre" title="Nombre de la tarifa">
    </div>

    <div class="input-group">
      <span class="input-group-text form-control-browser m-1">Fecha</span>
      <input type="date" class="form-control form-control-browser m-1" name="email" v-model="fecha" title="Fecha de la cita">
   
      <span class="input-group-text form-control-browser m-1">Hora</span>
      <input type="time" class="form-control form-control-browser m-1" name="fechaNac" placeholder="hh:mm" v-model="hora" title="Hora de la cita">
    
      <span class="input-group-text form-control-browser m-1">Duración/h</span>
      <input type="number" class="form-control form-control-browser m-1" name="fechaCrea" v-model="cantidadHoras" title="Nº horas de duración">
    </div>

    <div class="input-group d-flex justify-content-center mt-3">
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

    <div class="input-group mt-3 d-flex justify-content-center gap-2">
      <button type="button" class="btn btn-browser" @click="resetFields">
        <i class="bi bi-arrow-clockwise me-1 text-muted"></i> <span class="fw-bold text-muted">Limpiar</span>
      </button>

      <button type="button" class="btn btn-browser" @click="buscarCitas">
        <i class="bi bi-search me-1"></i> <span class="fw-bold">Buscar</span>
      </button>
    </div>
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
        this.resetFields();
    },
    resetFields() {
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
.form-control:focus {
  transform: scale(1.2, 1.2);
  transition: 0.1s;
}

.btn-browser {
  background:#e7f1ff;
  color: rgba(0, 0, 0, 0.74);
}

.btn-browser:hover {
  color: #0d6efd;
}

.btn-browser:hover .text-muted {
  color: #0d6efd;
}

.form-control-browser {
  border: 2px solid rgba(0, 0, 0, 0.103);
  text-align: center;
  border-radius: 9px !important;
}
</style>