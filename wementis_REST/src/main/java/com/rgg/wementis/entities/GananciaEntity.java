package com.rgg.wementis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ganancia")
public class GananciaEntity {

	public GananciaEntity() {
		super();
	}
	
	public GananciaEntity(Integer id, CitaEntity cita, Double cantidad, String fechaCreacion) {
		super();
		this.id = id;
		this.cita = cita;
		this.cantidad = cantidad;
		this.fechaCreacion = fechaCreacion;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "cantidad")
	private Double cantidad;
	
	@Column(name = "fecha_creacion")
	private String fechaCreacion;
	
	@OneToOne
	@JoinColumn(name = "id_cita")
	private CitaEntity cita;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public CitaEntity getCita() {
		return cita;
	}

	public void setCita(CitaEntity cita) {
		this.cita = cita;
	}
}
