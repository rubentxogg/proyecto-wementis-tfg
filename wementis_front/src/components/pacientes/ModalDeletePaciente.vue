<template>
  <div class="modal-delete-paciente">
      
    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deletePaciente" title="Borrar paciente" @click="borradoPaciente">
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
            ¿Está seguro de que desea eliminar el paciente con el ID {{ id }}?
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
    name: "ModalDeletePaciente",
    props: ["id"],
    events: ["borradoPaciente", "updateTabla"],
    methods: {
      deletePaciente() {
        axios
          .delete("wementis/v1/pacientes/"+this.id)
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