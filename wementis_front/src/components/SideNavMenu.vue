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
        <button type="button" class="btn dropdown-toggle fw-bold" data-bs-toggle="dropdown" aria-expanded="false">
          <i class="bi bi-gear me-1"></i> {{ usernameWithoutEmail }}
        </button>
        <ul class="dropdown-menu text-center me-fix">
          <a class="dropdown-item text-primary text-primary-hover" href="http://localhost:8080/wementis/logout">Cerrar sesión</a>
          <a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#cambiarPassModal">Cambiar contraseña</a>
          <a class="dropdown-item text-danger text-danger-hover" href="#" data-bs-toggle="modal" data-bs-target="#bajaModal"><i class="bi bi-exclamation-triangle me-1 p-0"></i>Darse de baja</a>
        </ul>
      </div>
    </nav>

    <!-- Cambiar contraseña modal -->
    <div class="modal fade" id="cambiarPassModal" tabindex="-1" aria-labelledby="cambiarPassModal" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="cambiarPassModal"><i class="bi bi-at me-1 p-0"></i>Cambiar contraseña</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body text-center">
            <div class="input-group mb-3 pass">
              <span class="input-group-text">Contraseña actual</span>
              <input type="password" class="form-control" name="email" v-model="passwordActual">
              <i v-if="isCorrectPasswordActual" class="bi bi-check fs-5 text-success"></i>
              <i v-else class="bi bi-x fs-5 text-danger"></i>
            </div>

            <div class="input-group mb-3 pass">
              <span class="input-group-text">Nueva contraseña</span>
              <input type="password" class="form-control" name="email" v-model="passwordNueva">
              <i v-if="isCorrectPasswordNueva" class="bi bi-check fs-5 text-success"></i>
              <i v-else class="bi bi-x fs-5 text-danger"></i>
            </div>

            <div class="input-group mb-3 pass">
              <span class="input-group-text">Rep. nueva contraseña</span>
              <input type="password" class="form-control" name="email" v-model="passwordAgain">
              <i v-if="isCorrectPasswordAgain" class="bi bi-check-all fs-5 text-success"></i>
              <i v-else class="bi bi-x fs-5 text-danger"></i>
            </div>
            
            <span class="circle d-inline-block bg-teal rounded-circle ms-fix"></span> Un número
            <span class="circle d-inline-block bg-teal rounded-circle ms-fix2"></span> Una minúscula
            <br>

            <span class="circle d-inline-block bg-teal rounded-circle"></span> Una mayúscula
            <span class="circle d-inline-block bg-teal rounded-circle ms-5"></span> Mínimo 8 caracteres
          </div>

          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
            <button type="button" :class="isFormValidationCorrect" @click="cambiarContrasena">Guardar</button>
          </div>
        </div>
      </div>
    </div>

    <!-- Darse de baja modal -->
    <div class="modal fade" id="bajaModal" tabindex="-1" aria-labelledby="bajaModal" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="bajaModal"><i class="bi bi-exclamation-triangle me-1 p-0"></i>Darse de baja</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body text-center">
            ¿Está seguro de que quiere darse de baja en la aplicación? <br>Esta decisión es irrevocable.
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-danger" @click="borrarUsuario">Sí, estoy seguro</button>
          </div>
        </div>
      </div>
    </div>
  </aside>
</template>

<script>
import axios from 'axios';

export default {
  name: "SideNavMenu",
  data() {
    return {
      username: "",
      currentUser: "",
      passwordActual: "",
      passwordNueva: "",
      passwordAgain: "",
      regPassword: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/
    }
  },
  mounted() {
    this.getCurrentUsername();
  },
  methods: {
    borrarUsuario() {
      axios.delete("wementis/auth/delete?username=" + this.username)
        .then(() => { 
          this.successAlert("Se ha dado de baja con éxito");
          setTimeout(() => {
            window.location.href = 'http://localhost:8080/wementis/logout';
          }, 1500);
        })
        .catch(() => this.errorAlert("Ha ocurrido un error al intentar darse de baja"));
    },
    cambiarContrasena() {
      const user = {
        username: this.username,
        password: this.password,
        enabled: true
      }

      axios.put("wementis/auth/users/", user)
        .then(() => { 
          this.successAlert("Se ha cambiado la contraseña con éxito")
        })
        .catch(() => this.errorAlert("Ha ocurrido un error al intentar cambiar la contraseña"));
    },
    successAlert(msg) {
      this.$toast.open({
      message: msg,
      type: "success",
      duration: 5000,
      dismissible: true,
      });
    },
    errorAlert(msg) {
      this.$toast.open({
      message: msg,
      type: "error",
      duration: 5000,
      dismissible: true,
      });
    },
    getCurrentUsername() {
      axios.get("wementis/auth/username/")
        .then((response) => this.username = response.data)
        .then(() => {
          this.getCurrentUser();
        })
        .catch((error) => console.error(error));
    },
    getCurrentUser() {
      axios.get("wementis/auth/users?username=" + this.username)
        .then((response) => this.currentUser = response.data)
        .catch((error) => console.error(error));
    }
  },
  computed: {
    isCorrectPasswordActual() {
      if(this.regPassword.test(this.passwordActual)) return true;
      return false;
    },
    isCorrectPasswordNueva() {
      if(this.regPassword.test(this.passwordNueva)) return true;
      return false;
    },
    isCorrectPasswordAgain() {
      if(this.passwordAgain === this.passwordNueva && this.passwordAgain !== "") return true;
      return false;
    },
    isFormValidationCorrect() {
      if(this.isCorrectPasswordActual && this.isCorrectPasswordNueva && this.isCorrectPasswordAgain) return "btn btn-success";
      return "btn btn-success disabled";
    },
    usernameWithoutEmail() {
      return this.username.split("@")[0];
    }
  }
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

.text-danger-hover:hover {
  background-color: #dc3545 !important;
}

.text-primary-hover:hover {
  background-color: #0d6efd !important;
}

.menu-option i {
  margin-left: 5.2rem;
}

.input-group i{
  position: absolute;
  right: 0.5rem;
  top: 0.3rem;
}

.circle {
  width: .5em; 
  height: .5em;
}

.ms-fix {
  margin-left: -2.5rem;
}

.ms-fix2 {
  margin-left: 4.7rem;
}
</style>
