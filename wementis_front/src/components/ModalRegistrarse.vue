<template>
  <div class="modal-registrarse align-self-end">
    <button type="button" class="w-100 btn btn-lg bg-indigo text-light" data-bs-toggle="modal" data-bs-target="#registrarse">Registrarse</button>

    <div class="modal fade" id="registrarse" tabindex="-1" aria-labelledby="registrarse" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="registrarse">
               <i class="bi bi-person-plus me-1"></i>Registrarse //TODO
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            Campos para registrarse //TODO
          </div>

          <div class="modal-footer w-100">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-success" data-bs-dismiss="modal">Guardar</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
    name: "ModalRegistrarse",
}
</script>

<style scoped>
.bg-indigo {
  background-color: #6610f2;
}
</style>