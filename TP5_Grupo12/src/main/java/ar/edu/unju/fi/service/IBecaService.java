package ar.edu.unju.fi.service;


import ar.edu.unju.fi.model.Beca;
import ar.edu.unju.fi.util.ListaBeca;

public interface IBecaService {
	
	public Beca getBeca();
	public boolean guardarBeca(Beca beca);
	public void modificarBeca (Beca beca);
	public void eliminarBeca (int codigo);
	public ListaBeca getListaBeca();
	public Beca buscarBeca (int codigo);

}
