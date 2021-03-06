package ar.edu.unju.fi.service;


import java.util.List;

import ar.edu.unju.fi.entity.Beca;
import ar.edu.unju.fi.util.ListaBeca;

public interface IBecaService {
	
	public Beca getBeca();
	public boolean guardarBeca(Beca beca);
	public void modificarBeca (Beca beca);
	public void eliminarBeca (int codigo);
	public List<Beca> getListaBeca();
	public Beca buscarBeca (int codigo);

}
