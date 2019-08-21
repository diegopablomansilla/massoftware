package com.massoftware.service.contabilidad;

import com.massoftware.service.*;
import com.massoftware.service.contabilidad.EjercicioContable;

public class PuntosEquilibriosFiltro extends AbstractFilter {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Nº cc (desde)
	private Integer numeroFrom;

	// Nº cc (hasta)
	private Integer numeroTo;

	// Nombre
	private String nombre;

	// Ejercicio
	private EjercicioContable ejercicioContable;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Nº cc (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº cc (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº cc (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº cc (hasta)
	public void setNumeroTo(Integer numeroTo){
		this.numeroTo = numeroTo;
	}

	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}

	// SET Nombre
	public void setNombre(String nombre){
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}

	// GET Ejercicio
	public EjercicioContable getEjercicioContable() {
		return this.ejercicioContable;
	}

	// SET Ejercicio
	public void setEjercicioContable(EjercicioContable ejercicioContable){
		this.ejercicioContable = ejercicioContable;
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		PuntosEquilibriosFiltro other = (PuntosEquilibriosFiltro) obj;
		
		
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
		
		if (other.getNombre() == null && this.getNombre() != null) {
			return false;
		}
		
		if (other.getNombre() != null && this.getNombre() == null) {
			return false;
		}
		
		if (other.getNombre() != null && this.getNombre() != null) {
		
			if (other.getNombre().equals(this.getNombre()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getEjercicioContable() == null && this.getEjercicioContable() != null) {
			return false;
		}
		
		if (other.getEjercicioContable() != null && this.getEjercicioContable() == null) {
			return false;
		}
		
		if (other.getEjercicioContable() != null && this.getEjercicioContable() != null) {
		
			if (other.getEjercicioContable().equals(this.getEjercicioContable()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		return true;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------