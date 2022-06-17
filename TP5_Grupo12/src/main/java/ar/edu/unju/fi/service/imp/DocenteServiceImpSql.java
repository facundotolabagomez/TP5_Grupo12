package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Docente;
import ar.edu.unju.fi.repository.IDocenteRepository;
import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.util.ListaDocente;

@Service("DocenteServiceImpSql")
public class DocenteServiceImpSql implements IDocenteService {
	
	@Autowired
	private IDocenteRepository docenteRepository;

	@Override
	public Docente getDocente() {
		// TODO Auto-generated method stub
		return new Docente();
	}

	@Override
	public boolean guardarDocente(Docente docente) {
		// TODO Auto-generated method stub
		docente.setExisteDocente(true);
		if (docenteRepository.save(docente)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarDocente(Docente docente) {
		// TODO Auto-generated method stub
		docenteRepository.save(docente);

	}

	@Override
	public void eliminarDocente(int legajo) {
		// TODO Auto-generated method stub
		Docente docente = buscarDocente(legajo);
		docente.setExisteDocente(false);
		docenteRepository.save(docente);
		//docenteRepository.deleteByLegajo(legajo);

	}

	@Override
	public List<Docente> getListaDocente() {
		// TODO Auto-generated method stub
		return docenteRepository.findByExisteDocente(true);
	}

	@Override
	public Docente buscarDocente(int legajo) {
		// TODO Auto-generated method stub
		return docenteRepository.findByLegajoAndExisteDocente(legajo , true);
	}

}
