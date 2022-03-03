package com.rgg.wementis.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgg.wementis.beans.Ganancia;
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

	@Override
	public Optional<GananciaEntity> getGananciaPorId(Integer id) {
		return gananciaRepository.findById(id);
	}

	@Override
	public List<Ganancia> getGananciasPorCampos(String id, String idCita, Double cantidad, String fechaCreacion) {
		return gananciaRepository.getGananciasPorCampos(id, idCita, cantidad, fechaCreacion);
	}

	@Override
	public void insertarGanancia(GananciaEntity ganancia) {
		gananciaRepository.save(ganancia);
	}

	
}
