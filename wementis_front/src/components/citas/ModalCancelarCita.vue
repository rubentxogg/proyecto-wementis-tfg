<template>
  <div class="modal-cancelar-cita">
      
    <button type="button" class="btn btn-danger border border-2" data-bs-toggle="modal" data-bs-target="#cancelarCita" title="Cancelar cita" @click="cancelacionCita">
      <i class="bi bi-x-circle"></i>
    </button>

    <div class="modal fade" id="cancelarCita" tabindex="-1" aria-labelledby="cancelarCita" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="cancelarCita">
               <i class="bi bi-x-circle me-1"></i>Cancelar cita
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            ¿Está seguro de desea cancelar la cita con el ID {{ id }}?
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
            <button type="button" class="btn btn-danger" data-bs-dismiss="modal" @click="cancelarCita">Si</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    name: "ModalCancelarCita",
    props: ["id"],
    events: ["cancelacionCita", "updateTabla"],
    methods: {
      cancelarCita() {
        axios
          .delete("wementis/v1/citas/"+this.id)
          .then(() => this.$emit("updateTabla"))
          .catch((err) => console.error(err));
      },
      cancelacionCita() {
        this.$emit("cancelacionCita");
      }
    }
}
</script>

<style>

</style>