<template>
  <div class="pacientes d-flex flex-column min-vh-100">
    <p class="text-muted fs-6">Pacientes</p>
    <div class="d-flex justify-content-between">
      <div class="accordion me-3" id="accordionPacientes">
        <div class="accordion-item">
        
          <button class="accordion-button accordion-header d-flex justify-content-between" id="headingOne" :class="buttonBrowserStyles" @click="openCloseBrowser" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
            <span>{{ buttonBrowserText }}</span> <i :class="browserIcon"></i> 
          </button>
          
          <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionPacientes">
            <div class="accordion-body">
              <browser-pacientes @buscarPacientes="getPacientesPorCampos"/>
            </div>
          </div>
          
        </div>
      </div>
      
      <modal-new-paciente @updateTabla="getPacientes('wementis/v1/pacientes/')"/>
    </div>
    
    <hr>
    <spinner v-if="isLoading"/>
    <table-pacientes v-else-if="pacientes.length > 0" :pacientes="pacientes" @updateTabla="getPacientes('wementis/v1/pacientes/')"/>
    <h2 v-else-if="isSearchPorCampos" class="text-center mt-5 text-muted">No se han encontrado pacientes con tus criterios de búsqueda.</h2>
    <h3 v-else class="text-center mt-5 text-muted">
      Actualmente no existen pacientes en la BBDD, <br><br>
      pulsa en el botón <span class="text-success">[<i class="bi bi-person-plus me-1"></i>Añadir]</span> situado en la parte superior derecha de la página para añadir tu primer paciente
    </h3>

    <footer-wementis />
  </div>
</template>

<script>
import TablePacientes from '@/components/pacientes/TablePacientes.vue';
import BrowserPacientes from '@/components/pacientes/BrowserPacientes.vue';
import ModalNewPaciente from '@/components/pacientes/ModalNewPaciente.vue';
import Spinner from '@/components/Spinner.vue';
import FooterWementis from '@/components/FooterWementis.vue';
import axios from 'axios';

export default {
    name: "Pacientes",
    components: {
      TablePacientes,
      BrowserPacientes,
      ModalNewPaciente,
      Spinner,
      FooterWementis
    },
    data() {
      return {
        pacientes: [],
        showBrowser: false,
        isLoading: false,
        isSearchPorCampos: false
      }
    },
    methods: {
      getPacientes(url) {
        this.isSearchPorCampos = false;
        this.isLoading = true;
        axios
          .get(url)
          .then((response) => this.pacientes = response.data)
          .catch((err) => console.error(err))
          .finally(() => this.isLoading = false);
      },
      getPacientesPorCampos(idPaciente, nombre, apellidos, telefono, email, fechaNacimiento, genero, fechaCreacion) {
        const params = {
          id: idPaciente,
          nombre: nombre,
          apellidos: apellidos,
          telefono: telefono,
          email: email,
          fechaNacimiento: fechaNacimiento,
          genero: genero,
          fechaCreacion: fechaCreacion
        }

        this.isSearchPorCampos = true;

        axios
          .get("wementis/v1/pacientes/", { params })
          .then((response) => this.pacientes = response.data)
          .catch((err) => console.error(err));
      },
      openCloseBrowser() {
        this.showBrowser = !this.showBrowser;
      }
    },
    computed: {
      buttonBrowserText() {
        if(!this.showBrowser) return "Abrir buscador";
        return "Cerrar buscador"
      },
      buttonBrowserStyles() {
        if(!this.showBrowser) return "bg-primary text-light p-1 ps-3";
        return "btn btn-outline-primary p-1 ps-3 me-4"
      },
      browserIcon() {
        if(!this.showBrowser) return "bi bi bi-arrows-expand ms-2 fs-5 me-2";
        return "bi bi bi-arrows-collapse fs-5"
      }
    },
    mounted() {
      this.getPacientes("wementis/v1/pacientes/");
    }
}
</script>

<style>

</style>