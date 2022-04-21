<template>
    <div class="header-dashboard d-flex justify-content-evenly mt-4">
        <div class="d-flex align-items-center">
          <span class="bg-primary rounded-circle me-1 d-flex justify-content-center align-items-center text-light">
            <i class="bi bi-calendar-week fs-5"></i>
          </span>
          <h6 class="mt-1">Citas: {{ citas.length }}</h6>
        </div>
        <div class="d-flex align-items-center">
          <span class="bg-indigo rounded-circle me-1 d-flex justify-content-center align-items-center text-light">
            <i class="bi bi-people fs-5"></i>
          </span>
          <h6 class="mt-1">Pacientes: {{ pacientes.length }}</h6>
        </div>
        <div class="d-flex align-items-center">
          <span class="bg-pink rounded-circle me-1 d-flex justify-content-center align-items-center text-light">
            <i class="bi bi-heart-pulse fs-5"></i>
          </span>
          <h6 class="mt-1">Psicólogos: {{ psicologos.length }}</h6>
        </div>
        <div class="d-flex align-items-center">
          <span class="bg-success rounded-circle me-1 d-flex justify-content-center align-items-center text-light">
            <i class="bi bi-piggy-bank fs-4"></i>
          </span>
          <h6 class="mt-1">
            Ganancia total: {{ gananciaTotal }}<i class="bi bi-currency-euro"></i>
          </h6>
        </div>
        </div>
</template>

<script>
export default {
    name: "HeaderDashboard",
    props: ["citas", "pacientes", "psicologos", "gananciaTotal"]
}
</script>

<style scoped>
span {
  width: 2.5em;
  height: 2.5em;
}
</style>