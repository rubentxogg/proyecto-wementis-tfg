<template>
  <div class="modal-update-paciente">
      
    <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updatePaciente" @click="updatePaciente">
      <i class="bi bi-pen text-light"></i>
    </button>

    <div class="modal fade" id="updatePaciente" tabindex="-1" aria-labelledby="updatePaciente" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="updatePaciente">
              <i class="bi bi-pen me-1"></i>Modificar paciente
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form-update-paciente :paciente="paciente"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FormUpdatePaciente from '@/components/pacientes/FormUpdatePaciente.vue'

export default {
  components: { FormUpdatePaciente },
    name: "ModalUpdatePaciente",
    props: ["paciente"],
    events: ["updatePaciente"],
    methods: {
      updatePaciente() {
        this.$emit("updatePaciente");
      }
    }
}
</script>

<style>

</style>