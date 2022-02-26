package com.rgg.wementis.beans;

public class Ganancia {
	private Integer id;
	private Integer idCita;
	private Double cantidad;
	private String fechaCreacion;
	
	public Ganancia() {
		super();
	}
	public Ganancia(Integer id, Integer idCita, Double cantidad, String fechaCreacion) {
		super();
		this.id = id;
		this.idCita = idCita;
		this.cantidad = cantidad;
		this.fechaCreacion = fechaCreacion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdCita() {
		return idCita;
	}
	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
