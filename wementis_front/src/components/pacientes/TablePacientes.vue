<template>
  <table class="table table-pacientes bg-primary">
    <thead>
      <tr class="text-light">
        <th>ID</th>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>Teléfono</th>
        <th>Email</th>
        <th>Fecha nac.</th>
        <th>Género</th>
        <th>Fecha crea.</th>
      </tr>
    </thead>

    <tbody>
      <tr v-for="paciente in pacientes" :key="paciente.idPaciente || paciente.id" class="table-light">
        <th>{{ paciente.idPaciente || paciente.id }}</th>
        <td>{{ paciente.nombre }}</td>
        <td>{{ paciente.apellidos }}</td>
        <td>{{ paciente.telefono }}</td>
        <td>{{ paciente.email }}</td>
        <td>{{ paciente.fechaNacimiento }}</td>
        <td>{{ paciente.genero }}</td>
        <td>{{ paciente.fechaCreacion }}</td>
        <td>
          <modal-update-paciente @updatePaciente="obtenerPaciente(paciente)" :paciente="pacienteToUpdate"/>
        </td>
        <td>
          <modal-delete-paciente @click="obtenerIdPaciente(paciente.idPaciente || paciente.id)" :id="id"/>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import ModalUpdatePaciente from '@/components/pacientes/ModalUpdatePaciente.vue';
import ModalDeletePaciente from '@/components/pacientes/ModalDeletePaciente.vue';

export default {
  name: "TablePacientes",
  props: ["pacientes"],
  data() {
    return {
      id: "",
      pacienteToUpdate: ""
    }
  },
  components: {
    ModalUpdatePaciente,
    ModalDeletePaciente
  },
  methods: {
    obtenerIdPaciente(id) {
      this.id = id;
    },
    obtenerPaciente(paciente) {
      this.pacienteToUpdate = paciente;
    }
  }
};
</script>

<style scoped>
tbody > tr:hover > * {
  background-color: #d5e6ff;
}
</style>
