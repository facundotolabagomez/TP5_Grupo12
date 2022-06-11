package ar.edu.unju.fi.entity;

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
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="alumnos")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ALUMNO_ID")
	private long alumno_id;
		
	@Column(name = "DNI", length = 8)
	@Min(value=1000000, message = "DNI No valido")
	private int dni;
	
	@Column(name = "NOMBRE", length = 30)
	@NotNull (message = "Debe completar el Nombre")
	@Size(min=3, max=30)
	private String nombre;
	
	@Column(name = "APELLIDO", length = 30)
	@NotNull(message = "Debe completar el Apellido")
	@Size(min=3, max=30)
	private String apellido;
	
	@Column(name = "EMAIL", length = 50)
	@NotNull(message = "Debe completar el Email")
	@Email
	private String email;
	
	@Column(name = "TELEFONO", length = 14)
	@NotEmpty(message = "Debe completar el Telefono")
	@NotNull (message = "Debe completar el Telefono")
	@Size(min=9, max=14)
	private String telefono;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "CURSO_ID")
	@NotNull (message= "Debe Seleccionar el Curso")
	private List<Curso> cursos;
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	
	

	public long getAlumno_id() {
		return alumno_id;
	}

	public void setAlumno_id(long alumno_id) {
		this.alumno_id = alumno_id;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Alumno(int dni, String nombre, String apellido, String email, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	
	
	
}
