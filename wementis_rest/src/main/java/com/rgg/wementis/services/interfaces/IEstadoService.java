package com.rgg.wementis.services.interfaces;

import java.util.Optional;

import com.rgg.wementis.entities.EstadoEntity;

public interface IEstadoService {
	
	public Iterable<EstadoEntity> getEstados();
	
	public Optional<EstadoEntity> getEstadoPorId(Integer id);
}
