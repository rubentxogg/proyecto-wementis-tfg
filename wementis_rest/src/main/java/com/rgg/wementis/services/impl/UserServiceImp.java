package com.rgg.wementis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgg.wementis.entities.AuthorityEntity;
import com.rgg.wementis.entities.UserEntity;
import com.rgg.wementis.repositories.AuthorityRepository;
import com.rgg.wementis.repositories.UserRepository;
import com.rgg.wementis.services.interfaces.IUserService;

@Service
public class UserServiceImp implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public Iterable<UserEntity> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public void actualizarUsuario(UserEntity user) {
		userRepository.save(user);
	}

	@Override
	public void borrarUsuario(String username) {
		UserEntity user = userRepository.findById(username).get();
		
		user.setEnabled(false);
		userRepository.save(user);
	}

	@Override
	public void insertarUsuario(UserEntity user) {
		userRepository.save(user);
		
		AuthorityEntity authority = new AuthorityEntity(user.getUsername(), "ROLE_USUARIO");
		authorityRepository.save(authority);
	}
}
