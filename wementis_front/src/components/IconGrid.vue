<template>
   <div class="icon-grid container-fluid px-4 py-5" id="icon-grid">
    <h2 class="pb-2 border-bottom text-primary">Características</h2>

    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-3 g-4 py-5">
      <div class="col d-flex align-items-start">
        <i class="bi bi-speedometer2 me-1 ms-3 fs-4 text-muted"></i>
        <div>
          <h4 class="fw-bold mb-0">Dashboard</h4>
          <p>
            Accede al panel de control para ver un resumen de los últimos
            movimientos en la aplicación.
          </p>
        </div>
      </div>

      <div class="col d-flex align-items-start">
        <i class="bi bi-people me-1 ms-3 fs-4 text-muted"></i>
        <div>
          <h4 class="fw-bold mb-0">Pacientes</h4>
          <p>
            Añade, modifica, borra o realiza búsquedas de tus pacientes,
            no existen límites.
          </p>
        </div>
      </div>

      <div class="col d-flex align-items-start">
        <i class="bi bi-heart-pulse me-1 ms-3 fs-4 text-muted"></i>
        <div>
          <h4 class="fw-bold mb-0">Psicólogos</h4>
          <p>
            Gestiona tus citas asignándo a los pacientes un psicólogo que crearás 
            en esta sección. 
          </p>
        </div>
      </div>

      <div class="col d-flex align-items-start">
        <i class="bi bi-cash-coin me-1 ms-3 fs-4 text-muted"></i>
        <div>
          <h4 class="fw-bold mb-0">Tarifas</h4>
          <p>
            Crea tus propias tarifas con su precio/h 
            particular para posteriormente asignarla a la cita que desees.
          </p>
        </div>
      </div>

      <div class="col d-flex align-items-start">
        <i class="bi bi-calendar-week me-1 ms-3 fs-4 text-muted"></i>
        <div>
          <h4 class="fw-bold mb-0">Citas</h4>
          <p>
            Concierta citas con tus pacientes asignándoles una tarifa y un psicólogo.
            Podrás comprobar su estado en todo momento, editarlas, completarlas, cancelarlas...
          </p>
        </div>
      </div>

      <div class="col d-flex align-items-start">
        <i class="bi bi-file-earmark-pdf me-1 ms-3 fs-4 text-muted"></i>
        <div>
          <h4 class="fw-bold mb-0">Informe</h4>
          <p>
            Crea un informe personalizado para cada uno de tus pacientes y descárgalo en pdf.
          </p>
        </div>
      </div>
      
    </div>
  </div>
</template>

<script>
export default {
  name: "IconGrid"
}
</script>

<style scoped>
i {
  width: 1.75em;
  height: 1.75em;
  position: relative;
  bottom: 0.2rem;
}
</style>