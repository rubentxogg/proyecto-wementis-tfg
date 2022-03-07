<template>
   <form class="browser-pacientes d-flex flex-wrap">
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

    <div class="input-group mb-3">
     <span class="input-group-text">Fecha nac.</span>
     <input type="date" class="form-control" name="fechaNac" v-model="fechaNacimiento">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Género</span>
     <input type="text" class="form-control" name="genero" v-model="genero">
    </div>
  </form>
</template>

<script>
export default {
    name: "FormNewPaciente"
}
</script>

<style>

</style>