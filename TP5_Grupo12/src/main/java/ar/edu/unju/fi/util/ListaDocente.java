package ar.edu.unju.fi.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Docente;

@Component
public class ListaDocente {
	private ArrayList<Docente> docentes ;
	
	public ListaDocente() {
				
		docentes = new ArrayList<Docente>();
		docentes.add(new Docente(123,"Elio","Rodriguez","elio@fi.com","388-5223344"));
		
	}

	public ArrayList<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(ArrayList<Docente> docentes) {
		this.docentes = docentes;
	}

}
