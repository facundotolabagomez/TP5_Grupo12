package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.entity.Alumno;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {

	@Modifying
	@Query("delete from Alumno a where a.dni = ?1")
	public void deleteByDni(int dni);
	
	public Alumno findByDni(int dni);
	
	public List<Alumno> findByExisteAlumno(boolean existeAlumno);	
	
	/*
	 * @Query("select a from Alumno a order by a.alumno.apellido") public
	 * List<Alumno> ordenarPorApellido();
	 */	
	
	/*
	 * @Query("select a from Alumno a order by a.alumno.dni") public List<Alumno>
	 * ordenarPorDni();
	 */
	
	public Alumno findByDniAndExisteAlumno(int dni, boolean existeAlumno);

	
}
