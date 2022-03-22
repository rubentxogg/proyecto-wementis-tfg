<template>
  <table class="table table-tarifas bg-primary align-middle">
    <thead>
      <tr class="text-light">
        <th>ID</th>
        <th>Nombre</th>
        <th>Precio/h</th>
        <th>Fecha Crea.</th>
      </tr>
    </thead>

    <tbody>
      <tr v-for="tarifa in tarifas" :key="tarifa.idTarifa || tarifa.id" class="table-light">
        <th>{{ tarifa.idTarifa || tarifa.id }}</th>
        <td>{{ tarifa.nombre }}</td>
        <td>{{ tarifa.precioHora }}</td>
        <td>{{ tarifa.fechaCreacion }}</td>
        <td>
          <modal-update-tarifa @updateTarifa="obtenerTarifa(tarifa)" :tarifa="tarifaToUpdate" @updateTabla="updateTabla"/>
        </td>
        <td>
          <modal-delete-tarifa @borradoTarifa="obtenerIdTarifa(tarifa.idTarifa || tarifa.id)" :id="id" @updateTabla="updateTabla"/>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import ModalUpdateTarifa from '@/components/tarifas/ModalUpdateTarifa.vue';
import ModalDeleteTarifa from '@/components/tarifas/ModalDeleteTarifa.vue';

export default {
  name: "TableTarifas",
  props: ["tarifas"],
  events: ["updateTabla"],
  data() {
    return {
      id: "",
      tarifaToUpdate: ""
    }
  },
  components: { 
    ModalUpdateTarifa,
    ModalDeleteTarifa
  },
  methods: {
    obtenerIdTarifa(id) {
      this.id = id;
    },
    obtenerTarifa(tarifa) {
      this.tarifaToUpdate = tarifa;
    },
    updateTabla() {
      this.$emit("updateTabla");
    }
  }
};
</script>

<style>
</style>
