package com.massoftware.service.contabilidad;

import com.massoftware.service.*;

public class EjerciciosContablesFiltro extends AbstractFilter {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Nº ejercicio (desde)
	private Integer numeroFrom;

	// Nº ejercicio (hasta)
	private Integer numeroTo;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Nº ejercicio (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº ejercicio (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº ejercicio (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº ejercicio (hasta)
	public void setNumeroTo(Integer numeroTo){
		this.numeroTo = numeroTo;
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		EjerciciosContablesFiltro other = (EjerciciosContablesFiltro) obj;
		
		
		// -------------------------------------------------------------------
		
		if (other.getNumeroFrom() == null && this.getNumeroFrom() != null) {
			return false;
		}
		
		if (other.getNumeroFrom() != null && this.getNumeroFrom() == null) {
			return false;
		}
		
		if (other.getNumeroFrom() != null && this.getNumeroFrom() != null) {
		
			if (other.getNumeroFrom().equals(this.getNumeroFrom()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getNumeroTo() == null && this.getNumeroTo() != null) {
			return false;
		}
		
		if (other.getNumeroTo() != null && this.getNumeroTo() == null) {
			return false;
		}
		
		if (other.getNumeroTo() != null && this.getNumeroTo() != null) {
		
			if (other.getNumeroTo().equals(this.getNumeroTo()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		return true;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------