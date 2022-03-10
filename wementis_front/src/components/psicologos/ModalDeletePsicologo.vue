<template>
  <div class="modal-delete-psicologo">
      
    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deletePsicologo" title="Borrar psicólogo" @click="borradoPsicologo">
      <i class="bi bi-person-x"></i>
    </button>

    <div class="modal fade" id="deletePsicologo" tabindex="-1" aria-labelledby="deletePsicologo" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="deletePsicologo">
               <i class="bi bi-person-x me-1"></i>Borrar psicólogo
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            ¿Está seguro de que desea eliminar el psicólogo con el ID {{ id }}?
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
    name: "ModalDeletePsicologo",
    props: ["id"],
    events: ["borradoPsicologo", "updateTabla"],
    methods: {
      deletePaciente() {
        axios
          .delete("wementis/v1/psicologos/"+this.id)
          .then(() => this.$emit("updateTabla"))
          .catch((err) => console.error(err));
      },
      borradoPsicologo() {
        this.$emit("borradoPsicologo");
      }
    }
}
</script>

<style>

</style>