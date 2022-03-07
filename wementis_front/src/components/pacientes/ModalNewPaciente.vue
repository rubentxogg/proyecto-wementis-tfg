<template>
  <div class="modal-new-paciente align-self-end">
      
    <button type="button" class="btn btn-success d-flex mb-1" data-bs-toggle="modal" data-bs-target="#newPaciente">
      <i class="bi bi-person-plus me-1"></i>
      <span class="align-self-center">Añadir</span>
    </button>

    <div class="modal fade" id="newPaciente" tabindex="-1" aria-labelledby="newPaciente" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="newPaciente">
               <i class="bi bi-person-plus me-1"></i>Nuevo paciente
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form-new-paciente />
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-primary">Guardar</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FormNewPaciente from '@/components/pacientes/FormNewPaciente.vue';

export default {
    name: "ModalNewPaciente",
    components: {
        FormNewPaciente
    }
}
</script>

<style>

</style>