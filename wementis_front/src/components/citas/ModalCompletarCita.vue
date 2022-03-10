<template>
  <div class="modal-completar-cita">
      
    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#completarCita" title="Completar cita">
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
            ¿Está seguro de que completar la cita con el ID {{ id }}?
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
    events: ["updateTabla"],
    methods: {
      completarCita() {
        axios
          .put("wementis/v1/citas/"+this.id)
          .then(() => this.$emit("updateTabla"))
          .catch((err) => console.error(err));
      }
    }
}
</script>

<style>

</style>