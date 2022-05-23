package ar.edu.unju.fi.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Docente {
	@Min(value=1, message="El valor mínimo es 1") 
	@Max(value=9999,message="El valor máximo permitido es 9999")
	private int legajo;
	@NotEmpty(message="El nombre no puede ser vacío")
	private String nombre;
	@NotEmpty(message="El apellido no puede ser vacío")
	private String apellido;
	@NotEmpty(message="El email no puede ser vacío")
	@Email(message = "Formato de mail no valido")
	private String email;
	@NotEmpty(message="El telefono no puede ser vacío")
	@Size (min = 10,max = 11)
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
