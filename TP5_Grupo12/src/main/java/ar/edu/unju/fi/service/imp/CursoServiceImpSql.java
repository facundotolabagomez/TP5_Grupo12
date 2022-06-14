package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import ar.edu.unju.fi.entity.Beca;
import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.repository.ICursoRepository;
import ar.edu.unju.fi.service.ICursoService;
//import ar.edu.unju.fi.util.ListaCurso;

@Service("CursoServiceImpSql")
public class CursoServiceImpSql implements ICursoService {
	
	@Autowired
	private ICursoRepository cursoRepository;

	@Override
	public Curso getCurso() {
		// TODO Auto-generated method stub
		return new Curso();
	}

	@Override
	public boolean guardarCurso(Curso curso) {
		// TODO Auto-generated method stub
		curso.setExisteCurso(true);
		if (cursoRepository.save(curso)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarCurso(Curso curso) {
		// TODO Auto-generated method stub
		cursoRepository.save(curso);

	}

	@Override
	public void eliminarCurso(int codigo) {
		// TODO Auto-generated method stub
		Curso curso = buscarCurso(codigo,true);
		curso.setExisteCurso(false);
		cursoRepository.save(curso);

	}

	@Override
	public List<Curso> getListaCurso() {
		// TODO Auto-generated method stub
		return cursoRepository.findByExisteCurso(true);
	}

	@Override
	public Curso buscarCurso(int codigo, boolean existeCurso) {
		// TODO Auto-generated method stub
		return cursoRepository.findByCodigoAndExisteCurso(codigo,existeCurso);
	}

}
