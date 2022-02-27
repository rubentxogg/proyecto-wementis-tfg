package com.rgg.wementis.beans;

public class Cita {
	private Integer id;
	private Integer idPaciente;
	private Integer idPsicologo;
	private Integer idTarifa;
	private Integer idEstado;
	private String fecha;
	private Integer cantidadHoras;
	
	public Cita() {
		super();
	}

	public Cita(Integer id, Integer idPaciente, Integer idPsicologo, Integer idTarifa, Integer idEstado, String fecha,
			Integer cantidadHoras) {
		super();
		this.id = id;
		this.idPaciente = idPaciente;
		this.idPsicologo = idPsicologo;
		this.idTarifa = idTarifa;
		this.idEstado = idEstado;
		this.fecha = fecha;
		this.cantidadHoras = cantidadHoras;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Integer getIdPsicologo() {
		return idPsicologo;
	}

	public void setIdPsicologo(Integer idPsicologo) {
		this.idPsicologo = idPsicologo;
	}

	public Integer getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(Integer idTarifa) {
		this.idTarifa = idTarifa;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(Integer cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}
}
