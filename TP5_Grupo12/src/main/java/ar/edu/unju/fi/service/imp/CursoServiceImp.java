package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.service.ICursoService;
import ar.edu.unju.fi.util.ListaCurso;


@Service("CursoServiceImpLista")
public class CursoServiceImp implements ICursoService {
	
	@Autowired
	private ListaCurso listaCurso;

	@Override
	public Curso getCurso() {
		// TODO Auto-generated method stub
		return new Curso();
	}

	@Override
	public boolean guardarCurso(Curso curso) {
		// TODO Auto-generated method stub
		return listaCurso.getCursos().add(curso);
	}

	@Override
	public void modificarCurso(Curso curso) {
		// TODO Auto-generated method stub
		for(Curso c : listaCurso.getCursos()) {
			if(c.getCodigo() == curso.getCodigo()) {
				c.setTitulo(curso.getTitulo());
				c.setCategoria(curso.getCategoria());
				c.setInicio(curso.getInicio());
				c.setFin(curso.getFin());
				c.setCantidadDeHoras(curso.getCantidadDeHoras());
				c.setModalidad(curso.getModalidad());
				c.setDocente(curso.getDocente());
			}
		}
	}

	@Override
	public void eliminarCurso(int codigo) {
		// TODO Auto-generated method stub
	for (int i = listaCurso.getCursos().size(); i > 0; i--) {
			
			if (listaCurso.getCursos().get(i-1).getCodigo() == codigo) {
				listaCurso.getCursos().remove(i-1);
			}
		}
	}

	@Override
	public ListaCurso getListaCurso() {
		// TODO Auto-generated method stub
		return listaCurso;
	}

	@Override
	public Curso buscarCurso(int codigo) {
		// TODO Auto-generated method stub

		Optional<Curso> curso = listaCurso.getCursos().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		return curso.get();
	}

}
