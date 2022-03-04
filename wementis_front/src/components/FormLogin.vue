<template>
  <div class="login">
    <form action="http://localhost:8080/wementis/login" method="POST">
      <table>
        <tr>
          <td>User:</td>
          <td><input type="text" name="username" value="" /></td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><input type="password" name="password" /></td>
        </tr>
        <tr>
          <td><button type="submit">LOGIN</button></td>
        </tr>
      </table>
    </form>

    <a href="http://localhost:8080/wementis/logout">LOGOUT</a>
  </div>
</template>

<script>
export default {
    name: "Login"
};
</script>

<style></style>
