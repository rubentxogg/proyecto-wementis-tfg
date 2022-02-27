package com.rgg.wementis.dao.interfaces;

import java.util.List;

import com.rgg.wementis.beans.Paciente;

public interface IPacienteDAO {

	public List<Paciente> obtenerPacientesPorCampos(String id, String nombre, String apellidos, String email,
			String fechaNacimiento, String genero, String fechaCreacion);
}
