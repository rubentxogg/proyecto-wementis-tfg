package com.rgg.wementis.services.interfaces;

import com.rgg.wementis.entities.AuthorityEntity;

public interface IAuthorityService {

	public Iterable<AuthorityEntity> getAuthorities();
	
	public void actualizarAuthority(AuthorityEntity authority);
	
	public void insertarAuhtority(AuthorityEntity authority);
}
