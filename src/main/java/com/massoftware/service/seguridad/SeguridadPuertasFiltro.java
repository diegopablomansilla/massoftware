package com.massoftware.service.seguridad;

import com.massoftware.service.*;
import com.massoftware.service.seguridad.SeguridadModulo;

public class SeguridadPuertasFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Módulo
	private SeguridadModulos seguridadModulo;

	// Nº puerta (desde)
	private Integer numeroFrom;

	// Nº puerta (hasta)
	private Integer numeroTo;

	// Nombre
	private String nombre;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Módulo
	public SeguridadModulos getSeguridadModulo() {
		return this.seguridadModulo;
	}

	// SET Módulo
	public void setSeguridadModulo(SeguridadModulos seguridadModulo){
		this.seguridadModulo = seguridadModulo;
	}

	// GET Nº puerta (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº puerta (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº puerta (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº puerta (hasta)
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
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		SeguridadPuertasFiltro other = (SeguridadPuertasFiltro) obj;
		
		
		// -------------------------------------------------------------------
		
		if (other.getSeguridadModulo() == null && this.getSeguridadModulo() != null) {
			return false;
		}
		
		if (other.getSeguridadModulo() != null && this.getSeguridadModulo() == null) {
			return false;
		}
		
		if (other.getSeguridadModulo() != null && this.getSeguridadModulo() != null) {
		
			if (other.getSeguridadModulo().equals(this.getSeguridadModulo()) == false) {
				return false;
			}
		
		}
		
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
		
		return true;
		
		// -------------------------------------------------------------------
	}
		
	public SeguridadPuertasFiltro clone() {
		
		SeguridadPuertasFiltro other = new SeguridadPuertasFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		
		// -------------------------------------------------------------------
		
		if (this.getSeguridadModulo() != null) {
			other.setSeguridadModulo(this.getSeguridadModulo().clone());
		}
		other.setNumeroFrom(this.getNumeroFrom());
		other.setNumeroTo(this.getNumeroTo());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------