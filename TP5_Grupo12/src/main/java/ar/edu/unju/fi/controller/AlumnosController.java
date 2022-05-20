package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.util.ListaAlumno;

@Controller
@RequestMapping("/alumno")
public class AlumnosController {
	private static final Log LOGGER = LogFactory.getLog(AlumnosController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoAlumnoPage(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "nuevo_alumno";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaAlumnosPage(@Validated @ModelAttribute("alumno")Alumno alumno, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");

			ModelAndView mav = new ModelAndView("nuevo_alumno");
			mav.addObject("alumno", alumno);
			return mav;
			
		}
		
		ModelAndView mavalumno = new ModelAndView("mostrar_alumnos");
		ListaAlumno listaAlumnos = new ListaAlumno();
		if (listaAlumnos.getAlumnos().add(alumno)) {
			LOGGER.info("Se agregó un objeto al arrayList Alumnos");
		}
		mavalumno.addObject("alumno", listaAlumnos.getAlumnos());
		return mavalumno; 
	}
	
	@GetMapping("/mostrar")
	public String getAlumnosPage(Model model) {
		ListaAlumno listaAlumnos = new ListaAlumno();
		model.addAttribute("alumno", listaAlumnos.getAlumnos());
		return "mostrar_alumnos";
	}
	
	@GetMapping("/lista")
	public String getListaAlumnosPage(Model model) {
		ListaAlumno listaAlumnos = new ListaAlumno();
		model.addAttribute("alumno", listaAlumnos.getAlumnos());
		return "lista_alumnos";
	}
	
}
