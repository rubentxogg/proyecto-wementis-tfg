<template>
  <div class="dashboard">
    <h1>Dashboard</h1>
    <p>{{ datos[0] }}</p>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Dashboard",
  data() {
    return {
      datos: [],
    };
  },
  mounted() {
    axios
      .get("wementis/v1/pacientes/")
      .then((response) => (this.datos = response.data))
      .catch((error) => console.log(error))
  },
};
</script>

<style></style>
