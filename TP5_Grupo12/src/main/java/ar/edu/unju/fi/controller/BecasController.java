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

import ar.edu.unju.fi.model.Beca;
import ar.edu.unju.fi.util.ListaBeca;




@Controller
@RequestMapping("/beneficios")
public class BecasController {
	private static final Log LOGGER = LogFactory.getLog(BecasController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoBecaPage(Model model) {
		model.addAttribute("beca", new Beca());
		return "nuevo_beca";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaBecasPage(@ModelAttribute("beca")Beca beca) {
		ModelAndView mavbeca = new ModelAndView("mostrar_becas");
		ListaBeca listaBeca = new ListaBeca();
		if (listaBeca.getBecas().add(beca)) {
			LOGGER.info("Se agregó un objeto al arrayList Becas");
		}
		mavbeca.addObject("beca", listaBeca.getBecas());
		return mavbeca; 
	}
	
	@GetMapping("/mostrar")
	public String getBecasPage(Model model) {
		ListaBeca listaBeca = new ListaBeca();
		model.addAttribute("beca", listaBeca.getBecas());
		return "mostrar_becas";
	}
	
	@GetMapping("/lista")
	public String getListaBecasPage(Model model) {
		ListaBeca listaBeca = new ListaBeca();
		model.addAttribute("beca", listaBeca.getBecas());
		return "lista_beca";
	}
	
}