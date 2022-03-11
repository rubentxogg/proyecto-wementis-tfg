<template>
  <div class="jumbotron-pacientes mb-4 bg-light rounded-3 border border-3">
    <div class="container-fluid py-5">
      <h3 class="display-6 fw-bold mb-3 text-center">Últimos pacientes</h3>
      <hr>
      <h5 v-for="paciente in pacientes" :key="paciente.idPaciente || paciente.id" class="mb-3">
        <span class="d-inline-block bg-indigo rounded-circle me-1"></span> {{ paciente.nombre }} {{ paciente.apellidos }} 
        <i class="bi bi-caret-right"></i> {{ paciente.fechaCreacion }}
      </h5>
    </div>
  </div>
</template>

<script>
export default {
    name: "JumbotronPacientes",
    props: ["pacientes"]
}
</script>

<style scoped>
span {
  width: .5em; 
  height: .5em;
}
</style>