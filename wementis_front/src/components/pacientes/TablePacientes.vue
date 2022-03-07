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
      <tr v-for="paciente in pacientes" :key="paciente.id" class="table-light">
        <th>{{ paciente.idPaciente }}</th>
        <td>{{ paciente.nombre }}</td>
        <td>{{ paciente.apellidos }}</td>
        <td>{{ paciente.telefono }}</td>
        <td>{{ paciente.email }}</td>
        <td>{{ paciente.fechaNacimiento }}</td>
        <td>{{ paciente.genero }}</td>
        <td>{{ paciente.fechaCreacion }}</td>
        <td>
          <button type="button" class="btn btn-warning">
            <i class="bi bi-pen text-light"></i>
          </button>
        </td>
        <td>
          <button type="button" class="btn btn-danger">
            <i class="bi bi-person-x"></i>
          </button>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "TablePacientes",
  props: ["pacientes"],
};
</script>

<style scoped>
tbody > tr:hover > * {
  background-color: #d5e6ff;
}
</style>
