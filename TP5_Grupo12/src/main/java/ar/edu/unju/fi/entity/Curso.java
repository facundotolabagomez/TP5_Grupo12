package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CURSO_ID")
	private long curso_id;
		
	@Column(name = "CURSO_CODIGO", length = 5)
	@Min(value=1, message="El valor mínimo es 1") @Max(value=9999,message="El valor máximo permitido es 9999")
	private int codigo;
	
	@Column(name = "TITULO", length = 25)
	@NotEmpty(message="El título no puede ser vacío")
	private String titulo;
	
	@Column(name = "CATEGORIA", length = 25)
	@NotEmpty(message="Categoría no puede ser vacío")
	private String categoria;
	
	@Column(name = "FECHA_INICIO", length = 10)
	@NotNull(message="Debe ingresar Fecha de Inicio") @FutureOrPresent(message="La fecha debe ser hoy o posterior")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate inicio;
	
	@Column(name = "FECHA_CIERRE", length = 10)
	@NotNull(message="Debe ingresar Fecha de Fin") @Future(message="La fecha debe ser posterior a la actual")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fin;
	
	@Column(name = "CANT_HORAS", length = 4)
	@NotNull(message="Debe ingresar Cantidad de Horas")
	@Min(value=1,message="Cantidad de horas debe ser mayor a 1")
	private int cantidadDeHoras;
	
	@Column(name = "MODALIDAD", length = 15)
	@NotEmpty(message="Debe ingresar Modalidad")
	private String modalidad;
	
	//@NotNull(message="Debe seleccionar un docente")
	@ManyToOne
	@JoinColumn(name = "DOCENTE_ID")
	private Docente docente;
	
	
	
	@ManyToMany(mappedBy="cursos")
	private List<Alumno> alumno;
	
	
	@Column(name = "EXISTECURSO")	
	private boolean existeCurso;
	
	
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
	public List<Alumno> getAlumno() {
		return alumno;
	}
	public void setAlumno(List<Alumno> alumno) {
		this.alumno = alumno;
	}
	public long getCurso_id() {
		return curso_id;
	}
	public void setCurso_id(long curso_id) {
		this.curso_id = curso_id;
	}
	
	
	
	
	public boolean isExisteCurso() {
		return existeCurso;
	}
	public void setExisteCurso(boolean existeCurso) {
		this.existeCurso = existeCurso;
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
