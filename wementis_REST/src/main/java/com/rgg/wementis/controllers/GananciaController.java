package com.rgg.wementis.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rgg.wementis.beans.Ganancia;
import com.rgg.wementis.entities.GananciaEntity;
import com.rgg.wementis.services.interfaces.IGananciaService;

@RestController
@RequestMapping("/v1")
public class GananciaController {

	@Autowired
	private IGananciaService gananciaService;
	
	@GetMapping(value = "/ganancias")
	public Iterable<GananciaEntity> getGanancias() {
		return gananciaService.getGanancias();
	}
	
	@GetMapping(value = "/ganancias/{id}")
	public Optional<GananciaEntity> getGananciaPorId(@PathVariable("id") Integer id) {
		return gananciaService.getGananciaPorId(id);
	}
	
	@GetMapping(value = "/ganancias", params = {"id", "idCita", "cantidad", "fechaCreacion"})
	public List<Ganancia> getGananciasPorCampos(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "idCita", required = false) String idCita,
			@RequestParam(value = "cantidad", required = false) String cantidad,
			@RequestParam(value = "fechaCreacion", required = false) String fechaCreacion){
		
		Double cntidad = cantidad.equals("") ? 0 : Double.parseDouble(cantidad);
		String fechaCrea = fechaCreacion.equals("") ? "0001-01-01" : fechaCreacion;
		
		return gananciaService.getGananciasPorCampos(id, idCita, cntidad, fechaCrea);
	}
	
	@PostMapping(value = "/ganancias")
	public ResponseEntity<String> insertarGanancia(@RequestBody GananciaEntity ganancia) {
		gananciaService.insertarGanancia(ganancia);
		
		return new ResponseEntity<>("Ganancia insertada con éxito", HttpStatus.OK);
	}
}
