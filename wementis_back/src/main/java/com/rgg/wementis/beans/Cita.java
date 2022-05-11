package com.rgg.wementis.beans;

public class Cita {
	private Integer id;
	private Integer idPaciente;
	private Integer idPsicologo;
	private Integer idTarifa;
	private Integer idEstado;
	private String fecha;
	private String hora;
	private Integer cantidadHoras;
	private Integer activo;
	
	public Cita() {
		super();
	}

	public Cita(Integer id, Integer idPaciente, Integer idPsicologo, Integer idTarifa, Integer idEstado, String fecha,
			String hora, Integer cantidadHoras, Integer activo) {
		super();
		this.id = id;
		this.idPaciente = idPaciente;
		this.idPsicologo = idPsicologo;
		this.idTarifa = idTarifa;
		this.idEstado = idEstado;
		this.fecha = fecha;
		this.hora = hora;
		this.cantidadHoras = cantidadHoras;
		this.activo = activo;
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

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}
}
