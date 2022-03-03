package com.rgg.wementis.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgg.wementis.entities.EstadoEntity;
import com.rgg.wementis.repositories.EstadoRepository;
import com.rgg.wementis.services.interfaces.IEstadoService;

@Service
public class EstadoServiceImpl implements IEstadoService{

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public Iterable<EstadoEntity> getEstados() {
		return estadoRepository.findAll();
	}

	@Override
	public Optional<EstadoEntity> getEstadoPorId(Integer id) {
		return estadoRepository.findById(id);
	}
}
