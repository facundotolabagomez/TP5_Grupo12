package ar.edu.unju.fi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import ar.edu.unju.fi.entity.Alumno;
import ar.edu.unju.fi.entity.Beca;


@Repository
public interface IBecaRepository extends JpaRepository<Beca, Long>  {
	
	
	 @Modifying	 
	 @Query("delete from Beca b where b.codigo = ?1") 
	 public void deleteByCodigo(int codigo);
	 
	 //public Beca findByCodigo(int codigo);
	  
	 public List<Beca> findByExisteBeca(boolean existeBeca);
	 
	 /*public List<Beca> findByInicio(LocalDate inicio, LocalDate cierre);
	  
	 @Query("select b from Beca b order by b.beca.inicio") 
	 public List<Beca>ordenarPorInicio();
	 
	 public List<Beca> findByEstado(String estado);*/
	 
	 public Beca findByCodigoAndExisteBeca(int codigo, boolean existeBeca);
	 

}
