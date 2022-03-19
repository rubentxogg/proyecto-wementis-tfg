<template>
  <div class="modal-delete-cita">
      
    <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#deleteCita" title="Borrar cita" @click="borradoCita">
      <i class="bi bi-trash"></i>
    </button>

    <div class="modal fade" id="deleteCita" tabindex="-1" aria-labelledby="deleteCita" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="deleteCita">
               <i class="bi bi-trash me-1"></i>Borrar cita
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body text-start">
            ¿Está seguro de que desea eliminar la cita con el ID {{ id }}?
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-danger" data-bs-dismiss="modal" @click="deletePaciente">Borrar</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    name: "ModalDeleteCita",
    props: ["id"],
    events: ["borradoCita", "updateTabla"],
    methods: {
      deletePaciente() {
        axios
          .delete("wementis/v1/citas/"+this.id)
          .then(() => this.$emit("updateTabla"))
          .catch((err) => console.error(err));
      },
      borradoPaciente() {
        this.$emit("borradoPaciente");
      }
    }
}
</script>

<style>

</style>