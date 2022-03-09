<template>
  <div class="modal-delete-tarifa">
      
    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteTarifa" title="Borrar tarifa">
      <i class="bi bi-person-x"></i>
    </button>

    <div class="modal fade" id="deleteTarifa" tabindex="-1" aria-labelledby="deleteTarifa" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="deleteTarifa">
               <i class="bi bi-person-x me-1"></i>Borrar tarifa
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            ¿Está seguro de que desea eliminar la tarifa con el ID {{ id }}?
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-danger" data-bs-dismiss="modal" @click="deleteTarifa">Borrar</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    name: "ModalDeleteTarifa",
    props: ["id"],
    events: ["updateTabla"],
    methods: {
      deleteTarifa() {
        axios
          .delete("wementis/v1/tarifas/"+this.id)
          .then(() => this.$emit("updateTabla"))
          .catch((err) => console.error(err));
      }
    }
}
</script>

<style>

</style>