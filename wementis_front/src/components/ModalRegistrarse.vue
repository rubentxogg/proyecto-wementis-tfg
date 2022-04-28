<template>
  <div class="modal-registrarse align-self-end">
    <button type="button" class="w-100 btn btn-lg bg-indigo text-light" data-bs-toggle="modal" data-bs-target="#registrarse">Registrarse</button>

    <div class="modal fade" id="registrarse" tabindex="-1" aria-labelledby="registrarse" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title text-center" id="registrarse">
              <i class="bi bi-pencil-square"></i> Registrarse
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="input-group mb-3">
              <span class="input-group-text">Email</span>
              <input type="email" class="form-control" name="email" v-model="email" placeholder="example@hotmail.com">
              <i v-if="isCorrectEmail" class="bi bi-check fs-5 text-success"></i>
              <i v-else class="bi bi-x fs-5 text-danger"></i>
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text">Repetir email</span>
              <input type="email" class="form-control" name="emailAgain" v-model="emailAgain">
              <i v-if="isCorrectEmailAgain" class="bi bi-check-all fs-5 text-success"></i>
              <i v-else class="bi bi-x fs-5 text-danger"></i>
            </div>

            <div class="input-group mb-3 pass">
              <span class="input-group-text">Contraseña</span>
              <input :type="showHidePassword" class="form-control" name="email" v-model="password">
              <i v-if="isPasswordHidden" @click="isPasswordHidden = false" class="bi bi-eye fs-5"></i>
              <i v-else class="bi bi-eye-slash fs-5" @click="isPasswordHidden = true"></i>
            </div>
            
            <span class="circle d-inline-block bg-teal rounded-circle ms-fix"></span> Un número
            <span class="circle d-inline-block bg-teal rounded-circle ms-fix2"></span> Una minúscula
            <br>

            <span class="circle d-inline-block bg-teal rounded-circle ms-fix"></span> Una mayúscula
            <span class="circle d-inline-block bg-teal rounded-circle ms-5"></span> Mínimo 8 caracteres
            <br>
          </div>

          <div class="modal-footer w-100">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
            <button type="button" :class="isFormValidationCorrect" data-bs-dismiss="modal" @click="registerUser">Guardar</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    name: "ModalRegistrarse",
    data() {
      return {
        email: "",
        emailAgain: "",
        password: "",
        isPasswordHidden: true,
        regEmail: /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/,
        regPassword: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/
      }
    },
    methods: {
      registerUser() {
        const user = {
          username: this.email,
          password: this.password,
          enabled: true
        };

        axios
        .post("wementis/auth/users/", user)
        .then(() => this.email = "", this.emailAgain = "", this.password = "", this.isPasswordHidden = true)
        .then(() => {
          this.successAlert();
        })
        .catch(() => this.errorAlert());
      },
      successAlert() {
        this.$toast.open({
        message: "¡Registro completado con éxito!",
        type: "success",
        duration: 5000,
        dismissible: true,
        position: "top"
        });
      },
      errorAlert() {
        this.$toast.open({
        message: "Ha ocurrido un error al registrarse",
        type: "error",
        duration: 5000,
        dismissible: true,
        });
      },
    },
    computed: {
      showHidePassword() {
        if(this.isPasswordHidden) return "password";
        return "text";
      },
      isCorrectEmail() {
        if(!this.regEmail.test(this.email)) return false;
        return true;
      },
      isCorrectEmailAgain() {
        if(this.emailAgain === this.email && this.emailAgain !== "") return true;
        return false;
      },
      isCorrectPassword() {
        if(this.regPassword.test(this.password)) return true;
        return false;
      },
      isFormValidationCorrect() {
        if(this.isCorrectEmail && this.isCorrectEmailAgain && this.isCorrectPassword) return "btn btn-success";
        return "btn btn-success disabled";
      },
    }
}
</script>

<style scoped>
.bg-indigo {
  background-color: #6610f2;
}

.input-group i{
  position: absolute;
  right: 0.5rem;
  top: 0.3rem;
}

.pass i{
  cursor: pointer;
}

.pass i:hover {
  opacity: 70%;
}

.circle {
  width: .5em; 
  height: .5em;
}

.ms-fix {
  margin-left: 3.6rem;
}

.ms-fix2 {
  margin-left: 4.70rem;
}
</style>