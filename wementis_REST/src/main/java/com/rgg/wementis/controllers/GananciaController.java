package com.rgg.wementis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
