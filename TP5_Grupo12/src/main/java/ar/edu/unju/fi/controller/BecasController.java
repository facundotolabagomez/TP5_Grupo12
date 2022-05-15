package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.util.ListaBeca;

@Controller
@RequestMapping("/Cursos")
public class BecasController {

	@GetMapping("/beneficios")
	public String getBeneficioPage(Model model) {
		ListaBeca listabecas = new ListaBeca();
		model.addAttribute("becas", listabecas.getBecas());
		return "beneficios";
	}
	
//	@GetMapping("/becas")
//	public String getBeneficiosPage(Model model) {
//		ListaBeca listabecas = new ListaBeca();
//		model.addAttribute("becas", listabecas.getBecas());
//		return "beneficios"; 
//	}
}
 