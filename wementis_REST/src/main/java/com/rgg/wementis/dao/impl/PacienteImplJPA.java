package com.rgg.wementis.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgg.wementis.beans.Paciente;
import com.rgg.wementis.dao.interfaces.IPacienteDAO;
import com.rgg.wementis.repositories.PacienteRepository;

@Component("pacientejpa")
public class PacienteImplJPA implements IPacienteDAO{

	@Autowired
	PacienteRepository pacienteRepository;
	
	@Override
	public List<Paciente> obtenerPacientesPorCampos(String id, String nombre, String apellidos, String email,
			String fechaNacimiento, String genero, String fechaCreacion) {
		// TODO
		return null;
	}
}
