package com.rgg.wementis.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rgg.wementis.entities.PacienteEntity;

@Repository
public interface PacienteRepository extends CrudRepository<PacienteEntity, Integer>{

}
