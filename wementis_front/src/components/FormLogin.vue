<template>
  <div class="login form-signin rounded">
    <form action="http://localhost:8080/wementis/login" method="POST">
      <div class="form-floating mb-3">
        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="username">
        <label for="floatingInput">Correo</label>
      </div>

      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Contraseña" name="password">
        <label for="floatingPassword">Contraseña</label>
      </div>

      <button class="w-100 btn btn-lg btn-primary" type="submit">Entrar</button>

      <hr>

      <modal-registrarse />
    </form>
  </div>
</template>

<script>
import ModalRegistrarse from '@/components/ModalRegistrarse.vue';

export default {
    name: "FormLogin",
    components: {
      ModalRegistrarse
    }
};
</script>

<style scoped>
.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
  box-shadow: 0px 0px 5px 1px rgba(0, 0, 0, 0.39);
}

.form-signin .checkbox {
  font-weight: 400;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>
