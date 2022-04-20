<template>
  <div class="informe d-flex flex-column min-vh-100">
    <h1>Informe</h1>
    <a href="wementis/v1/pdf/generate" class="btn btn-success" target="_blank">Descargar PDF</a>
    <footer-wementis />
  </div>
</template>

<script>
import FooterWementis from '@/components/FooterWementis.vue';

export default {
    name: "Informe",
    components: {
      FooterWementis
    },
}
</script>

<style>
</style>