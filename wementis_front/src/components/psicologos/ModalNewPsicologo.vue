<template>
  <div class="modal-new-psicologo align-self-end">
      
    <button type="button" class="btn btn-success d-flex" data-bs-toggle="modal" data-bs-target="#newPsicologo">
      <i class="bi bi-person-plus me-1"></i>
      <span class="align-self-center">Añadir</span>
    </button>

    <div class="modal fade" id="newPsicologo" tabindex="-1" aria-labelledby="newPsicologo" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="newPsicologo">
               <i class="bi bi-heart-pulse me-1"></i>Nuevo psicólogo
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form-new-psicologo @updateTabla="updateTabla"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FormNewPsicologo from '@/components/psicologos/FormNewPsicologo.vue';

export default {
    name: "ModalNewPsicologo",
    components: {
        FormNewPsicologo
    },
    events: ["updateTabla"],
    methods: {
      updateTabla() {
        this.$emit("updateTabla");
      }
    }
}
</script>

<style>

</style>