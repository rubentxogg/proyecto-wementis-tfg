<template>
  <div>
    <h1>Testeo</h1>
    <p>{{ datos[0] }}</p>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Testeo",
  data() {
    return {
      datos: [],
    };
  },
  mounted() {
    axios
      .get("http://localhost:8080/wementis/v1/pacientes/")
      .then((response) => (this.datos = response.data))
      .catch((error) => console.log(error))
  },
};
</script>

<style></style>
