package ar.edu.unju.fi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="docentes")
public class Docente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DOCENTE_ID")
	private long docente_id;
	
	@Column(name = "DOCENTE_LEGAJO", length = 5)
	@Min(value=1, message="El valor mínimo es 1") 
	@Max(value=9999,message="El valor máximo permitido es 9999")
	private int legajo;
	
	@Column(name = "NOMBRE", length = 30)
	@NotEmpty(message="El nombre no puede ser vacío")
	private String nombre;
	
	@Column(name = "APELLIDO", length = 30)
	@NotEmpty(message="El apellido no puede ser vacío")
	private String apellido;
	
	@Column(name = "EMAIL", length = 50)
	@NotEmpty(message="El email no puede ser vacío")
	@Email(message = "Formato de mail no valido")
	private String email;
	
	@Column(name = "TELEFONO", length = 14)
	@NotEmpty(message="El telefono no puede ser vacío")
	@Size (min = 9,max = 14)
	private String telefono;
	
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
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
	
	
	
	public long getDocente_id() {
		return docente_id;
	}
	public void setDocente_id(long docente_id) {
		this.docente_id = docente_id;
	}
	public Docente() {
		// TODO Auto-generated constructor stub
	}
	public Docente(int legajo, String nombre, String apellido, String email, String telefono) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}
	
	
	
}
