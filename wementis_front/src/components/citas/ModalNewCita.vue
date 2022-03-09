<template>
  <div class="modal-new-cita align-self-end">
      
    <button type="button" class="btn btn-success d-flex" data-bs-toggle="modal" data-bs-target="#newCita">
      <i class="bi bi-plus-circle me-1"></i>
      <span class="align-self-center">Añadir</span>
    </button>

    <div class="modal fade" id="newCita" tabindex="-1" aria-labelledby="newCita" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="newCita">
             <i class="bi bi-calendar-week me-1"></i>Nueva cita
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form-new-cita @updateTabla="updateTabla"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FormNewCita from '@/components/citas/FormNewCita.vue';

export default {
    name: "ModalNewCita",
    components: {
        FormNewCita
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