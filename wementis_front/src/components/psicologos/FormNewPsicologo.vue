<template>
   <form class="form-new-psicologo d-flex flex-wrap">
    <div class="input-group mb-3">
     <span class="input-group-text">Nombre</span>
     <input type="text" class="form-control" name="nombre" v-model="nombre">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Apellidos</span>
     <input type="text" class="form-control" name="apellidos" v-model="apellidos">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Teléfono</span>
     <input type="text" class="form-control" name="telefono" v-model="telefono">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Email</span>
     <input type="text" class="form-control" name="email" v-model="email">
    </div>

    <div class="input-group mb-3 m-1">
      <span class="input-group-text me-4">Género</span>
     
      <div class="form-check form-check-inline align-self-center">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="masculino" value="M" v-model="genero">
        <label class="form-check-label" for="masculino">Masculino</label>
      </div>

      <div class="form-check form-check-inline align-self-center">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="femenino" value="F" v-model="genero">
        <label class="form-check-label" for="femenino">Femenino</label>
      </div>
    </div>

     <div class="modal-footer w-100">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-success" data-bs-dismiss="modal" @click="anadirPsicologo">Guardar</button>
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
    };
  },
  methods: {
    anadirPsicologo() {
      const psicologo = {
        nombre: this.nombre,
        apellidos: this.apellidos,
        telefono: this.telefono,
        email: this.email,
      }
      
      axios
        .post("wementis/v1/psicologos/", psicologo)
        .then(() => this.nombre = "", this.apellidos = "", this.telefono = "", this.email = "")
        .then(() => this.$emit("updateTabla"))
        .catch((err) => console.error(err));
    }
  }
}
</script>

<style>

</style>