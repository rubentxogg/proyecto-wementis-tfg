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

	public EstadoEntity(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "estado")
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
}
