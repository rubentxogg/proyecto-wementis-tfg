package com.rgg.wementis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rgg.wementis.beans.Paciente;
import com.rgg.wementis.entities.PacienteEntity;

@Repository
public interface PacienteRepository extends CrudRepository<PacienteEntity, Integer>{

	@Query(value = " SELECT new com.rgg.wementis.beans.Paciente(id, nombre, apellidos, email, telefono, fecha_nacimiento, genero, fecha_creacion) "
			+ "FROM PacienteEntity "
			+ "WHERE (id LIKE CONCAT('%', :id, '%') OR :id is NULL) "
			+ "AND nombre LIKE CONCAT('%', :nombre, '%') "
			+ "AND apellidos LIKE CONCAT('%', :apellidos, '%') "
			+ "AND email LIKE CONCAT('%', :email, '%') "
			+ "AND telefono LIKE CONCAT('%', :telefono, '%') "
			+ "AND fecha_nacimiento >= :fechaNacimiento "
			+ "AND genero LIKE CONCAT('%', :genero, '%') "
			+ "AND fecha_creacion >= :fechaCreacion")
	public List<Paciente> getPacientesPorCampos(
			@Param("id") String id,
			@Param("nombre") String nombre,
			@Param("apellidos") String apellidos,
			@Param("email") String email,
			@Param("telefono") String telefono,
			@Param("fechaNacimiento") String fechaNacimiento,
			@Param("genero") String genero,
			@Param("fechaCreacion") String fechaCreacion
			);
}
