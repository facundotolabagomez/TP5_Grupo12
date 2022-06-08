package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.util.ListaDocente;

@Service("DocenteServiceImpLista")
public class DocenteServiceImp implements IDocenteService {
	
	@Autowired
	private ListaDocente listaDocente;

	@Override
	public Docente getDocente() {
		// TODO Auto-generated method stub
		return new Docente();
	}

	@Override
	public boolean guardarDocente(Docente docente) {
		// TODO Auto-generated method stub
		return listaDocente.getDocentes().add(docente);
	}

	@Override
	public void modificarDocente(Docente docente) {
		// TODO Auto-generated method stub
		for(Docente d : listaDocente.getDocentes()) {
			if(d.getLegajo() == docente.getLegajo()) {
				d.setApellido(docente.getApellido());
				d.setNombre(docente.getNombre());
				d.setEmail(docente.getEmail());
				d.setTelefono(docente.getTelefono());
			}
		}
	}

	@Override
	public void eliminarDocente(int legajo) {
		// TODO Auto-generated method stub
		for (int i = listaDocente.getDocentes().size(); i > 0; i--) {
			
			if (listaDocente.getDocentes().get(i-1).getLegajo() == legajo) {
				listaDocente.getDocentes().remove(i-1);
			}
		}
	}

	@Override
	public ListaDocente getListaDocente() {
		// TODO Auto-generated method stub
		return listaDocente;
	}

	@Override
	public Docente buscarDocente(int legajo) {
		// TODO Auto-generated method stub
		Optional<Docente> docente = listaDocente.getDocentes().stream().filter(a -> a.getLegajo() == legajo).findFirst();
		return docente.get();
		
	}

}
