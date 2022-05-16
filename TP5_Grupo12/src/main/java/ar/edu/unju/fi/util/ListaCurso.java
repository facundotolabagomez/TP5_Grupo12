package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.model.Docente;

public class ListaCurso {
private ArrayList<Curso> cursos ;
	
	public ListaCurso() {
				
		cursos = new ArrayList<Curso>();
		cursos.add(new Curso(123,"Ingles","Idiomas",LocalDate.of(2022, 03, 10),LocalDate.of(2022, 12, 10),20,"Presencial",(new Docente(123,"Elio","Rodriguez","elio@fi.com","388-5223344"))));
		
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}



}
