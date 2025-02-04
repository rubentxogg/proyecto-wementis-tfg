package com.rgg.wementis.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgg.wementis.entities.CitaEntity;
import com.rgg.wementis.services.interfaces.ICitaService;

@RestController
@RequestMapping("/v1")
public class CitaController {

	@Autowired
	private ICitaService citaService;
	
	@GetMapping(value = "/citas")
	public Iterable<CitaEntity> getCitas() {
		return citaService.getCitas();
	}
	
	@GetMapping(value = "/citas/{id}")
	public Optional<CitaEntity> getCitaPorId(@PathVariable("id") Integer id) {
		return citaService.getCitaPorId(id);
	}
	
	@GetMapping(value = "/citas", params = {"id", "nombrePaciente", "nombrePsicologo", "nombreTarifa", "idEstado", "fecha", "hora", "cantidadHoras"})
	public List<CitaEntity> getCitasPorCampos(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "nombrePaciente", required = false) String nombrePaciente,
			@RequestParam(value = "nombrePsicologo", required = false) String nombrePsicologo,
			@RequestParam(value = "nombreTarifa", required = false) String nombreTarifa,
			@RequestParam(value = "idEstado", required = false) String idEstado, 
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "hora", required = false) String hora,
			@RequestParam(value = "cantidadHoras", required = false) String cantidadHoras){
		
		String fcha = fecha.equals("") ? "0001-01-01" : fecha;
		Integer cntHoras = cantidadHoras.equals("") ? 0 : Integer.parseInt(cantidadHoras);
		
		return citaService.getCitasPorCampos(id, nombrePaciente, nombrePsicologo, nombreTarifa, idEstado, fcha, hora, cntHoras);
	}
	
	@PutMapping(value = "/citas")
	public ResponseEntity<String> actualizarCita(@RequestBody CitaEntity cita) {
		citaService.actualizarCita(cita);
		
		return new ResponseEntity<>("Cita actualizada con éxito", HttpStatus.OK);
	}
	
	@PostMapping(value = "/citas")
	public ResponseEntity<String> insertarCita(@RequestBody CitaEntity cita) {
		citaService.insertarCita(cita);
		
		return new ResponseEntity<>("Cita insertada con éxito", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/citas/{id}")
	public ResponseEntity<String> cancelarCita(@PathVariable("id") Integer id) {
		citaService.cancelarCita(id);
		
		return new ResponseEntity<>("Cita cancelada con éxito", HttpStatus.OK);
	}
	
	@PutMapping(value = "/citas/{id}")
	public ResponseEntity<String> completarCita(@PathVariable("id") Integer id) {
		citaService.completarCita(id);
		
		return new ResponseEntity<>("Cita completada con éxito", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/citas/delete/{id}")
	public ResponseEntity<String> borrarCita(@PathVariable("id") Integer id) {
		citaService.borrarCita(id);
		
		return new ResponseEntity<>("Cita borrada con éxito", HttpStatus.OK);
	}
	
	@GetMapping(value = "/citas", params = {"fecha", "idEstado"})
	public List<CitaEntity> getCitasPorFechaYEstado(
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "idEstado", required = false) String idEstado) {
		return citaService.getCitasPorFechaYEstado(fecha, idEstado);
	}
}
