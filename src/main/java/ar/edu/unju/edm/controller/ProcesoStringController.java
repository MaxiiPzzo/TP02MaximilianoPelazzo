package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.ProcesoString;

@Controller
public class ProcesoStringController {
	
	@GetMapping("/procesoString")
	public ModelAndView cargarString() {
		ProcesoString nuevoProcesoFecha = new ProcesoString();
		
		ModelAndView modelAndView = new ModelAndView("procesoString");
		modelAndView.addObject("procesoString", nuevoProcesoFecha);
		
		return modelAndView;
	}
	
	@PostMapping("/guardarProcesoString")
	public ModelAndView guardarProcesoFecha(@ModelAttribute("procesoString") ProcesoString procesoStringGuardar) {
		procesoStringGuardar = determinarLongitud(procesoStringGuardar);
		procesoStringGuardar = invertirCadena(procesoStringGuardar);
		ModelAndView modelAndView = new ModelAndView("resultadoString");
		return modelAndView;
	}

	public ProcesoString determinarLongitud(ProcesoString procesoString) {
		
		int vocales = 0;
		String aux = procesoString.getCadena().toLowerCase();
		for (int i = 0; i< aux.length(); i++) {
			 if (aux.charAt(i) == 'a' || aux.charAt(i) == 'e'|| aux.charAt(i) == 'i'|| aux.charAt(i) == 'o'|| aux.charAt(i) == 'u')
				 vocales++;
		}
		
		procesoString.setMensaje1("La cadena tiene " + procesoString.getCadena().length() + " caracteres y " + vocales + " vocales");
		
		String[] palabras = procesoString.getCadena().split("\\s+");
		procesoString.setMensaje2("La cadena tiene " + palabras.length + " palabras");
		
		return procesoString;
	}
	public ProcesoString invertirCadena(ProcesoString procesoString) {
		StringBuilder stringBuilder = new StringBuilder(procesoString.getCadena().replaceAll("\\s", ""));
		procesoString.setCadenaInvertida(stringBuilder.reverse().toString());
		
		return procesoString;
	}
	
}
