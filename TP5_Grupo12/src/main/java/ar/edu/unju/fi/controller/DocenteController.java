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

import ar.edu.unju.fi.entity.Docente;
import ar.edu.unju.fi.service.IDocenteService;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	@Qualifier("DocenteServiceImpSql")
	private IDocenteService docenteService;
	
	//ListaDocente listaDocentes = new ListaDocente();
	private static final Log LOGGER = LogFactory.getLog(DocenteController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoDocentePage(Model model) {
		model.addAttribute("docente", docenteService.getDocente());
		return "nuevo_docente";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaDocentesPage(@Validated @ModelAttribute("docente")Docente docente, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");

			ModelAndView mav = new ModelAndView("nuevo_docente");
			mav.addObject("docente", docente);
			return mav;
			
		}
		
		ModelAndView mavdocente = new ModelAndView("redirect:/docente/mostrar");
		//ListaDocente listaDocentes = new ListaDocente();
		if (docenteService.guardarDocente(docente)) {
			LOGGER.info("Se agregó un objeto al arrayList Docentes");
		}
		mavdocente.addObject("docente", docenteService.getListaDocente());
		return mavdocente; 
	}
	
	@GetMapping("/mostrar")
	public String getDocentesPage(Model model) {
		//ListaDocente listaDocentes = new ListaDocente();
		model.addAttribute("docente", docenteService.getListaDocente());
		return "mostrar_docentes";
	}
	
	@GetMapping("/lista")
	public String getListaDocentesPage(Model model) {
		//ListaDocente listaDocentes = new ListaDocente();
		model.addAttribute("docente", docenteService.getListaDocente());
		return "lista_docentes";
	}
	
	@GetMapping("/editar/{legajo}")
	public ModelAndView getEditarDocentePage(@PathVariable(value="legajo")int legajo) {
		ModelAndView mav = new ModelAndView("edicion_docente");
		Docente d = docenteService.buscarDocente(legajo);
		mav.addObject("docente", d);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosDocente(@Validated @ModelAttribute("docente") Docente docente, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+docente);
			ModelAndView mav = new ModelAndView("edicion_docente");
			mav.addObject("docente", docente);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("redirect:/docente/lista");
		docenteService.modificarDocente(docente);
		return mav;
	}
	
	@GetMapping("/eliminar/{legajo}")
	public ModelAndView getEliminarAlumnoPage(@PathVariable(value = "legajo") int legajo) {
		ModelAndView mavDocente = new ModelAndView("redirect:/docente/lista");
		docenteService.eliminarDocente(legajo);
		LOGGER.info("Se eliminó el docente" + legajo);		
		return mavDocente;
	}
}
