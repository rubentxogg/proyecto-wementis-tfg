<template>
  <div class="modal-update-psicologo">
      
    <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updatePsicologo" @click="updatePsicologo" title="Modificar psicólogo">
      <i class="bi bi-pen text-light"></i>
    </button>

    <div class="modal fade" id="updatePsicologo" tabindex="-1" aria-labelledby="updatePsicologo" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="updatePsicologo">
              <i class="bi bi-pen me-1"></i>Modificar psicólogo
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form-update-psicologo :psicologo="psicologo" @updateTabla="updateTabla"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FormUpdatePsicologo from '@/components/psicologos/FormUpdatePsicologo.vue';

export default {
    name: "ModalUpdatePsicologo",
    props: ["psicologo"],
    events: ["updatePsicologo", "updateTabla"],
    components: { FormUpdatePsicologo },
    methods: {
      updatePsicologo() {
        this.$emit("updatePsicologo");
      },
      updateTabla() {
        this.$emit("updateTabla");
      }
    }
}
</script>

<style>

</style>