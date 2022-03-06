<template>
  <table class="table table-pacientes">
    <thead>
      <tr>
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
      <tr v-for="paciente in pacientes" :key="paciente.id">
        <td>{{ paciente.idPaciente }}</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "TablePacientes",
  props: ["pacientes"]
};
</script>

<style></style>
