package com.rgg.wementis.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rgg.wementis.entities.CitaEntity;

@Repository
public interface CitaRepository extends CrudRepository<CitaEntity, Integer>{
	// TODO
}
