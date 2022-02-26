package com.rgg.wementis.beans;

public class Cita {
	private Integer id;
	private Integer idPaciente;
	private Integer idTarifa;
	private Integer idEstado;
	private String fecha;
	private Integer cantidadHoras;
	
	public Cita() {
		super();
	}

	public Cita(Integer id, Integer id_paciente, Integer id_tarifa, Integer id_estado, String fecha,
			Integer cantidad_horas) {
		super();
		this.id = id;
		this.idPaciente = id_paciente;
		this.idTarifa = id_tarifa;
		this.idEstado = id_estado;
		this.fecha = fecha;
		this.cantidadHoras = cantidad_horas;
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
