<template>
  <div class="jumbotron-pacientes mb-4 bg-light rounded-3 border border-3">
    <div class="container-fluid py-5">
      <h3 class="display-6 fw-bold mb-3 text-center">Últimos pacientes</h3>
      <hr class="mb-5">
      <h5 v-for="paciente in ultimosPacientes" :key="paciente.idPaciente || paciente.id" class="mb-3">
        <span class="d-inline-block bg-indigo rounded-circle me-1"></span> {{ paciente.fechaCreacion }}
        <i class="bi bi-caret-right"></i> {{ paciente.nombre }} {{ paciente.apellidos }} 
      </h5>
    </div>
  </div>
</template>

<script>
export default {
    name: "JumbotronPacientes",
    props: ["pacientes"],
    data() {
        return {
            ultimosPacientes: []
        }
    },
    mounted() {
        this.ultimosPacientes = this.pacientes.slice(Math.max(this.pacientes.length - 5, 0));
    }
}
</script>

<style scoped>
span {
  width: .5em; 
  height: .5em;
}
</style>