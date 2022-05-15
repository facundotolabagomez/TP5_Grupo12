package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unju.fi.model.Beca;
import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.model.Docente;

public class ListaBeca {
	private ArrayList<Beca> becas ;
	public ListaBeca() {
		// TODO Auto-generated constructor stub
		
		Docente docente1 = new Docente(111,"Ariel","Vega","vega@unju.com","3885111222");
		Docente docente2 = new Docente(222,"Carolina","Apaza","carolina@unju.com","3885333444");
		//Docente docente3 = new Docente(111,"Jc","Rodriguez","jcrod@unju.com","3885666777");
		Curso curso1 = new Curso(1,"APU","INFORMATICA",LocalDate.of(2022, 03, 10),LocalDate.of(2022, 12, 10),20,"Presencial",docente1);
		Curso curso2 = new Curso(2,"LICENCIATURA","INFORMATICA",LocalDate.of(2022, 02, 10),LocalDate.of(2022, 11, 10),30,"Virtual",docente2);
		becas = new ArrayList<Beca>();
		becas.add(new Beca(444,curso1,LocalDate.of(2022, 01, 15),LocalDate.of(2022, 12, 15),"Activo"));
		becas.add(new Beca(222,curso2,LocalDate.of(2022, 03, 01),LocalDate.of(2022, 12, 01),"EnPausa"));
		
	}
	public ArrayList<Beca> getBecas() {
		return becas;
	}
	public void setBecas(ArrayList<Beca> becas) {
		this.becas = becas;
	}
	
	
}
