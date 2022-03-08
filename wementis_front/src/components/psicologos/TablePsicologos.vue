<template>
  <table class="table table-psicologos bg-primary">
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
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "TablePsicologos",
  props: ["psicologos"]
};
</script>

<style>
</style>
