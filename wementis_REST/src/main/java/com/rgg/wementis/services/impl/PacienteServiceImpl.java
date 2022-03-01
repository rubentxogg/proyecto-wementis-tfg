package com.rgg.wementis.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgg.wementis.beans.Paciente;
import com.rgg.wementis.entities.PacienteEntity;
import com.rgg.wementis.repositories.PacienteRepository;
import com.rgg.wementis.services.interfaces.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	PacienteRepository pacienteRepository;

	@Override
	public Iterable<PacienteEntity> getPacientes() {
		return pacienteRepository.findAll();
	}

	@Override
	public Optional<PacienteEntity> getPacientePorId(Integer id) {
		return pacienteRepository.findById(id);
	}
	
	@Override
	public List<Paciente> getPacientesPorCampos(String id, String nombre, String apellidos, String email,
			String telefono, String fechaNacimiento, String genero, String fechaCreacion) {
		return pacienteRepository.getPacientesPorCampos(id, nombre, apellidos, email, telefono, fechaNacimiento, genero, fechaCreacion);
	}

	@Override
	public void actualizarPaciente(PacienteEntity paciente) {
		pacienteRepository.save(paciente);
	}

	@Override
	public void insertarPaciente(PacienteEntity paciente) {
		pacienteRepository.save(paciente);
	}

	@Override
	public void borrarPaciente(Integer id) {
		pacienteRepository.deleteById(id);
	}
}
