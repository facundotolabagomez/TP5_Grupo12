package ar.edu.unju.fi.service.imp;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Alumno;
import ar.edu.unju.fi.repository.IAlumnoRepository;
import ar.edu.unju.fi.service.IAlumnoService;
//import ar.edu.unju.fi.util.ListaAlumno;

@Service("AlumnoServiceImpSql")
public class AlumnoServiceImpSql implements IAlumnoService {

	@Autowired
	private IAlumnoRepository alumnoRepository;

	@Override
	public Alumno getAlumno() {
		// TODO Auto-generated method stub
		return new Alumno();
	}

	@Override
	public boolean guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		alumno.setExisteAlumno(true);
		if (alumnoRepository.save(alumno)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		alumnoRepository.save(alumno);
	}

	@Override
	public void eliminarAlumno(int dni) {
		// TODO Auto-generated method stub
		Alumno alumno = buscarAlumno(dni);
		alumno.setExisteAlumno(false);
		alumnoRepository.save(alumno);
		//alumnoRepository.deleteByDni(dni);

	}

	@Override
	public List<Alumno> getListaAlumno() {
		// TODO Auto-generated method stub
		return alumnoRepository.findByExisteAlumno(true);
	}

	@Override
	public Alumno buscarAlumno(int dni) {
		// TODO Auto-generated method stub
		return alumnoRepository.findByDniAndExisteAlumno(dni, true);
	}

}
