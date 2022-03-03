<template>
  <div class="container-fluid">
    <div id="nav">
      <router-link to="/"><i class="bi bi-house"></i>Home</router-link> |
      <router-link to="/about">About</router-link>
    </div>
    <router-view />

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
          <td><input name="submit" type="submit" value="submit" /></td>
        </tr>
      </table>
    </form>

    <a href="http://localhost:8080/wementis/logout">LOGOUT</a>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
