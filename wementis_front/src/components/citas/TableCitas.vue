<template>
  <table class="table table-citas bg-primary">
    <thead>
      <tr class="text-light">
        <th>ID</th>
        <th>Paciente</th>
        <th>Psicólogo</th>
        <th>Tarifa</th>
        <th>Fecha</th>
        <th>Hora</th>
        <th>Cantidad/h</th>
        <th>Estado</th>
      </tr>
    </thead>

    <tbody>
      <tr v-for="cita in citas" :key="cita.id" class="table-light">
        <th>{{ cita.id }}</th>
        <td>{{ cita.paciente.nombre }}</td>
        <td>{{ cita.psicologo.nombre }}</td>
        <td>{{ cita.tarifa.nombre }}</td>
        <td>{{ cita.fecha }}</td>
        <td>{{ cita.hora.substring(0,5) }}</td>
        <td>{{ cita.cantidadHoras }}</td>
        <td>
            <span :class="circuloEstado(cita.estado.idEstado)"></span>{{ cita.estado.nombre }}
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "TableCitas",
  props: ["citas"],
  events: ["updateTabla"],
  data() {
    return {
      id: "",
      citaToUpdate: ""
    }
  },
  methods: {
    obtenerIdCita(id) {
      this.id = id;
    },
    obtenerCita(cita) {
      this.citaToUpdate = cita;
    },
    updateTabla() {
      this.$emit("updateTabla");
    },
    circuloEstado(estadoId) {
      if(estadoId === 1) return "d-inline-block bg-warning rounded-circle me-1";
      if(estadoId === 2) return "d-inline-block bg-success rounded-circle me-1";
      if(estadoId === 3) return "d-inline-block bg-danger rounded-circle me-1";
    }
  },
};
</script>

<style scoped>
span {
  width: .5em; 
  height: .5em;
}
</style>
