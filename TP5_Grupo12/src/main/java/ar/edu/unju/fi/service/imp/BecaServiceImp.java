package ar.edu.unju.fi.service.imp;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Beca;
import ar.edu.unju.fi.service.IBecaService;
import ar.edu.unju.fi.util.ListaBeca;


@Service("BecaServiceImpLista")
public class BecaServiceImp implements IBecaService {
	
	@Autowired
	private ListaBeca listaBeca;
	

	@Override
	public Beca getBeca() {
		// TODO Auto-generated method stub
		return new Beca();
	}

	@Override
	public boolean guardarBeca(Beca beca) {
		// TODO Auto-generated method stub
		return listaBeca.getBecas().add(beca);
	}

	@Override
	public void modificarBeca(Beca beca) {
		// TODO Auto-generated method stub
		for(Beca b : listaBeca.getBecas()) {
			if(b.getCodigo() == beca.getCodigo()) {
				b.setCurso(beca.getCurso());
				b.setInicio(beca.getInicio());
				b.setCierre(beca.getCierre());
				b.setEstado(beca.getEstado());
			}
		}
		
	}

	@Override
	public void eliminarBeca(int codigo) {
		// TODO Auto-generated method stub
	for (int i = listaBeca.getBecas().size(); i > 0; i--) {
				
				if (listaBeca.getBecas().get(i-1).getCodigo() == codigo) {
					listaBeca.getBecas().remove(i-1);
				}
			}
	}

	@Override
	public ListaBeca getListaBeca() {
		// TODO Auto-generated method stub
		return listaBeca;
	}

	@Override
	public Beca buscarBeca(int codigo) {
		// TODO Auto-generated method stub
		Optional<Beca> beca = listaBeca.getBecas().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		return beca.get();
	}

}
