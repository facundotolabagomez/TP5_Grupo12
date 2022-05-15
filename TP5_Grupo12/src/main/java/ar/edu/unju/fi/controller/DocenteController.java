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

import ar.edu.unju.fi.model.Docente;

import ar.edu.unju.fi.util.ListaDocente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	private static final Log LOGGER = LogFactory.getLog(DocenteController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoDocentePage(Model model) {
		model.addAttribute("docente", new Docente());
		return "nuevo_docente";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaDocentesPage(@ModelAttribute("docente")Docente docente) {
		ModelAndView mavdocente = new ModelAndView("mostrar_docentes");
		ListaDocente listaDocentes = new ListaDocente();
		if (listaDocentes.getDocentes().add(docente)) {
			LOGGER.info("Se agregó un objeto al arrayList Docentes");
		}
		mavdocente.addObject("docente", listaDocentes.getDocentes());
		return mavdocente; 
	}
	
	@GetMapping("/mostrar")
	public String getDocentesPage(Model model) {
		ListaDocente listaDocentes = new ListaDocente();
		model.addAttribute("docente", listaDocentes.getDocentes());
		return "mostrar_docentes";
	}
	
	@GetMapping("/lista")
	public String getListaDocentesPage(Model model) {
		ListaDocente listaDocentes = new ListaDocente();
		model.addAttribute("docente", listaDocentes.getDocentes());
		return "lista_docentes";
	}
	
}
