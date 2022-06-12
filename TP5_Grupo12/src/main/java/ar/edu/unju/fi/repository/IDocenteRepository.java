package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.entity.Docente;

public interface IDocenteRepository extends JpaRepository<Docente, Long> {

	/*
	@Modifying
	@Query("delete from Curso c where c.codigo = ?1")
	public void deleteByLegajo(int legajo);
	
	public Docente findByLegajo(int legajo);
	
	public List<Docente> findByExisteDocente(boolean existeDocente);	
	
	@Query("select d from Docente d order by d.docente.apellido")
	public List<Docente> ordenarPorApellido();	
	
	@Query("select d from Docente d order by d.docente.legajo")
	public List<Docente> ordenarPorLegajo();
	
	public List<Docente> findByLegajoAndExisteDocente(int legajo, boolean existeDocente);
	*/
}
