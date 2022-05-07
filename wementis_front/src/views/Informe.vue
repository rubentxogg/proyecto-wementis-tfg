<template>
  <div class="informe d-flex flex-column min-vh-100">
    <p class="text-muted fs-6">Informe</p>

    <div class="container border rounded">
      <div class="d-flex justify-content-between mt-3">
        <h4>INFORME PSICOLÓGICO CLÍNICO</h4>

        <div class="d-flex">
          <h4>Fecha</h4>
          <h4>:</h4>
          <input type="date" class="form-control ms-2" v-model="fechaInforme">
        </div>
      </div>

      <hr>

      <div class="d-flex justify-content-between mb-2">
        <h5>I.DATOS DE FILIACIÓN</h5>
        <dropdown-pacientes @seleccionPaciente="pacienteSeleccionado"/>
      </div>

      <div class="row">
        <p class="fw-bold col-4">Nombre y apellidos</p>
        <p class="fw-bold col-1">:</p>
        <p class="col">{{ nombreApellidosPaciente }}</p>
      </div>

      <div class="row">
        <p class="fw-bold col-4">Fecha de nacimiento</p>
        <p class="fw-bold col-1">:</p>
        <p class="col">{{ paciente.fechaNacimiento }}</p>
      </div>

      <div class="row">
        <p class="fw-bold col-4">Sexo</p>
        <p class="fw-bold col-1">:</p>
        <p class="col">{{ generoPaciente }}</p>
      </div>

      <div class="row">
        <p class="fw-bold col-4">Referente</p>
        <p class="fw-bold col-1">:</p>
        <p class="col">A petición del propio examinado.</p>
      </div>

      <div class="row">
        <p class="fw-bold col-4">Motivo de evaluación</p>
        <p class="fw-bold col-1">:</p>
        <p class="col">Determinar la salud mental(área emocional y área de personalidad) con la finalidad de descartar la presencia de algún trastorno de personalidad(moderados a graves) o trastornos psiquiátricos.</p>
      </div>
      
      <div class="row">
        <p class="fw-bold col-4" >Examinador (psicólogo)</p>
        <p class="fw-bold col-1">:</p>
        <p class="col">{{ psicologo.nombre }}</p>
        <dropdown-psicologos class="col-2 me-sm-5 me-md-5 me-lg-5 me-xl-1" @seleccionPsicologo="psicologoSeleccionado"/>
      </div>
      
      <div class="mt-2 mb-1">
        <h5>II.MOTIVO DE CONSULTA</h5>
        <textarea class="m-auto form-control" name="motivo" cols="35" rows="3" v-model="motivoConsulta"></textarea>
      </div>

      <div class="mb-1">
        <h5>III.OBSERVACIONES GENERALES</h5>
        <textarea class="m-auto form-control" name="observaciones" cols="35" rows="3" v-model="observacionesGenerales"></textarea>
      </div>

      <div class="mb-1">
        <h5>IV.ANÁLISIS DE LOS RESULTADOS</h5>
        <textarea class="m-auto form-control" name="analisisResultados" cols="35" rows="3" v-model="analisisResultados"></textarea>
      </div>

      <div class="mb-1">
        <h5>V.CONCLUSIONES</h5>
        <textarea class="m-auto form-control" name="conclusiones" cols="35" rows="3" v-model="conclusiones"></textarea>
      </div>

      <div class="mb-1">
        <h5>VI.RECOMENDACIONES</h5>
        <textarea class="m-auto form-control" name="recomendaciones" cols="35" rows="3" v-model="recomendaciones"></textarea>
      </div>

      <hr>

      <div class="d-flex mb-3 justify-content-center">
        <button type="button" class="btn btn-danger me-3" @click="resetFields"><i class="bi bi-arrow-clockwise me-1"></i>Restablecer</button>
        <a :href="getPDF" :class="botonDescargarStyles" target="_blank"><i class="bi bi-download me-1"></i>Descargar PDF</a>
      </div>
    </div>
  
    <footer-wementis />
  </div>
</template>

<script>
import DropdownPacientes from '@/components/citas/DropdownPacientes.vue';
import DropdownPsicologos from '@/components/citas/DropdownPsicologos.vue';
import FooterWementis from '@/components/FooterWementis.vue';

export default {
    name: "Informe",
    components: {
      DropdownPacientes,
      DropdownPsicologos,
      FooterWementis
    },
    data() {
      return {
        fechaInforme: "",
        paciente: "",
        psicologo: "",
        motivoConsulta: "",
        observacionesGenerales: "",
        analisisResultados: "",
        conclusiones: "",
        recomendaciones: ""
      }
    },
    methods: {
      pacienteSeleccionado(paciente) {
        this.paciente = paciente;
      },
      psicologoSeleccionado(psicologo) {
        this.psicologo = psicologo;
      },
      resetFields() {
        this.fechaInforme = "",
        this.paciente = "",
        this.psicologo = "",
        this.motivoConsulta = "",
        this.observacionesGenerales = "",
        this.analisisResultados = "",
        this.conclusiones = "",
        this.recomendaciones = ""
      },
      downloadReadyAlert() { //TODO
        this.$toast.open({
        message: "PDF listo para descargar",
        type: "info",
        duration: 0,
        dismissible: false,
        queue: true,
        });
      },
    },
    computed: {
      nombreApellidosPaciente() {
        if(this.paciente === "") return "";
        return `${this.paciente.nombre} ${this.paciente.apellidos}`;
      },
      generoPaciente() {
        if(this.paciente.genero === "F") return "Femenino";
        if(this.paciente.genero === "M") return "Masculino";
        return "";
      },
      getPDF() {
        return `wementis/v1/pdf/generate?fechaInforme=${this.fechaInforme}&paciente=${this.nombreApellidosPaciente}&fechaNacimiento=${this.paciente.fechaNacimiento}&genero=${this.generoPaciente}&psicologo=${this.psicologo.nombre}&motivoConsulta=${this.motivoConsulta}&observacionesGenerales=${this.observacionesGenerales}&analisisResultados=${this.analisisResultados}&conclusiones=${this.conclusiones}&recomendaciones=${this.recomendaciones}`;
      },
      isReportReady() {
        if(this.fechaInforme === "" || this.paciente === "" || this.psicologo === "" || this.motivoConsulta === "" || this.observacionesGenerales === "" ||
            this.analisisResultados === "" || this.conclusiones === "" || this.recomendaciones === "") return false;
        return true;
      },
      botonDescargarStyles() {
        if(!this.isReportReady) return "btn btn-success disabled";
        return "btn btn-success";
      }
    },
}
</script>

<style scoped>
textarea {
  border-radius: 10px;
}

.v-toast__item {
  display: none;
}
</style>