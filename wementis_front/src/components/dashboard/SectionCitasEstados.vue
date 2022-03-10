<template>
  <div class="section-citas-estados d-flex justify-content-evenly mt-5">
    <h6 class="bg-warning p-4 text-light rounded-pill">
      <i class="bi bi-calendar-minus me-2 fs-5"></i>Citas activas: {{ citasActivas.length }}
    </h6>
    <h6 class="bg-success p-4 text-light rounded-pill">
      <i class="bi bi-calendar-check me-2 fs-5"></i>Citas completadas: {{ citasCompletadas.length }}
    </h6>
    <h6 class="bg-danger p-4 text-light rounded-pill">
      <i class="bi bi-calendar-x me-2 fs-5"></i>Citas canceladas: {{ citasCanceladas.length }}
    </h6>
  </div>
</template>

<script>
export default {
    name: "SectionCitasEstados",
    props: ["citasActivas", "citasCompletadas", "citasCanceladas"]
}
</script>

<style>

</style>