package com.rgg.wementis.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgg.wementis.beans.Paciente;
import com.rgg.wementis.entities.PacienteEntity;
import com.rgg.wementis.services.interfaces.IPacienteService;

@RestController
@RequestMapping("/v1")
public class PacienteController {
	
	@Autowired
	private IPacienteService pacienteService;

	@GetMapping(value = "/pacientes")
	public Iterable<PacienteEntity> getPacientes() {
		return pacienteService.getPacientes();
	}
	
	@GetMapping(value = "/pacientes/{id}")
	public Optional<PacienteEntity> getPacientePorId(@PathVariable("id") Integer id) {
		return pacienteService.getPacientePorId(id);
	}
	
	@GetMapping(value = "/pacientes", params = {"id", "nombre", "apellidos", "email", "telefono", "fechaNacimiento", "genero", "fechaCreacion"})
	public List<Paciente> getPacientesPorCampos(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "apellidos", required = false) String apellidos,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "telefono", required = false) String telefono,
			@RequestParam(value = "fechaNacimiento", required = false) String fechaNacimiento,
			@RequestParam(value = "genero", required = false) String genero,
			@RequestParam(value = "fechaCreacion", required = false) String fechaCreacion) {
		
		String fechaNac = fechaNacimiento.equals("") ? "0001-01-01" : fechaNacimiento;
		String fechaCrea = fechaCreacion.equals("") ? "0001-01-01" : fechaCreacion;
		
		return pacienteService.getPacientesPorCampos(id, nombre, apellidos, email, telefono, fechaNac, genero, fechaCrea);
	}
}
