package com.rgg.wementis.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgg.wementis.beans.Cita;
import com.rgg.wementis.dao.interfaces.ICitasDAO;
import com.rgg.wementis.repositories.CitaRepository;

@Component("citajpa")
public class CitaImplJPA implements ICitasDAO {

	@Autowired
	CitaRepository citaRepository;

	@Override
	public List<Cita> obtenerPorCamposSegunActivaOCancelada(String id, String nombrePaciente, String nombrePsicologo,
			String nombreTarifa, String nombreEstado, String fecha, String cantidadHoras, String activa) {
		// TODO 
		return null;
	}

	@Override
	public Integer insertarCita(String idPaciente, String idPsicologo, String idTarifa, String idEstado, String fecha,
			String cantidadHoras) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarCita(String idPaciente, String idPsicologo, String idTarifa, String idEstado, String fecha,
			String cantidadHoras) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarCita(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
