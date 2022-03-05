<template>
  <aside class="sideNavMenu">
      <h1>sideNavMenu</h1>
      <router-link to="/dashboard">Dashboard</router-link>
      <router-link to="/pacientes">Pacientes</router-link>
      <router-link to="/psicologos">Psicólogos</router-link>
      <router-link to="/tarifas">Tarifas</router-link>
      <router-link to="/citas">Citas</router-link>
      <router-link to="/informe">Informe</router-link>

      <a href="http://localhost:8080/wementis/logout">LOGOUT</a>
  </aside>
</template>

<script>
export default {
  name: "SideNavMenu",
};
</script>

<style scoped>
</style>