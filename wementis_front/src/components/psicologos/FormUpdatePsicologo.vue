<template>
  <form class="form-update-psicologo d-flex flex-wrap">
    <div class="input-group mb-3">
     <span class="input-group-text">Nombre</span>
     <input type="text" class="form-control" name="nombre" :placeholder="psicologo.nombre" v-model="nombre">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Apellidos</span>
     <input type="text" class="form-control" name="apellidos" :placeholder="psicologo.apellidos" v-model="apellidos">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Teléfono</span>
     <input type="text" class="form-control" name="telefono" :placeholder="psicologo.telefono" v-model="telefono">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Email</span>
     <input type="text" class="form-control" name="email" :placeholder="psicologo.email" v-model="email">
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
  name: "FormUpdatePsicologo",
  props: ["psicologo"],
  events: ["updateTabla"],
  data() {
      return {
          nombre: "",
          apellidos: "",
          telefono: "",
          email: "",
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
    }
  }
}
</script>

<style>

</style>