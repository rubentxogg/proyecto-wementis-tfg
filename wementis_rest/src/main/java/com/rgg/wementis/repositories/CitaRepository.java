package com.rgg.wementis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rgg.wementis.entities.CitaEntity;

@Repository
public interface CitaRepository extends CrudRepository<CitaEntity, Integer>{
	
	@Query(value = "SELECT new com.rgg.wementis.entities.CitaEntity (c.id, c.paciente, c.psicologo, c.tarifa, c.estado, c.fecha, c.hora, c.cantidadHoras, c.activo) "
			+ "FROM CitaEntity c "
			+ "WHERE (c.id LIKE CONCAT('%', :id, '%') OR :id is NULL) "
			+ "AND c.paciente.nombre LIKE CONCAT('%', :nombrePaciente, '%') "
			+ "AND c.psicologo.nombre LIKE CONCAT('%', :nombrePsicologo, '%') "
			+ "AND c.tarifa.nombre LIKE CONCAT('%', :nombreTarifa, '%') "
			+ "AND (c.estado.idEstado LIKE CONCAT('%', :idEstado, '%') OR :idEstado is NULL) "
			+ "AND c.fecha >= :fecha "
			+ "AND c.hora >= :hora "
			+ "AND c.cantidadHoras >= :cantidadHoras "
			+ "AND c.activo = 1")
	public List<CitaEntity> getCitasPorCampos(
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
