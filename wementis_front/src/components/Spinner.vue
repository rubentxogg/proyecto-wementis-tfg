<template>
  <div class="spinner text-primary d-flex justify-content-center">
    <div class="spinner-border" role="status">
      <span class="visually-hidden">Cargando...</span>
    </div>
  </div>
</template>

<script>
export default {
  name: "Spinner",
};
</script>

<style scoped>
.spinner {
  width: 100%;
  margin-top: 1rem;
}
</style>