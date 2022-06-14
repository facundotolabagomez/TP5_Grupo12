package ar.edu.unju.fi.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Alumno;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.service.ICursoService;


@Controller
@RequestMapping("/alumno")
public class AlumnosController {
	
	@Autowired
	@Qualifier("AlumnoServiceImpSql")//cambiar sql
	private IAlumnoService alumnoService;
	
	@Autowired
	@Qualifier("CursoServiceImpSql")
	private ICursoService cursoService;
	
	//ListaAlumno listaAlumnos = new ListaAlumno();
	private static final Log LOGGER = LogFactory.getLog(AlumnosController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoAlumnoPage(Model model) {
		//System.out.println(cursoService.getListaCurso().size());
		model.addAttribute("curso", cursoService.getCurso());
		model.addAttribute("alumno", alumnoService.getAlumno());
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
		
		ModelAndView mavalumno = new ModelAndView("redirect:/alumno/mostrar");
		//ListaAlumno listaAlumnos = new ListaAlumno();
		if (alumnoService.guardarAlumno(alumno)) {
			LOGGER.info("Se agregó un objeto al arrayList Alumnos");
		}
		mavalumno.addObject("alumno", alumnoService.getListaAlumno());
		return mavalumno; 
	}
	
	@GetMapping("/mostrar")
	public String getAlumnosPage(Model model) {
		//ListaAlumno listaAlumnos = new ListaAlumno();
		model.addAttribute("alumno", alumnoService.getListaAlumno());
		return "mostrar_alumnos";
	}
	
	@GetMapping("/lista")
	public String getListaAlumnosPage(Model model) {
		//ListaAlumno listaAlumnos = new ListaAlumno();
		model.addAttribute("alumno", alumnoService.getListaAlumno());
		return "lista_alumnos";
	}
	
	@GetMapping("/editar/{dni}")
	public ModelAndView getEditarAlumnoPage(@PathVariable(value="dni")int dni) {
		ModelAndView mav = new ModelAndView("edicion_alumno");
		Alumno alumno = alumnoService.buscarAlumno(dni);
		mav.addObject("alumno",alumno);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosAlumno(@Validated @ModelAttribute("alumno") Alumno alumno, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+alumno);
			ModelAndView mav = new ModelAndView("edicion_alumno");
			mav.addObject("alumno", alumno);
			return mav;
		}
		
		
		ModelAndView mav = new ModelAndView("redirect:/alumno/lista");
		alumnoService.modificarAlumno(alumno);
		//mav.addObject("alumno", listaAlumnos.getAlumnos());
		
		return mav;
	}
	
	@GetMapping("/eliminar/{dni}")
	public ModelAndView getEliminarAlumnoPage(@PathVariable(value = "dni") int dni) {
		ModelAndView mavAlumno = new ModelAndView("redirect:/alumno/lista");
		alumnoService.eliminarAlumno(dni);
		LOGGER.info("Se eliminó el alumno");
		//mavAlumno.addObject("candidato", listaAlumnos.getAlumnos());
		return mavAlumno;
	}
}
	
