<template>
  <div class="browser-citas-por-fecha-y-estado">
    <input type="date" v-model="fecha" @change="resetSelectedButtons">
    <button type="button" :class="buttonActivasSelectedStyles" @click="buscarCitas(1)" :disabled="isFechaEmpty">Activas</button>
    <button type="button" :class="buttonCompletadasSelectedStyles" @click="buscarCitas(2)" :disabled="isFechaEmpty">Completas</button>
    <button type="button" :class="buttonCanceladasSelectedStyles" @click="buscarCitas(3)" :disabled="isFechaEmpty">Canceladas</button>

    <h4 class="text-center mt-3">Lunes, Febrero, 2022</h4>
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
            if(this.isButtonActivasSelected) return "btn btn-outline-warning active";
            return "btn btn-outline-warning";
        },
        buttonCompletadasSelectedStyles() {
            if(this.isButtonCompletadasSelected) return "btn btn-outline-success active";
            return "btn btn-outline-success";
        },
        buttonCanceladasSelectedStyles() {
            if(this.isButtonCanceladasSelected) return "btn btn-outline-danger active";
            return "btn btn-outline-danger";
        }
    }
}
</script>

<style>

</style>