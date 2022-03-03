package com.rgg.wementis.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.rgg.wementis.beans.Cita;
import com.rgg.wementis.entities.CitaEntity;

public interface ICitaService {

	public Iterable<CitaEntity> getCitas();

	public Optional<CitaEntity> getCitaPorId(Integer id);

	public List<Cita> getCitasPorCampos(String id, String idPaciente, String idPsicologo, String idTarifa,
			String idEstado, String fecha, String hora, Integer cantidadHoras);
	
	public void actualizarCita(CitaEntity cita);
	
	public void insertarCita(CitaEntity cita);
	
	public void cancelarCita(Integer id);
	
	public void completarCita(Integer id);
}
