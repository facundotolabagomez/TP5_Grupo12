package ar.edu.unju.fi.service;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.util.ListaAlumno;

public interface IAlumnoService {
	
	public Alumno getAlumno();
	public boolean guardarAlumno(Alumno alumno);
	public void modificarAlumno (Alumno alumno);
	public void eliminarAlumno (int dni);
	public ListaAlumno getListaAlumno();
	public Alumno buscarAlumno (int dni);

}
