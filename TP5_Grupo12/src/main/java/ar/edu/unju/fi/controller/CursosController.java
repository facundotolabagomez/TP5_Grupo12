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


import ar.edu.unju.fi.model.Curso;

import ar.edu.unju.fi.util.ListaCurso;


@Controller
@RequestMapping("/cursos")
public class CursosController {
	ListaCurso listacurso = new ListaCurso();
	private static final Log LOGGER = LogFactory.getLog(CursosController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoCursoPage(Model model) {
		model.addAttribute("curso", new Curso());
		return "nuevo_curso";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaCursosPage(@Validated @ModelAttribute("curso")Curso curso, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");

			ModelAndView mav = new ModelAndView("nuevo_curso");
			mav.addObject("curso", curso);
			return mav;
			
		}
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
	
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarCursoPage(@PathVariable(value="codigo")int codigo) {
		ModelAndView mav = new ModelAndView("edicion_curso");
		Optional<Curso> curso = listacurso.getCursos().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		mav.addObject("curso", curso);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosCurso(@Validated @ModelAttribute("curso") Curso curso, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+curso);
			ModelAndView mav = new ModelAndView("edicion_curso");
			mav.addObject("curso", curso);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("lista_cursos");
		for(Curso cur : listacurso.getCursos()) {
			if(cur.getCodigo() == curso.getCodigo()) {
				cur.setTitulo(curso.getTitulo());
				cur.setCategoria(curso.getCategoria());
				cur.setInicio(curso.getInicio());
				cur.setCantidadDeHoras(curso.getCantidadDeHoras());
				cur.setModalidad(curso.getModalidad());
				cur.setDocente(curso.getDocente());				
			}
			mav.addObject("curso", cur);
		}
		mav.addObject("curso", listacurso.getCursos());
		
		return mav;
	}
	
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView getEliminarCursoPage(@PathVariable(value = "codigo") int codigo) {
		ModelAndView mavCurso = new ModelAndView("lista_cursos");
		for (int i = listacurso.getCursos().size(); i > 0; i--) {
			//if (can.getCodigo() == codigo) {
			if (listacurso.getCursos().get(i-1).getCodigo() == codigo) {
				LOGGER.info("Se elimino Curso");
				listacurso.getCursos().remove(i-1);
			}
		}
		mavCurso.addObject("curso", listacurso.getCursos());
		return mavCurso;
	}
}