package com.rgg.wementis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rgg.wementis.beans.Tarifa;
import com.rgg.wementis.entities.TarifaEntity;

@Repository
public interface TarifaRepository extends CrudRepository<TarifaEntity, Integer>{

	@Query(value = "SELECT new com.rgg.wementis.beans.Tarifa (id, nombre, precioHora, fechaCreacion) "
			+ "FROM com.rgg.wementis.entities.TarifaEntity "
			+ "WHERE (id LIKE CONCAT('%', :id, '%') OR :id is NULL) "
			+ "AND nombre LIKE CONCAT('%', :nombre, '%') "
			+ "AND precioHora >= :precioHora "
			+ "AND fechaCreacion >= :fechaCreacion")
	public List<Tarifa> getTarifasPorCampos(
			@Param("id") String id, 
			@Param("nombre") String nombre,
			@Param("precioHora") Double precioHora,
			@Param("fechaCreacion") String fechaCreacion
			);
}
