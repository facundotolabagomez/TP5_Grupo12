package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="becas")
public class Beca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BECAS_ID")
	private long beca_id;
	
	@Column(name = "BECA_CODIGO", length = 5)
	@Min(value=1, message = "Codigo No Valido")
	private int codigo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CURSO_ID")
	@NotNull (message= "Debe Seleccionar el Curso")
	private Curso curso;
	
	@Column(name = "FECHA_INICIO", length = 10)
	@NotNull(message="Debe ingresar Fecha de Inicio") @FutureOrPresent(message="La fecha debe ser hoy o posterior")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate inicio;
	
	@Column(name = "FECHA_CIERRE", length = 10)
	@NotNull(message="Debe ingresar Fecha de Cierre")  @Future(message="La fecha debe ser posterior a la actual")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate cierre;
	
	@Column(name = "ESTADO", length = 10)
	@NotEmpty (message = "Debe ingresar el Estado")
	private String estado;
	
	@Column(name = "EXISTEBECA")	
	private boolean existeBeca;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public LocalDate getCierre() {
		return cierre;
	}
	public void setCierre(LocalDate cierre) {
		this.cierre = cierre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
		
	
	public boolean isExisteBeca() {
		return existeBeca;
	}
	public void setExisteBeca(boolean existeBeca) {
		this.existeBeca = existeBeca;
	}
	public long getBeca_id() {
		return beca_id;
	}
	public void setBeca_id(long beca_id) {
		this.beca_id = beca_id;
	}
	public Beca() {
		// TODO Auto-generated constructor stub
	}
	public Beca(int codigo, Curso curso, LocalDate inicio, LocalDate cierre, String estado) {
		super();
		this.codigo = codigo;
		this.curso = curso;
		this.inicio = inicio;
		this.cierre = cierre;
		this.estado = estado;
	}
	
	
}
