package ar.edu.unju.fi.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;

@Component
public class ListaAlumno {
	private ArrayList<Alumno> alumnos ;
	
	public ListaAlumno() {
		alumnos = new ArrayList<Alumno>();
		alumnos.add(new Alumno(33444555,"Juan","Perez","juanp@gmail.com","3884999777"));
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setDocentes(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
}