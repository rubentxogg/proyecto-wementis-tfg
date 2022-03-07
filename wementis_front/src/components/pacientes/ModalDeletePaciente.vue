<template>
  <div class="modal-delete-paciente">
      
    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deletePaciente">
      <i class="bi bi-person-x"></i>
    </button>

    <div class="modal fade" id="deletePaciente" tabindex="-1" aria-labelledby="deletePaciente" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="deletePaciente">
               <i class="bi bi-person-x me-1"></i>Borrar paciente
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            ...
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Save changes</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
    name: "ModalDeletePaciente"
}
</script>

<style>

</style>