package com.rgg.wementis.services.interfaces;

import com.rgg.wementis.entities.UserEntity;

public interface IUserService {

	public Iterable<UserEntity> getUsers();
	
	public void actualizarUsuario(UserEntity user);
	
	public void borrarUsuario(String username);
	
	public void insertarUsuario(UserEntity user);
}
