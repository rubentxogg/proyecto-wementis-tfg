<template>
  <div class="psicologos">
    <p class="text-muted fs-4 text-decoration-underline">Psicólogos</p>

    <hr>
    <table-psicologos />
  </div>
</template>

<script>
import TablePsicologos from '@/components/psicologos/TablePsicologos.vue';

export default {
    name: "Psicologos",
    components: {
      TablePsicologos
    }
}
</script>

<style>

</style>