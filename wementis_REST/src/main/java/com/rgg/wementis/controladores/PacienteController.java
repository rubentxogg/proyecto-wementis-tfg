package com.rgg.wementis.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgg.wementis.entities.PacienteEntity;
import com.rgg.wementis.repositories.PacienteRepository;

@RestController
@RequestMapping("/v1")
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;

	@GetMapping(value = "/pacientes")
	public Iterable<PacienteEntity> obtenerPacientes() {
		return pacienteRepository.findAll();
	}
}
