package com.rgg.wementis.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgg.wementis.beans.Paciente;
import com.rgg.wementis.dao.interfaces.IPacienteDAO;
import com.rgg.wementis.entities.PacienteEntity;
import com.rgg.wementis.servicios.interfaces.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	IPacienteDAO pacienteDAO;

	@Override
	public Iterable<PacienteEntity> getPacientes() {
		return pacienteDAO.getPacientes();
	}

	@Override
	public Optional<PacienteEntity> getPacientePorId(Integer id) {
		return pacienteDAO.getPacientePorId(id);
	}
	
	@Override
	public List<Paciente> getPacientesPorCampos(String id, String nombre, String apellidos, String email,
			String telefono, String fechaNacimiento, String genero, String fechaCreacion) {
		return pacienteDAO.getPacientesPorCampos(id, nombre, apellidos, email, telefono, fechaNacimiento, genero, fechaCreacion);
	}
}
