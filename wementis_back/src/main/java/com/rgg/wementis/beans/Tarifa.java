package com.rgg.wementis.beans;

public class Tarifa {
	private Integer id;
	private String nombre;
	private Double precioHora;
	private String fechaCreacion;
	private Integer activo;
	
	public Tarifa() {
		super();
	}

	public Tarifa(Integer id, String nombre, Double precioHora, String fechaCreacion, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precioHora = precioHora;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
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

	public Double getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(Double precioHora) {
		this.precioHora = precioHora;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}
}
