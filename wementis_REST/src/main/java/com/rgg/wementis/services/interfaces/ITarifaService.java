package com.rgg.wementis.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.rgg.wementis.beans.Tarifa;
import com.rgg.wementis.entities.TarifaEntity;

public interface ITarifaService {

	public Iterable<TarifaEntity> getTarifas();
	
	public Optional<TarifaEntity> getTarifaPorId(Integer id);
	
	public List<Tarifa> getTarifaPorCampos(String id, String nombre, Double precioHora, String fechaCreacion);
	
	public void actualizarTarifa(TarifaEntity tarifa);
	
	public void insertarTarifa(TarifaEntity tarifa);
	
	public void borrarTarifa(Integer id);
}
