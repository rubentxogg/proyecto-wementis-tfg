package com.rgg.wementis.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgg.wementis.beans.Cita;
import com.rgg.wementis.entities.CitaEntity;
import com.rgg.wementis.entities.EstadoEntity;
import com.rgg.wementis.repositories.CitaRepository;
import com.rgg.wementis.repositories.EstadoRepository;
import com.rgg.wementis.services.interfaces.ICitaService;

@Service
public class CitaServiceImpl implements ICitaService{

	@Autowired
	private CitaRepository citaRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
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
		EstadoEntity estadoActiva;
		
		if (estadoRepository.findById(1).isPresent()) {
			estadoActiva = estadoRepository.findById(1).get();
			cita.setEstado(estadoActiva);
		}
		
		citaRepository.save(cita);
	}

	@Override
	public void cancelarCita(Integer id) {
		EstadoEntity estadoCancelada;
		CitaEntity cita = citaRepository.findById(id).get();
		
		if (estadoRepository.findById(3).isPresent()) {
			estadoCancelada = estadoRepository.findById(3).get();
			cita.setEstado(estadoCancelada);
		}
		
		citaRepository.save(cita);
	}
}