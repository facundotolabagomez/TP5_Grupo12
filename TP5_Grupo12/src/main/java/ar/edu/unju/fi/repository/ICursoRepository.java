package ar.edu.unju.fi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Curso;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Long> {

	/*
	  @Modifying
	  @Query("delete from Curso c where c.codigo = ?1") public void
	  deleteByCodigo(int codigo);
	  
	  public Curso findByCodigo(int codigo);
	  
	  public List<Curso> findByExisteCurso(boolean existeCurso);
	  
	  public List<Curso> findByInicio(LocalDate Inicio, LocalDate Fin);
	  
	  @Query("select c from Curso c order by c.docente.apellido") public
	  List<Curso> ordenarPorApellidoDocente();
	  
	  public List<Curso> findByCategoriaAndModalidad(String categoria, String
	  modalidad);
	  
	  public List<Curso> findByTituloContaining(String cadena);
	  
	  public List<Curso> findByDocenteLegajoAndExisteCurso(int legajo, boolean existeCurso);
	  */
	 
}
