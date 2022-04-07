<template>
   <form class="form-new-cita d-flex flex-wrap">
    <div class="input-group mb-3">
     <dropdown-pacientes @seleccionPaciente="pacienteSeleccionado"/>
     <input type="text" class="form-control" name="paciente" :value="idYNombrePaciente" readonly>
     <i v-if="isCorrectPaciente" class="bi bi-check2-circle fs-3 text-success"></i>
     <i v-else class="bi bi-backspace fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <dropdown-psicologos @seleccionPsicologo="psicologoSeleccionado"/>
     <input type="text" class="form-control" name="psicologo" :value="idYNombrePsicologo" readonly>
     <i v-if="isCorrectPsicologo" class="bi bi-check2-circle fs-3 text-success"></i>
     <i v-else class="bi bi-backspace fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <dropdown-tarifas @seleccionTarifa="tarifaSeleccionada"/>
     <input type="text" class="form-control" name="tarifa" :value="idYNombreTarifa" readonly>
     <i v-if="isCorrectTarifa" class="bi bi-check2-circle fs-3 text-success"></i>
     <i v-else class="bi bi-backspace fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Hora</span>
     <input type="time" class="form-control" name="hora" placeholder="hh:mm" v-model="hora">
     <i v-if="isCorrectHora" class="bi bi-check2-circle fs-3 text-success"></i>
     <i v-else class="bi bi-backspace fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Fecha</span>
     <input type="date" class="form-control" name="fecha" v-model="fecha">
     <i v-if="isCorrectFecha" class="bi bi-check2-circle fs-3 text-success"></i>
     <i v-else class="bi bi-backspace fs-3 text-danger"></i>
    </div>

    <div class="input-group mb-3">
     <span class="input-group-text">Duración/h</span>
     <input type="text" class="form-control" name="email" v-model="cantidadHoras">
     <i v-if="isCorrectCantidadHoras" class="bi bi-check2-circle fs-3 text-success"></i>
     <i v-else class="bi bi-backspace fs-3 text-danger"></i>
    </div>

     <div class="modal-footer w-100">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" @click="resetForm">Cancelar</button>
        <button type="button" :class="isFormValidationCorrect" data-bs-dismiss="modal" @click="anadirCita">Guardar</button>
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
      regFecha: /^[\d]{2}-[\d]{2}-[\d]{4}$/,
      regHora: /^[\d]{2}:[\d]{2}/,
      regNum: /^[\d]+$/
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
        cantidadHoras: this.cantidadHoras,
        activo: 1
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
    },
    resetForm() {
      this.paciente = "",
      this.psicologo = "",
      this.tarifa = "",
      this.fecha = "",
      this.hora = "",
      this.cantidadHoras = ""
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
    },
    isCorrectPaciente() {
      if(this.paciente === "") return false;
      return true;
    },
    isCorrectPsicologo() {
      if(this.psicologo === "") return false;
      return true;
    },
    isCorrectTarifa() {
      if(this.tarifa === "") return false;
      return true;
    },
    isCorrectHora() {
      if(!this.regHora.test(this.hora)) return false;
      return true;
    },
    isCorrectFecha() {
      if(this.regFecha.test(this.fecha) || this.fecha === "") return false;
      return true;
    },
    isCorrectCantidadHoras() {
      if(!this.regNum.test(this.cantidadHoras)) return false;
      return true;
    },
    isFormValidationCorrect() {
      if(this.isCorrectPaciente && this.isCorrectPsicologo && this.isCorrectTarifa
        && this.isCorrectHora && this.isCorrectFecha && this.isCorrectCantidadHoras) return "btn btn-success";
      return "btn btn-outline-success disabled";
    }
  }
}
</script>

<style scoped>
div i{
  position: absolute;
  right: 0.5rem;
}

input[type="date"] + i,
input[type="time"] + i {
  position: absolute;
  right: 2rem;
}
</style>