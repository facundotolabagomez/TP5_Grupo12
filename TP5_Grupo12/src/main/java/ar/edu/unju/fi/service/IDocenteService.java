package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Docente;
import ar.edu.unju.fi.util.ListaDocente;

public interface IDocenteService {

	public Docente getDocente();
	public boolean guardarDocente(Docente docente);
	public void modificarDocente (Docente docente);
	public void eliminarDocente (int legajo);
	public List<Docente> getListaDocente();
	public Docente buscarDocente (int legajo);
}
