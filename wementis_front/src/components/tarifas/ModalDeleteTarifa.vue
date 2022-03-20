<template>
  <div class="modal-delete-tarifa">
      
    <button type="button" class="btn btn-danger rounded-circle border border-2" data-bs-toggle="modal" data-bs-target="#deleteTarifa" title="Borrar tarifa" @click="borradoTarifa">
      <i class="bi bi-trash"></i>
    </button>

    <div class="modal fade" id="deleteTarifa" tabindex="-1" aria-labelledby="deleteTarifa" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="deleteTarifa">
              <i class="bi bi-trash me-1"></i>Borrar tarifa
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
    events: ["borradoTarifa", "updateTabla"],
    methods: {
      deleteTarifa() {
        axios
          .delete("wementis/v1/tarifas/"+this.id)
          .then(() => this.$emit("updateTabla"))
          .catch((err) => console.error(err));
      },
      borradoTarifa() {
        this.$emit("borradoTarifa");
      }
    }
}
</script>

<style>

</style>