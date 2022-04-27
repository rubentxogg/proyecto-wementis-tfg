package com.rgg.wementis.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rgg.wementis.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String>{

}
