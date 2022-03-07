<template>
  <aside class="sideNavMenu border-end border-2">
    <nav class="d-flex flex-column">
      <div class="header d-flex justify-content-center align-items-center mt-3">
        <img src="../assets/logo.png" width="70" height="70" alt="logo">
        <h2 class="mt-3 text-primary">WeMentis</h2>
      </div>
      <hr>

      <router-link to="/dashboard" class="p-2 text-dark rounded">
        <i class="bi bi-speedometer2 me-2"></i>Dashboard
      </router-link>

      <router-link to="/pacientes" class="p-2 text-dark rounded">
        <i class="bi bi-people me-2"></i>Pacientes
      </router-link>

      <router-link to="/psicologos" class="p-2 text-dark rounded">
        <i class="bi bi-bandaid me-2"></i>Psicólogos
      </router-link>

      <router-link to="/tarifas" class="p-2 text-dark rounded">
        <i class="bi bi-wallet2 me-2"></i>Tarifas
      </router-link>

      <router-link to="/citas" class="p-2 text-dark rounded">
        <i class="bi bi-calendar-week me-2"></i>Citas
      </router-link>

      <router-link to="/informe" class="p-2 text-dark rounded">
        <i class="bi bi-file-earmark-pdf me-2"></i>Informe
      </router-link>

      <div class="mt-5 d-flex flex-column justify-content-center">
        <hr>
        <a href="http://localhost:8080/wementis/logout" class="text-center rounded">LOGOUT
          <i class="bi bi-caret-down ms-0"></i>
        </a>
      </div>
    </nav>
  </aside>
</template>

<script>
export default {
  name: "SideNavMenu",
};
</script>

<style scoped>
.sideNavMenu {
  height: 100vh;
  width: 20rem;
  position: relative;
}

.header{
  margin-left: -1rem;
  cursor: default;
}

hr{
  height: 0.1rem !important;
}

nav{
  position: fixed;
  width: 18.3rem;
}

a {
  text-decoration: none;
  width: 100%;
}

a.router-link-exact-active {
  color: #ffffff !important;
  background-color: #0d6efd;
}

a:hover {
  color: #ffffff !important;
  background-color: #00000041;
}

i {
  margin-left: 4.5rem;
}
</style>
