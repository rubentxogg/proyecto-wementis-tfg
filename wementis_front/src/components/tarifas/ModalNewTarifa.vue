<template>
  <div class="modal-new-tarifa align-self-end">
      
    <button type="button" class="btn btn-success d-flex" data-bs-toggle="modal" data-bs-target="#newTarifa">
      <i class="bi bi-person-plus me-1"></i>
      <span class="align-self-center">Añadir</span>
    </button>

    <div class="modal fade" id="newTarifa" tabindex="-1" aria-labelledby="newTarifa" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="newTarifa">
               <i class="bi bi-person-plus me-1"></i>Nueva tarifa
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form-new-tarifa @updateTabla="updateTabla"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FormNewTarifa from '@/components/tarifas/FormNewTarifa.vue';

export default {
    name: "ModalNewTarifa",
    components: {
        FormNewTarifa
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