package com.rgg.wementis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class AuthorityEntity {

	public AuthorityEntity() {
		super();
	}

	public AuthorityEntity(String username, String authority) {
		super();
		this.username = username;
		this.authority = authority;
	}
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "authority")
	private String authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
