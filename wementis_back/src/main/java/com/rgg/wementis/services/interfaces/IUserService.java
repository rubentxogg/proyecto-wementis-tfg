package com.rgg.wementis.services.interfaces;

import com.rgg.wementis.entities.UserEntity;

public interface IUserService {
	
	public UserEntity getUserByUsername(String username);
	
	public Integer actualizarPasswordUsuario(UserEntity user, String password);
	
	public void borrarUsuario(String username);
	
	public void insertarUsuario(UserEntity user);
}
