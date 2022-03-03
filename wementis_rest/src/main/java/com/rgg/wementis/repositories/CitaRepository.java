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
	
	@Query(value = "SELECT new com.rgg.wementis.beans.Cita (id, paciente.idPaciente, psicologo.idPsicologo, tarifa.idTarifa, estado.idEstado, fecha, hora, cantidadHoras) "
			+ "FROM com.rgg.wementis.entities.CitaEntity "
			+ "WHERE (id LIKE CONCAT('%', :id, '%') OR :id is NULL) "
			+ "AND (paciente.idPaciente LIKE CONCAT('%', :idPaciente, '%') OR :idPaciente is NULL) "
			+ "AND (psicologo.idPsicologo LIKE CONCAT('%', :idPsicologo, '%') OR :idPsicologo is NULL) "
			+ "AND (tarifa.idTarifa LIKE CONCAT('%', :idTarifa, '%') OR :idTarifa is NULL) "
			+ "AND (estado.idEstado LIKE CONCAT('%', :idEstado, '%') OR :idEstado is NULL) "
			+ "AND fecha >= :fecha "
			+ "AND hora >= :hora "
			+ "AND cantidadHoras >= :cantidadHoras")
	public List<Cita> getCitasPorCampos(
			@Param("id") String id,
			@Param("idPaciente") String idPaciente,
			@Param("idPsicologo") String idPsicologo,
			@Param("idTarifa") String idTarifa,
			@Param("idEstado") String idEstado,
			@Param("fecha") String fecha,
			@Param("hora") String hora,
			@Param("cantidadHoras") Integer cantidadHoras
			);
}
