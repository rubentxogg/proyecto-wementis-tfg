package com.rgg.wementis.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgg.wementis.entities.EstadoEntity;
import com.rgg.wementis.services.interfaces.IEstadoService;

@RestController
@RequestMapping("/v1")
public class EstadoController {

	@Autowired
	private IEstadoService estadoService;
	
	@GetMapping(value = "/estados")
	public Iterable<EstadoEntity> getEstados() {
		return estadoService.getEstados();
	}
	
	@GetMapping(value = "/estados/{id}")
	public Optional<EstadoEntity> getEstadoPorId(@PathVariable("id") Integer id) {
		return estadoService.getEstadoPorId(id);
	}
}
