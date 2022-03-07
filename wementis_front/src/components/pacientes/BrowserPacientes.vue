<template>
  <form class="browser-pacientes d-flex flex-wrap">
    <h4 class="w-100">Buscador</h4>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">ID</span>
     <input type="number" class="form-control" name="id">
    </div>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">Nombre</span>
     <input type="text" class="form-control" name="nombre">
    </div>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">Apellidos</span>
     <input type="text" class="form-control" name="apellidos">
    </div>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">Teléfono</span>
     <input type="text" class="form-control" name="telefono">
    </div>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">Email</span>
     <input type="text" class="form-control" name="email">
    </div>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">Fecha nac.</span>
     <input type="date" class="form-control" name="fechaNac">
    </div>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">Género</span>
     <input type="text" class="form-control" name="genero">
    </div>

    <div class="input-group mb-3 w-25 m-1">
     <span class="input-group-text">Fecha crea.</span>
     <input type="date" class="form-control" name="fechaCrea">
    </div>

    <button type="button" class="btn btn-outline-secondary mb-3 w-25 m-1">
      <i class="bi bi-search me-1"></i>Buscar
    </button>
  </form>
</template>

<script>
export default {
    name: "BrowserPacientes"
}
</script>

<style scoped>

</style>