<template>
   <form class="form-new-cita d-flex flex-wrap">
    <div class="input-group mb-3">
     <dropdown-pacientes @seleccionPaciente="pacienteSeleccionado"/>
     <input type="text" class="form-control" name="paciente" :value="idYNombrePaciente" readonly>
    </div>

    <div class="input-group mb-3">
     <dropdown-psicologos @seleccionPsicologo="psicologoSeleccionado"/>
     <input type="text" class="form-control" name="psicologo" :value="idYNombrePsicologo" readonly>
    </div>

    <div class="input-group mb-3">
     <dropdown-tarifas @seleccionTarifa="tarifaSeleccionada"/>
     <input type="text" class="form-control" name="tarifa" :value="idYNombreTarifa" readonly>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Hora</span>
     <input type="text" class="form-control" name="hora" placeholder="hh:mm" v-model="hora">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Fecha</span>
     <input type="date" class="form-control" name="fecha" v-model="fecha">
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Cantidad/h</span>
     <input type="number" class="form-control" name="email" v-model="cantidadHoras">
    </div>

     <div class="modal-footer w-100">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-success" data-bs-dismiss="modal" @click="anadirCita">Guardar</button>
     </div>
  </form>
</template>

<script>
import DropdownPacientes from '@/components/citas/DropdownPacientes.vue';
import DropdownPsicologos from '@/components/citas/DropdownPsicologos.vue';
import DropdownTarifas from '@/components/citas/DropdownTarifas.vue';
import axios from 'axios';

export default {
  name: "FormNewCita",
  events: ["updateTabla"],
  components: {
      DropdownPacientes,
      DropdownPsicologos,
      DropdownTarifas
  },
  data() {
    return {
      paciente: "",
      psicologo: "",
      tarifa: "",
      fecha: "",
      hora: "",
      cantidadHoras: "",
    };
  },
  methods: {
    anadirCita() {
      const cita = {
        paciente: this.paciente,
        psicologo: this.psicologo,
        tarifa: this.tarifa,
        fecha: this.fecha,
        hora: this.hora,
        cantidadHoras: this.cantidadHoras
      }
      
      axios
        .post("wementis/v1/citas/", cita)
        .then(() => this.paciente = "", this.psicologo = "", this.tarifa = "", this.fecha = "", this.hora = "", this.cantidadHoras = "")
        .then(() => this.$emit("updateTabla"))
        .catch((err) => console.error(err));
    },
    pacienteSeleccionado(paciente) {
      this.paciente = paciente;
    },
    psicologoSeleccionado(psicologo) {
      this.psicologo = psicologo;
    },
    tarifaSeleccionada(tarifa) {
      this.tarifa = tarifa;
    }
  },
  computed: {
    idYNombrePaciente() {
      if(this.paciente !== "") return `${this.paciente.id || this.paciente.idPaciente} - ${this.paciente.nombre}`;
      return ""; 
    },
    idYNombrePsicologo() {
      if(this.psicologo !== "") return `${this.psicologo.id || this.psicologo.idPsicologo} - ${this.psicologo.nombre}`;
      return ""; 
    },
    idYNombreTarifa() {
      if(this.tarifa !== "") return `${this.tarifa.id || this.tarifa.idTarifa} - ${this.tarifa.nombre}`;
      return ""; 
    }
  }
}
</script>

<style>

</style>