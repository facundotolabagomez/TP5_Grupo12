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


import ar.edu.unju.fi.model.Beca;

import ar.edu.unju.fi.util.ListaBeca;




@Controller
@RequestMapping("/beneficios")
public class BecasController {
	ListaBeca listaBecas = new ListaBeca();
	private static final Log LOGGER = LogFactory.getLog(BecasController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoBecaPage(Model model) {
		model.addAttribute("beca", new Beca());
		return "nuevo_beca";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaBecasPage(@Validated @ModelAttribute("beca")Beca beca,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");

			ModelAndView mav = new ModelAndView("nuevo_beca");
			mav.addObject("beca",beca);
			return mav;
			
		}
		
		
		ModelAndView mavbeca = new ModelAndView("mostrar_becas");
		//ListaBeca listaBeca = new ListaBeca();
		if (listaBecas.getBecas().add(beca)) {
			LOGGER.info("Se agregó un objeto al arrayList Becas");
		}
		mavbeca.addObject("beca", listaBecas.getBecas());
		return mavbeca; 
	}
	
	@GetMapping("/mostrar")
	public String getBecasPage(Model model) {
		//ListaBeca listaBeca = new ListaBeca();
		model.addAttribute("beca", listaBecas.getBecas());
		return "mostrar_becas";
	}
	
	@GetMapping("/lista")
	public String getListaBecasPage(Model model) {
		//ListaBeca listaBeca = new ListaBeca();
		model.addAttribute("beca", listaBecas.getBecas());
		return "lista_beca";
	}
	
	@GetMapping("/editar/{codigo}")	
	public ModelAndView getEditarBecaPage(@PathVariable(value="codigo")int codigo) {
		//ListaBeca listabecas = new ListaBeca();
		ModelAndView mav = new ModelAndView("edicion_beca");
		Optional<Beca> beca = listaBecas.getBecas().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		mav.addObject("beca", beca);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosBeca(@Validated @ModelAttribute("beca") Beca beca, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+beca);
			ModelAndView mav = new ModelAndView("edicion_beca");
			mav.addObject("beca", beca);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("lista_beca");
		for(Beca bec : listaBecas.getBecas()) {
			if(bec.getCodigo() == beca.getCodigo()) {
				bec.setCurso(beca.getCurso());
				bec.setInicio(beca.getInicio());
				bec.setCierre(beca.getCierre());
				bec.setEstado(beca.getEstado());
			}
			mav.addObject("beca", bec);
		}
		mav.addObject("beca", listaBecas.getBecas());
		
		return mav;
	}

	@GetMapping("/eliminar/{codigo}")
	public ModelAndView getEliminarBecaPage(@PathVariable(value = "codigo") int codigo) {
		ModelAndView mavBeca = new ModelAndView("lista_beca");
		for (int i = listaBecas.getBecas().size(); i > 0; i--) {
			//if (can.getCodigo() == codigo) {
			if (listaBecas.getBecas().get(i-1).getCodigo() == codigo) {
				LOGGER.info("Se elimino Beca");
				listaBecas.getBecas().remove(i-1);
			}
		}
		mavBeca.addObject("beca", listaBecas.getBecas());
		return mavBeca;
	}
	

}
