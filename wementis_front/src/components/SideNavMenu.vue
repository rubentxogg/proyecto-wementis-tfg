<template>
  <aside class="sideNavMenu border-end border-2">
    <nav class="d-flex flex-column min-vh-100">
      <div class="header d-flex justify-content-center align-items-center mt-3">
        <img src="../assets/logo.png" width="70" height="70" alt="logo">
        <h2 class="mt-3 text-primary">WeMentis</h2>
      </div>
      <hr>

      <router-link to="/dashboard" class="p-2 text-dark rounded menu-option">
        <i class="bi bi-speedometer2 me-2"></i>Dashboard
      </router-link>

      <router-link to="/pacientes" class="p-2 text-dark rounded menu-option">
        <i class="bi bi-people me-2"></i>Pacientes
      </router-link>

      <router-link to="/psicologos" class="p-2 text-dark rounded menu-option">
        <i class="bi bi-heart-pulse me-2"></i>Psicólogos
      </router-link>

      <router-link to="/tarifas" class="p-2 text-dark rounded menu-option">
        <i class="bi bi-cash-coin me-2"></i>Tarifas
      </router-link>

      <router-link to="/citas" class="p-2 text-dark rounded menu-option">
        <i class="bi bi-calendar-week me-2"></i>Citas
      </router-link>

      <router-link to="/informe" class="p-2 text-dark rounded menu-option">
        <i class="bi bi-file-earmark-pdf me-2"></i>Informe
      </router-link>

      <div class="btn-group dropend mt-auto mb-3 rounded">
        <button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
          <i class="bi bi-gear me-1"></i> Opciones
        </button>
        <ul class="dropdown-menu text-center me-fix">
          <a class="dropdown-item text-primary" href="http://localhost:8080/wementis/logout">Cerrar sesión</a>
          <a class="dropdown-item" href="#">Cambiar contraseña</a>
          <a class="dropdown-item text-danger" href="#"><i class="bi bi-exclamation-triangle me-1 p-0"></i>Darse de baja</a>
        </ul>
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

a:hover, .show.btn-group:hover, .btn:hover {
  color: #ffffff !important;
  background-color: #00000041 !important;
}

.show.btn {
  background-color: #0d6efd;
  color: #ffffff;
}

.text-danger:hover {
  background-color: #dc3545 !important;
}

.text-primary:hover {
  background-color: #0d6efd !important;
}

.menu-option i {
  margin-left: 5.3rem;
}
</style>
