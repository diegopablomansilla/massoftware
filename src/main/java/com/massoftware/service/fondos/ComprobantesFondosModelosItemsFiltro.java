package com.massoftware.service.fondos;

import com.massoftware.service.*;
import com.massoftware.service.fondos.CuentaFondo;

public class ComprobantesFondosModelosItemsFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Nº modelo (desde)
	private Integer numeroFrom;

	// Nº modelo (hasta)
	private Integer numeroTo;

	// Cuenta fondo
	private CuentaFondo cuentaFondo;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Nº modelo (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº modelo (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº modelo (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº modelo (hasta)
	public void setNumeroTo(Integer numeroTo){
		this.numeroTo = numeroTo;
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
		
		ComprobantesFondosModelosItemsFiltro other = (ComprobantesFondosModelosItemsFiltro) obj;
		
		
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
		
	public ComprobantesFondosModelosItemsFiltro clone() {
		
		ComprobantesFondosModelosItemsFiltro other = new ComprobantesFondosModelosItemsFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		other.setNumeroFrom(this.getNumeroFrom());
		other.setNumeroTo(this.getNumeroTo());
		
		// -------------------------------------------------------------------
		
		if (this.getCuentaFondo() != null) {
			other.setCuentaFondo(this.getCuentaFondo().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------