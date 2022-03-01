package com.rgg.wementis.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgg.wementis.beans.Cita;
import com.rgg.wementis.entities.CitaEntity;
import com.rgg.wementis.repositories.CitaRepository;
import com.rgg.wementis.services.interfaces.ICitaService;

@Service
public class CitaServiceImpl implements ICitaService{

	@Autowired
	private CitaRepository citaRepository;
	
	@Override
	public Iterable<CitaEntity> getCitas() {
		return citaRepository.findAll();
	}

	@Override
	public Optional<CitaEntity> getCitaPorId(Integer id) {
		return citaRepository.findById(id);
	}

	@Override
	public List<Cita> getCitasPorCampos(String id, String idPaciente, String idPsicologo, String idTarifa,
			String idEstado, String fecha, Integer cantidadHoras) {
		return citaRepository.getCitasPorCampos(id, idPaciente, idPsicologo, idTarifa, idEstado, fecha, cantidadHoras);
	}

	@Override
	public void actualizarCita(CitaEntity cita) {
		citaRepository.save(cita);
	}

	@Override
	public void insertarCita(CitaEntity cita) {
		citaRepository.save(cita);
	}

	@Override
	public void borrarCita(Integer id) {
		citaRepository.deleteById(id);
	}

}
