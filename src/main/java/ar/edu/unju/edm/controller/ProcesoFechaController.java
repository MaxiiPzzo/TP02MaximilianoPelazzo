package ar.edu.unju.edm.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.ProcesoFecha;

@Controller
public class ProcesoFechaController {
	
	@GetMapping("/procesoFecha")
	public ModelAndView cargarFecha() {
		ProcesoFecha nuevoProcesoFecha = new ProcesoFecha();
		
		ModelAndView modelAndView = new ModelAndView("procesoFecha");
		modelAndView.addObject("procesoFecha", nuevoProcesoFecha);
		
		return modelAndView;
	}
	
	@PostMapping("/guardarProcesoFecha")
	public ModelAndView guardarProcesoFecha(@ModelAttribute("procesoFecha") ProcesoFecha procesoFechaGuardar) {
		procesoFechaGuardar = compararFechas(procesoFechaGuardar);
		ModelAndView modelAndView = new ModelAndView("resultadoFecha");
		return modelAndView;
	}
	public ProcesoFecha compararFechas(ProcesoFecha fecha) {
		LocalDate fecha1 = fecha.getFecha1();
		LocalDate fecha2 = fecha.getFecha2();
		
		Period p = Period.between(fecha1, fecha2);
		if ( fecha1.isEqual(fecha2) )
			fecha.setMensaje1("La fecha1 es igual a la fecha2");
		else if (fecha1.isAfter(fecha2)) {
			fecha.setMensaje1("La fecha1 es posterior a la fecha2");
			p = Period.between(fecha2, fecha1);
		}
		else
			fecha.setMensaje1("La fecha1 es anterior a la fecha2");
		
		fecha.setMensaje2("Han transcurrido " + p.getYears() + " años, " + p.getMonths() + " meses y " + p.getDays() + " dias desde la fecha menor hasta la fecha mayor");
		
		return fecha;
	}
	public ProcesoFechaController() {
		// TODO Auto-generated constructor stub
	}

}
