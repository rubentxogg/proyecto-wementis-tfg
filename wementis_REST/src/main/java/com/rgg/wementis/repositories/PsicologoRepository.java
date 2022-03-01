package com.rgg.wementis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rgg.wementis.beans.Psicologo;
import com.rgg.wementis.entities.PsicologoEntity;

@Repository
public interface PsicologoRepository extends CrudRepository<PsicologoEntity, Integer> {

	@Query(value = "SELECT new com.rgg.wementis.beans.Psicologo (id, nombre, apellidos, email, telefono, fechaCreacion) "
			+ "FROM com.rgg.wementis.entities.PsicologoEntity "
			+ "WHERE (id LIKE CONCAT('%', :id, '%') OR :id is NULL) "
			+ "AND nombre LIKE CONCAT('%', :nombre, '%') "
			+ "AND apellidos LIKE CONCAT('%', :apellidos, '%') "
			+ "AND email LIKE CONCAT('%', :email, '%') "
			+ "AND telefono LIKE CONCAT('%', :telefono, '%') "
			+ "AND fechaCreacion >= :fechaCreacion")
	public List<Psicologo> getPsicologosPorCampos(
			@Param("id") String id,
			@Param("nombre") String nombre,
			@Param("apellidos") String apellidos,
			@Param("email") String email,
			@Param("telefono") String telefono,
			@Param("fechaCreacion") String fechaCreacion
			);
}
