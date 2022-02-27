package com.rgg.wementis.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tarifa")
public class TarifaEntity {
	
	public TarifaEntity() {
		super();
	}
	
	public TarifaEntity(Integer id, String nombre, Double precioHora, String fechaCreacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precioHora = precioHora;
		this.fechaCreacion = fechaCreacion;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "precio_hora")
	private Double precioHora;
	
	@Column(name = "fecha_creacion")
	private String fechaCreacion;
	
	@OneToMany(mappedBy = "tarifa")
	private List<CitaEntity> citas = new ArrayList<>();

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
}
