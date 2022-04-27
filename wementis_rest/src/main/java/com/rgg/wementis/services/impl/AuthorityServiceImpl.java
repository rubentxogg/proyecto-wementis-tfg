package com.rgg.wementis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgg.wementis.entities.AuthorityEntity;
import com.rgg.wementis.repositories.AuthorityRepository;
import com.rgg.wementis.services.interfaces.IAuthorityService;

@Service
public class AuthorityServiceImpl implements IAuthorityService{

	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public Iterable<AuthorityEntity> getAuthorities() {
		return authorityRepository.findAll();
	}

	@Override
	public void actualizarAuthority(AuthorityEntity authority) {
		authorityRepository.save(authority);
	}

	@Override
	public void insertarAuhtority(AuthorityEntity authority) {
		authorityRepository.save(authority);
	}	
}
