package com.rgg.wementis.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgg.wementis.beans.Tarifa;
import com.rgg.wementis.entities.TarifaEntity;
import com.rgg.wementis.repositories.TarifaRepository;
import com.rgg.wementis.services.interfaces.ITarifaService;
import com.rgg.wementis.utils.Utils;

@Service
public class TarifaServiceImpl implements ITarifaService{

	@Autowired
	private TarifaRepository tarifaRepository;
	
	@Override
	public Iterable<TarifaEntity> getTarifas() {
		return tarifaRepository.findByActivo(1);
	}

	@Override
	public Optional<TarifaEntity> getTarifaPorId(Integer id) {
		return tarifaRepository.findById(id);
	}

	@Override
	public List<Tarifa> getTarifaPorCampos(String id, String nombre, Double precioHora, String fechaCreacion) {
		return tarifaRepository.getTarifasPorCampos(id, nombre, precioHora, fechaCreacion);
	}

	@Override
	public void actualizarTarifa(TarifaEntity tarifa) {
		tarifaRepository.save(tarifa);
	}

	@Override
	public void insertarTarifa(TarifaEntity tarifa) {
		tarifa.setFechaCreacion(Utils.currentDate());
		tarifaRepository.save(tarifa);
	}

	@Override
	public void borrarTarifa(Integer id) {
		TarifaEntity tarifa = tarifaRepository.findById(id).get();
		tarifa.setActivo(0);
		tarifaRepository.save(tarifa);
	}
}
