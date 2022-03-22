<template>
  <table class="table table-psicologos bg-primary align-middle">
    <thead>
      <tr class="text-light">
        <th>ID</th>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>Teléfono</th>
        <th>Email</th>
        <th>Fecha crea.</th>
      </tr>
    </thead>

    <tbody>
      <tr v-for="psicologo in psicologos" :key="psicologo.idPsicologo || psicologo.id" class="table-light">
        <th>{{ psicologo.idPsicologo || psicologo.id }}</th>
        <td>{{ psicologo.nombre }}</td>
        <td>{{ psicologo.apellidos }}</td>
        <td>{{ psicologo.telefono }}</td>
        <td>{{ psicologo.email }}</td>
        <td>{{ psicologo.fechaCreacion }}</td>
        <td>
          <modal-update-psicologo @updatePsicologo="obtenerPsicologo(psicologo)" :psicologo="psicologoToUpdate" @updateTabla="updateTabla"/>
        </td>
        <td>
          <modal-delete-psicologo @borradoPsicologo="obtenerIdPsicologo(psicologo.idPsicologo || psicologo.id)" :id="id" @updateTabla="updateTabla"/>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import ModalUpdatePsicologo from '@/components/psicologos/ModalUpdatePsicologo.vue';
import ModalDeletePsicologo from '@/components/psicologos/ModalDeletePsicologo.vue';

export default {
  name: "TablePsicologos",
  props: ["psicologos"],
  events: ["updateTabla"],
  data() {
    return {
      id: "",
      psicologoToUpdate: ""
    }
  },
  components: { 
    ModalUpdatePsicologo,
    ModalDeletePsicologo
  },
  methods: {
    obtenerIdPsicologo(id) {
      this.id = id;
    },
    obtenerPsicologo(psicologo) {
      this.psicologoToUpdate = psicologo;
    },
    updateTabla() {
      this.$emit("updateTabla");
    }
  }
};
</script>

<style>
</style>
