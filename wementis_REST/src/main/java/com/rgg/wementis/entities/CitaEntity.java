package com.rgg.wementis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cita")
public class CitaEntity {
	
	public CitaEntity() {
		super();
	}

	public CitaEntity(Integer id, String fecha, Integer cantidadHoras, PacienteEntity paciente,
			PsicologoEntity psicologo, TarifaEntity tarifa, EstadoEntity estado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cantidadHoras = cantidadHoras;
		this.paciente = paciente;
		this.psicologo = psicologo;
		this.tarifa = tarifa;
		this.estado = estado;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "cantidad_horas")
	private Integer cantidadHoras;
	
	@ManyToOne
	@JoinColumn(name = "idPaciente")
	private PacienteEntity paciente;

	@ManyToOne
	@JoinColumn(name = "idPsicologo")
	private PsicologoEntity psicologo;
	
	@ManyToOne
	@JoinColumn(name = "idTarifa")
	private TarifaEntity tarifa;
	
	@ManyToOne
	@JoinColumn(name = "idEstado")
	private EstadoEntity estado;
	
	@OneToOne(mappedBy = "cita")
	private GananciaEntity ganancia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public PacienteEntity getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}

	public PsicologoEntity getPsicologo() {
		return psicologo;
	}

	public void setPsicologo(PsicologoEntity psicologo) {
		this.psicologo = psicologo;
	}

	public TarifaEntity getTarifa() {
		return tarifa;
	}

	public void setTarifa(TarifaEntity tarifa) {
		this.tarifa = tarifa;
	}

	public EstadoEntity getEstado() {
		return estado;
	}

	public void setEstado(EstadoEntity estado) {
		this.estado = estado;
	}
}
