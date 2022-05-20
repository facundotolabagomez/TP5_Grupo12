package ar.edu.unju.fi.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Alumno {
	@Min(value=1000000, message = "DNI No valido")
	private int dni;
	@NotNull (message = "Debe completar el Nombre")
	@Size(min=3, max=30)
	private String nombre;
	@NotNull(message = "Debe completar el Apellido")
	@Size(min=3, max=30)
	private String apellido;
	@NotNull(message = "Debe completar el Email")
	@Email
	private String email;
	@NotNull (message = "Debe completar el Telefono")
	private String telefono;
	
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

	public Alumno(int dni, String nombre, String apellido, String email, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	
	
	
}
