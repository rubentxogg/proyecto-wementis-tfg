package com.rgg.wementis.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rgg.wementis.entities.EstadoEntity;

@Repository
public interface EstadoRepository extends CrudRepository<EstadoEntity, Integer>{

}
