<template>
  <div class="modal-update-tarifa">
      
    <button type="button" class="btn btn-warning rounded-circle border border-2" data-bs-toggle="modal" data-bs-target="#updateTarifa" @click="updateTarifa" title="Modificar tarifa">
      <i class="bi bi-pen text-light"></i>
    </button>

    <div class="modal fade" id="updateTarifa" tabindex="-1" aria-labelledby="updateTarifa" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="updateTarifa">
              <i class="bi bi-pen me-1"></i>Modificar tarifa
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form-update-tarifa :tarifa="tarifa" @updateTabla="updateTabla"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FormUpdateTarifa from '@/components/tarifas/FormUpdateTarifa.vue';

export default {
    name: "ModalUpdateTarifa",
    props: ["tarifa"],
    events: ["updateTarifa", "updateTabla"],
    components: { FormUpdateTarifa },
    methods: {
      updateTarifa() {
        this.$emit("updateTarifa");
      },
      updateTabla() {
        this.$emit("updateTabla");
      }
    }
}
</script>

<style>

</style>