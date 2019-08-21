package com.massoftware.service.fondos;

import com.massoftware.service.*;
import com.massoftware.service.fondos.CuentaFondo;

public class ChequerasFiltro extends AbstractFilter {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Nº chequera (desde)
	private Integer numeroFrom;

	// Nº chequera (hasta)
	private Integer numeroTo;

	// Nombre
	private String nombre;

	// Cuenta fondo
	private CuentaFondo cuentaFondo;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Nº chequera (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº chequera (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº chequera (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº chequera (hasta)
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

	// GET Cuenta fondo
	public CuentaFondo getCuentaFondo() {
		return this.cuentaFondo;
	}

	// SET Cuenta fondo
	public void setCuentaFondo(CuentaFondo cuentaFondo){
		this.cuentaFondo = cuentaFondo;
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		ChequerasFiltro other = (ChequerasFiltro) obj;
		
		
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
		
		if (other.getCuentaFondo() == null && this.getCuentaFondo() != null) {
			return false;
		}
		
		if (other.getCuentaFondo() != null && this.getCuentaFondo() == null) {
			return false;
		}
		
		if (other.getCuentaFondo() != null && this.getCuentaFondo() != null) {
		
			if (other.getCuentaFondo().equals(this.getCuentaFondo()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		return true;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------