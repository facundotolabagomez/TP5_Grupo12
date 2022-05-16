package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.util.ListaCurso;


@Controller
@RequestMapping("/cursos")
public class CursosController {
	private static final Log LOGGER = LogFactory.getLog(CursosController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoCursoPage(Model model) {
		model.addAttribute("curso", new Curso());
		return "nuevo_curso";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaCursosPage(@ModelAttribute("curso")Curso curso) {
		ModelAndView mavcurso = new ModelAndView("mostrar_cursos");
		ListaCurso listaCurso = new ListaCurso();
		if (listaCurso.getCursos().add(curso)) {
			LOGGER.info("Se agregó un objeto al arrayList Cursos");
		}
		mavcurso.addObject("curso", listaCurso.getCursos());
		return mavcurso; 
	}
	
	@GetMapping("/mostrar")
	public String getCursosPage(Model model) {
		ListaCurso listaCurso = new ListaCurso();
		model.addAttribute("curso", listaCurso.getCursos());
		return "mostrar_cursos";
	}
	
	@GetMapping("/lista")
	public String getListaCursosPage(Model model) {
		ListaCurso listaCurso = new ListaCurso();
		model.addAttribute("curso", listaCurso.getCursos());
		return "lista_cursos";
	}
	
}