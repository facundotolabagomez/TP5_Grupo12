package ar.edu.unju.fi.model;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Beca {
	@Min(value=1, message = "Codigo No Valido")
	private int codigo;
	@NotNull (message= "Debe Seleccionar el Curso")
	private Curso curso; 
	@NotNull(message="Debe ingresar Fecha de Inicio") @FutureOrPresent(message="La fecha debe ser hoy o posterior")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate inicio;
	@NotNull(message="Debe ingresar Fecha de Cierre")  @Future(message="La fecha debe ser posterior a la actual")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate cierre;
	@NotEmpty (message = "Debe ingresar el Estado")
	private String estado;
	
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
