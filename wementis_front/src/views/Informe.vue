<template>
  <div class="informe d-flex flex-column min-vh-100">
    <p class="text-muted fs-6">Informe</p>

    <div class="container border rounded">
      <div class="d-flex justify-content-between mt-3">
        <h4>INFORME PSICOLÓGICO CLÍNICO</h4>

        <div class="d-flex">
          <h4>Fecha</h4>
          <p class="fw-bold">:</p>
          <input type="date" class="form-control">
        </div>
      </div>

      <hr>

      <div class="d-flex justify-content-between">
        <h5>I.DATOS DE FILIACIÓN</h5>
        <dropdown-pacientes/>
      </div>

      <div class="d-flex flex-column">
        <p class="fw-bold me-3">Nombre y apellidos</p>
        <p class="fw-bold me-3">Fecha de nacimiento</p>
        <p class="fw-bold me-3">Sexo</p>
        <p class="fw-bold me-3">Referente</p>
        <p class="fw-bold me-3">Motivo de evaluación</p>
        <div class="d-flex justify-content-between">
          <p class="fw-bold me-3" >Examinador (psicólogo)</p>
          <dropdown-psicologos/>
        </div>
      </div>
      
      <div class="mb-1">
        <h5>II.MOTIVO DE CONSULTA</h5>
        <textarea class="m-auto form-control" name="motivo" cols="35" rows="3"></textarea>
      </div>

      <div class="mb-1">
        <h5>III.OBSERVACIONES GENERALES</h5>
        <textarea class="m-auto form-control" name="observaciones" cols="35" rows="3"></textarea>
      </div>

      <div class="mb-1">
        <h5>IV.ANÁLISIS DE LOS RESULTADOS</h5>
        <textarea class="m-auto form-control" name="analisisResultados" cols="35" rows="3"></textarea>
      </div>

      <div class="mb-1">
        <h5>V.CONCLUSIONES</h5>
        <textarea class="m-auto form-control" name="conclusiones" cols="35" rows="3"></textarea>
      </div>

      <div class="mb-1">
        <h5>VI.RECOMENDACIONES</h5>
        <textarea class="m-auto form-control" name="recomendaciones" cols="35" rows="3"></textarea>
      </div>

      <hr>

      <div class="d-flex mb-3 justify-content-center">
        <button type="button" class="btn btn-danger me-3"><i class="bi bi-arrow-clockwise me-1"></i>Restablecer</button>
        <a href="wementis/v1/pdf/generate" class="btn btn-success " target="_blank"><i class="bi bi-download me-1"></i>Descargar PDF</a>
      </div>
      
    </div>
  
    <footer-wementis />
  </div>
</template>

<script>
import DropdownPacientes from '@/components/citas/DropdownPacientes.vue';
import DropdownPsicologos from '@/components/citas/DropdownPsicologos.vue';
import FooterWementis from '@/components/FooterWementis.vue';

export default {
    name: "Informe",
    components: {
      DropdownPacientes,
      DropdownPsicologos,
      FooterWementis
    },
}
</script>

<style scoped>
textarea {
  border-radius: 10px;
}
</style>