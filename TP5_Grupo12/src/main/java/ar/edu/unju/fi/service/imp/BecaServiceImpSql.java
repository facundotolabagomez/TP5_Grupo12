package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Beca;
import ar.edu.unju.fi.repository.IBecaRepository;
import ar.edu.unju.fi.service.IBecaService;

@Service("BecaServiceImpSql")
public class BecaServiceImpSql implements IBecaService{

	@Autowired
	private IBecaRepository becaRepository;
	
	@Override
	public Beca getBeca() {
		// TODO Auto-generated method stub
		return new Beca();
	}

	@Override
	public boolean guardarBeca(Beca beca) {
		// TODO Auto-generated method stub
		beca.setExisteBeca(true);
		if (becaRepository.save(beca)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarBeca(Beca beca) {
		// TODO Auto-generated method stub
		becaRepository.save(beca);
	}

	@Override
	public void eliminarBeca(int codigo) {
		// TODO Auto-generated method stub
		Beca beca = buscarBeca(codigo);
		beca.setExisteBeca(false);
		becaRepository.save(beca);
		
	}

	@Override
	public List<Beca> getListaBeca() {
		// TODO Auto-generated method stub
		return  becaRepository.findByExisteBeca(true);
	}

	@Override
	public Beca buscarBeca(int codigo) {
		// TODO Auto-generated method stub
		return becaRepository.findByCodigoAndExisteBeca(codigo, true);
	}

}
