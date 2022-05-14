<template>
  <div class="modal-completar-cita">
      
    <button type="button" class="btn btn-success rounded-circle" data-bs-toggle="modal" data-bs-target="#completarCita" title="Completar cita" @click="completacionCita">
      <i class="bi bi-check2-circle"></i>
    </button>

    <div class="modal fade" id="completarCita" tabindex="-1" aria-labelledby="completarCita" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="completarCita">
               <i class="bi bi-check2-circle me-1"></i>Completar cita
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            ¿Está seguro de desea completar la cita con el ID {{ id }}?
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-success" data-bs-dismiss="modal" @click="completarCita">Completar</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    name: "ModalCompletarCita",
    props: ["id"],
    events: ["completacionCita", "updateTabla"],
    methods: {
      completarCita() {
        axios
          .put("http://localhost:8080/wementis/v1/citas/"+this.id)
          .then(() => {
            this.$emit("updateTabla");
            this.successAlert();
          })
          .catch(() => this.errorAlert());
      },
      completacionCita() {
        this.$emit("completacionCita");
      },
      successAlert() {
        this.$toast.open({
        message: "Cita completada con éxito",
        type: "success",
        duration: 5000,
        dismissible: true,
        });
      },
      errorAlert() {
        this.$toast.open({
        message: "No se ha podido completar la cita",
        type: "error",
        duration: 5000,
        dismissible: true,
        });
      },
    }
}
</script>

<style>

</style>