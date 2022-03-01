package com.rgg.wementis.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rgg.wementis.entities.GananciaEntity;

@Repository
public interface GananciaRepository extends CrudRepository<GananciaEntity, Integer>{

}
