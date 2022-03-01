package com.rgg.wementis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgg.wementis.entities.GananciaEntity;
import com.rgg.wementis.repositories.GananciaRepository;
import com.rgg.wementis.services.interfaces.IGananciaService;

@Service
public class GanaciaServiceImpl implements IGananciaService{

	@Autowired
	private GananciaRepository gananciaRepository;
	
	@Override
	public Iterable<GananciaEntity> getGanancias() {
		return gananciaRepository.findAll();
	}

	
}
