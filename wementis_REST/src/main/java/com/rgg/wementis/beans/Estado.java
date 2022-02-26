package com.rgg.wementis.beans;

public class Estado {
	private Integer id;
	private String nombre;
	
	public Estado() {
		super();
	}

	public Estado(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
