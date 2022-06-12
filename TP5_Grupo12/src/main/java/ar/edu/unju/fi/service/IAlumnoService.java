package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Alumno;
//import ar.edu.unju.fi.util.ListaAlumno;

public interface IAlumnoService {
	
	public Alumno getAlumno();
	public boolean guardarAlumno(Alumno alumno);
	public void modificarAlumno (Alumno alumno);
	public void eliminarAlumno (int dni);
	public List<Alumno> getListaAlumno();
	public Alumno buscarAlumno (int dni);

}
