package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Cursos")
public class IndexController {
	
	@GetMapping("/inicio")
	public String getIndexPage(Model model) {
		return "index"; 
	}
	
	@GetMapping("/idioma")
	public String getIdiomaPage(Model model) {
		return "idioma"; 
	}
	
	@GetMapping("/beneficios")
	public String getBeneficiosPage(Model model) {
		return "beneficios"; 
	}
	
	@GetMapping("/agenda")
	public String getAgendaPage(Model model) {
		return "agenda"; 
	}
	
	@GetMapping("/contacto")
	public String getContactoPage(Model model) {
		return "contacto"; 
	}
	
//	@GetMapping("/nuevo_docente")
//	public String getNuevoDocentePage(Model model) {
//		return "nuevo_docente"; 
//	}
}