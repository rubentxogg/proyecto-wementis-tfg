package com.rgg.wementis.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class EstadoEntity {
	
	public EstadoEntity() {
		super();
	}

	public EstadoEntity(Integer idEstado, String nombre) {
		super();
		this.idEstado = idEstado;
		this.nombre = nombre;
	}

	@Id
	@Column(name = "id")
	private Integer idEstado;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "estado")
	private List<CitaEntity> citas = new ArrayList<>();

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
