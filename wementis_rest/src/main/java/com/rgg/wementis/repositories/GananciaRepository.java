package com.rgg.wementis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rgg.wementis.beans.Ganancia;
import com.rgg.wementis.entities.GananciaEntity;

@Repository
public interface GananciaRepository extends CrudRepository<GananciaEntity, Integer>{

	@Query(value = "SELECT new com.rgg.wementis.beans.Ganancia (id, cita.id, cantidad, fechaCreacion) "
			+ "FROM com.rgg.wementis.entities.GananciaEntity "
			+ "WHERE (id LIKE CONCAT('%', :id, '%') OR :id is NULL) "
			+ "AND (cita.id LIKE CONCAT('%', :idCita, '%') OR :idCita is NULL) "
			+ "AND cantidad >= :cantidad "
			+ "AND fechaCreacion >= :fechaCreacion")
	public List<Ganancia> getGananciasPorCampos(
			@Param("id") String id,
			@Param("idCita") String idCita,
			@Param("cantidad") Double cantidad,
			@Param("fechaCreacion") String fechaCreacion
			);
}
