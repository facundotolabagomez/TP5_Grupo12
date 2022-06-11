package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Alumno;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.util.ListaAlumno;

@Service("AlumnoServiceImpLista")
public class AlumnoServiceImp implements IAlumnoService {
	
	@Autowired
	private ListaAlumno listaAlumno;

	@Override
	public Alumno getAlumno() {
		// TODO Auto-generated method stub
		return new Alumno();
	}

	@Override
	public boolean guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return listaAlumno.getAlumnos().add(alumno);
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		for(Alumno alu : listaAlumno.getAlumnos()) {
			if(alu.getDni() == alumno.getDni()) {
				alu.setApellido(alumno.getApellido());
				alu.setNombre(alumno.getNombre());
				alu.setEmail(alumno.getEmail());
				alu.setTelefono(alumno.getTelefono());
			}
		}
	}

	@Override
	public void eliminarAlumno(int dni) {
		// TODO Auto-generated method stub
		for (int i = listaAlumno.getAlumnos().size(); i > 0; i--) {
			//if (can.getCodigo() == codigo) {
			if (listaAlumno.getAlumnos().get(i-1).getDni() == dni) {
				listaAlumno.getAlumnos().remove(i-1);
			}
		}

	}

	@Override
	public ListaAlumno getListaAlumno() {
		// TODO Auto-generated method stub
		return listaAlumno;
	}

	@Override
	public Alumno buscarAlumno(int dni) {
		// TODO Auto-generated method stub
		Optional<Alumno> alumno = listaAlumno.getAlumnos().stream().filter(a -> a.getDni() == dni).findFirst();
		return alumno.get();
	}

}
