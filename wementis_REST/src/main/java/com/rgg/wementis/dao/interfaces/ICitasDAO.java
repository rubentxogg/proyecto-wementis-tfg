package com.rgg.wementis.dao.interfaces;

import java.util.List;

import com.rgg.wementis.beans.Cita;

public interface ICitasDAO {

	public List<Cita> obtenerPorCamposSegunActivaOCancelada(String id, String nombrePaciente, String nombrePsicologo,
			String nombreTarifa, String nombreEstado, String fecha, String cantidadHoras, String activa);

	public Integer insertarCita(String idPaciente, String idPsicologo, String idTarifa, String idEstado, String fecha,
			String cantidadHoras);
	
	public Integer actualizarCita(String idPaciente, String idPsicologo, String idTarifa, String idEstado, String fecha,
			String cantidadHoras);
	
	public Integer borrarCita(String id);
}
