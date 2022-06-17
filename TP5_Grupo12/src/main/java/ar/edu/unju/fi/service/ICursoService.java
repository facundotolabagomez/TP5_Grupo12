package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Curso;
//import ar.edu.unju.fi.util.ListaCurso;

public interface ICursoService {
	
	public Curso getCurso();
	public boolean guardarCurso(Curso curso);
	public void modificarCurso (Curso curso);
	public void eliminarCurso (int codigo);
	public List<Curso> getListaCurso();
	public Curso buscarCurso (int codigo,boolean existeCurso);
}
