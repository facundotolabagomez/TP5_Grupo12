package ar.edu.unju.fi.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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


import ar.edu.unju.fi.model.Docente;

import ar.edu.unju.fi.util.ListaDocente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	ListaDocente listaDocentes = new ListaDocente();
	private static final Log LOGGER = LogFactory.getLog(DocenteController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoDocentePage(Model model) {
		model.addAttribute("docente", new Docente());
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
		
		ModelAndView mavdocente = new ModelAndView("mostrar_docentes");
		//ListaDocente listaDocentes = new ListaDocente();
		if (listaDocentes.getDocentes().add(docente)) {
			LOGGER.info("Se agregó un objeto al arrayList Docentes");
		}
		mavdocente.addObject("docente", listaDocentes.getDocentes());
		return mavdocente; 
	}
	
	@GetMapping("/mostrar")
	public String getDocentesPage(Model model) {
		//ListaDocente listaDocentes = new ListaDocente();
		model.addAttribute("docente", listaDocentes.getDocentes());
		return "mostrar_docentes";
	}
	
	@GetMapping("/lista")
	public String getListaDocentesPage(Model model) {
		//ListaDocente listaDocentes = new ListaDocente();
		model.addAttribute("docente", listaDocentes.getDocentes());
		return "lista_docentes";
	}
	
	@GetMapping("/editar/{legajo}")
	public ModelAndView getEditarDocentePage(@PathVariable(value="legajo")int legajo) {
		ModelAndView mav = new ModelAndView("edicion_docente");
		Optional<Docente> docente = listaDocentes.getDocentes().stream().filter(a -> a.getLegajo() == legajo).findFirst();
		mav.addObject("docente", docente);
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
		
		ModelAndView mav = new ModelAndView("lista_docentes");
		for(Docente docen : listaDocentes.getDocentes()) {
			if(docen.getLegajo() == docente.getLegajo()) {
				docen.setNombre(docente.getNombre());
				docen.setApellido(docente.getApellido());
				docen.setEmail(docente.getEmail());
				docen.setTelefono(docente.getTelefono());
			}
			mav.addObject("docente", docente);
		}
		mav.addObject("docente", listaDocentes.getDocentes());
		
		return mav;
	}
	
	@GetMapping("/eliminar/{legajo}")
	public ModelAndView getEliminarAlumnoPage(@PathVariable(value = "legajo") int legajo) {
		ModelAndView mavDocente = new ModelAndView("lista_docentes");
		for (int i = listaDocentes.getDocentes().size(); i > 0; i--) {
			//if (can.getCodigo() == codigo) {
			if (listaDocentes.getDocentes().get(i-1).getLegajo() == legajo) {
				LOGGER.info("Se elimino Docente");
				listaDocentes.getDocentes().remove(i-1);
			}
		}
		mavDocente.addObject("docente", listaDocentes.getDocentes());
		return mavDocente;
	}
}
