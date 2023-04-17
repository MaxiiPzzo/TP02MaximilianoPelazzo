package ar.edu.unju.edm.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Controller;

@Controller
public class PersonaController {

	public PersonaController() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer determinarEdad(LocalDate fechaNacimiento) {
		
		LocalDate fechaHoy = LocalDate.now();
		Period p = Period.between(fechaNacimiento, fechaHoy);	
		return p.getYears();
		
	}
	
	public String determinarSignoZodiacal(LocalDate fechaNacimiento) {
		
		int dia = fechaNacimiento.getDayOfYear();
		if (fechaNacimiento.isLeapYear() && dia>60)
			dia--;
		
		if( dia<=20 || dia>=355)
			return ("capricorno");
		else if( dia<=51 ) 
			return ("acuario");
		else if( dia<=79 ) 
			return ("piscis");
		else if( dia<=110 )
			return ("aries");
		else if( dia<=140 ) 
			return ("tauro");
		else if( dia<=171 )
			return ("géminis");
		else if( dia<=201 )
			return ("cáncer");
		else if( dia<=232 )
			return ("leo");
		else if( dia<=263 )
			return ("virgo");
		else if( dia<=293 )
			return ("libra");
		else if( dia<=324 )
			return ("escorpio");
		
		return ("sagitario");
	}
	
	public String determinarEstacion(LocalDate fechaNacimiento) {
		
		int dia = fechaNacimiento.getDayOfYear();
		if (fechaNacimiento.isLeapYear() && dia>60) 
			dia--;

		if( dia<=79 || dia>=355) 
			return ("verano");
		else if ( dia<=171 )
			return ("otoño");
		else if ( dia<=263 )
			return ("invierno");
		
		return ("primavera");
		
	}
}
