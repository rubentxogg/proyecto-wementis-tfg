package com.rgg.wementis.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "psicologo")
public class PsicologoEntity {
	
	public PsicologoEntity() {
		super();
	}
	
	public PsicologoEntity(Integer idPsicologo, String nombre, String apellidos, String email, String telefono,
			String fechaCreacion, List<CitaEntity> citas) {
		super();
		this.idPsicologo = idPsicologo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.fechaCreacion = fechaCreacion;
		this.citas = citas;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer idPsicologo;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "fecha_creacion")
	private String fechaCreacion;
	
	@OneToMany(mappedBy = "psicologo")
	private List<CitaEntity> citas = new ArrayList<>();

	public Integer getIdPsicologo() {
		return idPsicologo;
	}

	public void setIdPsicologo(Integer idPsicologo) {
		this.idPsicologo = idPsicologo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
