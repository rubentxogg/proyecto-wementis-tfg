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

import com.rgg.wementis.beans.Tarifa;
import com.rgg.wementis.entities.TarifaEntity;
import com.rgg.wementis.services.interfaces.ITarifaService;

@RestController
@RequestMapping("/v1")
public class TarifaController {

	@Autowired
	private ITarifaService tarifaService;
	
	@GetMapping(value = "/tarifas")
	public Iterable<TarifaEntity> getTarifas() {
		return tarifaService.getTarifas();
	}
	
	@GetMapping(value = "/tarifas/{id}")
	public Optional<TarifaEntity> getTarifaPorId(@PathVariable("id") Integer id) {
		return tarifaService.getTarifaPorId(id);
	}
	
	@GetMapping(value = "/tarifas", params = {"id", "nombre", "precioHora", "fechaCreacion"})
	public List<Tarifa> getTarifasPorCampos(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "precioHora", required = false) String precioHora,
			@RequestParam(value = "fechaCreacion", required = false) String fechaCreacion) {
		
		String fechaCrea = fechaCreacion.equals("") ? "0001-01-01" : fechaCreacion;
		Double precioHra = precioHora.equals("") ? 0 : Double.parseDouble(precioHora);
		
		return tarifaService.getTarifaPorCampos(id, nombre, precioHra, fechaCrea);
	}
	
	@PutMapping(value = "/tarifas")
	public ResponseEntity<String> actualizarTarifa(@RequestBody TarifaEntity tarifa) {
		tarifaService.actualizarTarifa(tarifa);
		
		return new ResponseEntity<>("Tarifa actualizada con éxito", HttpStatus.OK);
	}
	
	@PostMapping(value = "/tarifas")
	public ResponseEntity<String> insertarTarifa(@RequestBody TarifaEntity tarifa) {
		tarifaService.insertarTarifa(tarifa);
		
		return new ResponseEntity<>("Tarifa insertada con éxito", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/tarifas/{id}")
	public ResponseEntity<String> borrarTarifa(@PathVariable("id") Integer id) {
		tarifaService.borrarTarifa(id);
		
		return new ResponseEntity<>("Tarifa borrada con éxito", HttpStatus.OK);
	}
}
