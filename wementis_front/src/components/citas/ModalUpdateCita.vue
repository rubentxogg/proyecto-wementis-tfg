<template>
  <div class="modal-update-cita">
      
    <button type="button" class="btn btn-warning rounded-circle" data-bs-toggle="modal" data-bs-target="#updateCita" @click="updateCita" title="Modificar cita">
      <i class="bi bi-pen text-light"></i>
    </button>

    <div class="modal fade" id="updateCita" tabindex="-1" aria-labelledby="updateCita" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="updateCita">
              <i class="bi bi-pen me-1"></i>Modificar cita
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form-update-cita :cita="cita" @updateTabla="updateTabla"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FormUpdateCita from '@/components/citas/FormUpdateCita.vue';

export default {
    name: "ModalUpdateCita",
    props: ["cita"],
    events: ["updateCita", "updateTabla"],
    components: { FormUpdateCita },
    methods: {
      updateCita() {
        this.$emit("updateCita");
      },
      updateTabla() {
        this.$emit("updateTabla");
      }
    }
}
</script>

<style>

</style>