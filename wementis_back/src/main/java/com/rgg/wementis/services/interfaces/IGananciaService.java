package com.rgg.wementis.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.rgg.wementis.beans.Ganancia;
import com.rgg.wementis.entities.GananciaEntity;

public interface IGananciaService {

	public Iterable<GananciaEntity> getGanancias();
	
	public Optional<GananciaEntity> getGananciaPorId(Integer id);
	
	public List<Ganancia> getGananciasPorCampos(String id, String idCita, Double cantidad, String fechaCreacion);
	
	public void insertarGanancia(GananciaEntity ganancia);
}
