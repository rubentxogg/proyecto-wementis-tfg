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

import com.rgg.wementis.beans.Psicologo;
import com.rgg.wementis.entities.PsicologoEntity;
import com.rgg.wementis.services.interfaces.IPsicologoService;

@RestController
@RequestMapping("/v1")
public class PsicologoController {
	
	@Autowired
	private IPsicologoService psicologoService;
	
	@GetMapping(value = "/psicologos")
	public Iterable<PsicologoEntity> getPsicologos() {
		return psicologoService.getPsicologos();
	}
	
	@GetMapping(value = "/psicologos/{id}")
	public Optional<PsicologoEntity> getPsicologoPorId(@PathVariable("id") Integer id) {
		return psicologoService.getPsicologoPorId(id);
	}
	
	@GetMapping(value = "/psicologos", params = {"id", "nombre", "apellidos", "email", "telefono", "fechaCreacion"})
	public List<Psicologo> getPsicologosPorCampos(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "apellidos", required = false) String apellidos,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "telefono", required = false) String telefono,
			@RequestParam(value = "fechaCreacion", required = false) String fechaCreacion) {
		
		String fechaCrea = fechaCreacion.equals("") ? "0001-01-01" : fechaCreacion;
		
		return psicologoService.getPsicologosPorCampos(id, nombre, apellidos, email, telefono, fechaCrea);
	}
	
	@PutMapping(value = "/psicologos")
	public ResponseEntity<String> actualizarPsicologo(@RequestBody PsicologoEntity psicologo) {
		psicologoService.actualizarPsicologo(psicologo);
		
		return new ResponseEntity<>("Psicologo actualizado con éxito", HttpStatus.OK);
	}
	
	@PostMapping(value = "/psicologos")
	public ResponseEntity<String> insertarPsicologo(@RequestBody PsicologoEntity psicologo) {
		psicologoService.insertarPsicologo(psicologo);
		
		return new ResponseEntity<>("Psicologo insertado con éxito", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/psicologos/{id}")
	public ResponseEntity<String> borrarPsicologo(@PathVariable("id") Integer id) {
		psicologoService.borrarPsicologo(id);
		
		return new ResponseEntity<>("Psicologo borrado con éxito", HttpStatus.OK);
	}
}
