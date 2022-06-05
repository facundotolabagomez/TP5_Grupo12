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

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.util.ListaAlumno;

@Controller
@RequestMapping("/alumno")
public class AlumnosController {
	ListaAlumno listaalumnos = new ListaAlumno();
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
	
	@GetMapping("/editar/{dni}")
	public ModelAndView getEditarAlumnoPage(@PathVariable(value="dni")int dni) {
		ModelAndView mav = new ModelAndView("edicion_alumno");
		Optional<Alumno> alumno = listaalumnos.getAlumnos().stream().filter(a -> a.getDni() == dni).findFirst();
		mav.addObject("alumno", alumno);
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
		
		ModelAndView mav = new ModelAndView("lista_alumnos");
		for(Alumno alum : listaalumnos.getAlumnos()) {
			if(alum.getDni() == alumno.getDni()) {
				alum.setNombre(alumno.getNombre());
				alum.setApellido(alumno.getApellido());
				alum.setEmail(alumno.getEmail());
				alum.setTelefono(alumno.getTelefono());
			}
			mav.addObject("alumno", alum);
		}
		mav.addObject("alumno", listaalumnos.getAlumnos());
		
		return mav;
	}
	
	@GetMapping("/eliminar/{dni}")
	public ModelAndView getEliminarAlumnoPage(@PathVariable(value = "dni") int dni) {
		ModelAndView mavAlumno = new ModelAndView("lista_alumnos");
		for (int i = listaalumnos.getAlumnos().size(); i > 0; i--) {
			//if (can.getCodigo() == codigo) {
			if (listaalumnos.getAlumnos().get(i-1).getDni() == dni) {
				LOGGER.info("Se elimino Alumno");
				listaalumnos.getAlumnos().remove(i-1);
			}
		}
		mavAlumno.addObject("candidato", listaalumnos.getAlumnos());
		return mavAlumno;
	}
}
	
