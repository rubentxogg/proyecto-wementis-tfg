<template>
  <div class="browser-citas-por-fecha-y-estado mb-2 m-auto">
    <hr class="text-primary">
    <div class="d-flex mb-2">
        <span class="me-1 align-self-center fs-5"><i class="bi bi-calendar-event me-2"></i>Selección de fecha</span>
        <input type="date" class="text-center m-auto border-0" v-model="fecha" @change="resetSelectedButtons" title="Elegir fecha">
    </div>
    
    <div class="d-flex">
        <span class="me-1 align-self-center fs-5"><i class="bi bi-activity me-2"></i>Selección de estado: </span>
        <button type="button" :class="buttonActivasSelectedStyles" @click="buscarCitas(1)" :disabled="isFechaEmpty">Activas</button>
        <button type="button" :class="buttonCompletadasSelectedStyles" @click="buscarCitas(2)" :disabled="isFechaEmpty">Completas</button>
        <button type="button" :class="buttonCanceladasSelectedStyles" @click="buscarCitas(3)" :disabled="isFechaEmpty">Canceladas</button>
    </div>

    <hr class="text-primary">
    <h3 class="text-center mt-3 p-2 m-auto" v-if="!isFechaEmpty && (isButtonActivasSelected || isButtonCanceladasSelected 
        || isButtonCompletadasSelected)">{{ displayFechaEnNombres }}</h3>
  </div>
</template>

<script>
export default {
    name: "BrowserCitasPorFechaYIdEstado.vue",
    events: ["buscarCitas"],
    methods: {
        buscarCitas(idEstado) {
            if(idEstado === 1) {
                this.isButtonCompletadasSelected = false;
                this.isButtonCanceladasSelected = false;
                this.isButtonActivasSelected = true;
            } else if(idEstado === 2) {
                this.isButtonCompletadasSelected = true;
                this.isButtonCanceladasSelected = false;
                this.isButtonActivasSelected = false;
            } else if(idEstado === 3) {
                this.isButtonCompletadasSelected = false;
                this.isButtonCanceladasSelected = true;
                this.isButtonActivasSelected = false;
            }

            this.$emit("buscarCitas", this.fecha, idEstado);
        },
        resetSelectedButtons() {
            this.isButtonCompletadasSelected = false;
            this.isButtonCanceladasSelected = false;
            this.isButtonActivasSelected = false;
        },
        capitalizeFirstLetter(string) {
            return string.charAt(0).toUpperCase() + string.slice(1);
        }
    },
    data() {
        return {
            fecha: "",
            isButtonActivasSelected: false,
            isButtonCompletadasSelected: false,
            isButtonCanceladasSelected: false
        }
    },
    computed: {
        isFechaEmpty() {
            if(this.fecha === "") return true;
            return false;
        },
        buttonActivasSelectedStyles() {
            if(this.isButtonActivasSelected) return "btn btn-outline-warning active m-2";
            return "btn btn-outline-warning m-2";
        },
        buttonCompletadasSelectedStyles() {
            if(this.isButtonCompletadasSelected) return "btn btn-outline-success active m-2";
            return "btn btn-outline-success m-2";
        },
        buttonCanceladasSelectedStyles() {
            if(this.isButtonCanceladasSelected) return "btn btn-outline-danger active m-2";
            return "btn btn-outline-danger m-2";
        },
        displayFechaEnNombres() {
            const options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
            let date = new Date(this.fecha);
            return this.capitalizeFirstLetter(date.toLocaleDateString('es-ES', options));
        }
    }
}
</script>

<style scoped>
input:focus {
  transform: scale(1.2, 1.2);
  transition: 0.1s;
}
</style>