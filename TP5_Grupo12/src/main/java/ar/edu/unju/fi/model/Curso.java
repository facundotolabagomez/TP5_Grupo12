package ar.edu.unju.fi.model;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Curso {

	@Min(value=1, message="El valor mínimo es 1") @Max(value=9999,message="El valor máximo permitido es 9999")
	private int codigo;
	@NotEmpty(message="El título no puede ser vacío")
	private String titulo;
	@NotEmpty(message="Categoría no puede ser vacío")
	private String categoria;
	@NotNull(message="Debe ingresar Fecha de Inicio") @FutureOrPresent(message="La fecha debe ser hoy o posterior")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate inicio;
	@NotNull(message="Debe ingresar Fecha de Fin") @Future(message="La fecha debe ser posterior a la actual")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fin;
	@NotNull(message="Debe ingresar Cantidad de Horas")
	@Min(value=1,message="Cantidad de horas debe ser mayor a 1")
	private int cantidadDeHoras;
	@NotEmpty(message="Debe ingresar Modalidad")
	private String modalidad;
	@NotNull(message="Debe seleccionar un docente")
	private Docente docente;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public LocalDate getFin() {
		return fin;
	}
	public void setFin(LocalDate fin) {
		this.fin = fin;
	}
	public int getCantidadDeHoras() {
		return cantidadDeHoras;
	}
	public void setCantidadDeHoras(int cantidadDeHoras) {
		this.cantidadDeHoras = cantidadDeHoras;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	public Curso(int codigo, String titulo, String categoria, LocalDate inicio, LocalDate fin, int cantidadDeHoras,
			String modalidad, Docente docente) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.inicio = inicio;
		this.fin = fin;
		this.cantidadDeHoras = cantidadDeHoras;
		this.modalidad = modalidad;
		this.docente = docente;
	}
	
	
	
}
