package com.rgg.wementis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rgg.wementis.beans.Cita;
import com.rgg.wementis.entities.CitaEntity;

@Repository
public interface CitaRepository extends CrudRepository<CitaEntity, Integer>{
	
	@Query(value = "SELECT new com.rgg.wementis.beans.Cita (id, paciente.idPaciente, psicologo.idPsicologo, tarifa.idTarifa, estado.idEstado, fecha, hora, cantidadHoras, activo) "
			+ "FROM com.rgg.wementis.entities.CitaEntity "
			+ "WHERE (id LIKE CONCAT('%', :id, '%') OR :id is NULL) "
			+ "AND paciente.nombre LIKE CONCAT('%', :nombrePaciente, '%') "
			+ "AND psicologo.nombre LIKE CONCAT('%', :nombrePsicologo, '%') "
			+ "AND tarifa.nombre LIKE CONCAT('%', :nombreTarifa, '%') "
			+ "AND (estado.idEstado LIKE CONCAT('%', :idEstado, '%') OR :idEstado is NULL) "
			+ "AND fecha >= :fecha "
			+ "AND hora >= :hora "
			+ "AND cantidadHoras >= :cantidadHoras "
			+ "AND activo = 1")
	public List<Cita> getCitasPorCampos(
			@Param("id") String id,
			@Param("nombrePaciente") String nombrePaciente,
			@Param("nombrePsicologo") String nombrePsicologo,
			@Param("nombreTarifa") String nombreTarifa,
			@Param("idEstado") String idEstado,
			@Param("fecha") String fecha,
			@Param("hora") String hora,
			@Param("cantidadHoras") Integer cantidadHoras
			);
	
	public List<CitaEntity> findByActivo(Integer activo);
}
