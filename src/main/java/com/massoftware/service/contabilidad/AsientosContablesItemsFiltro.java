package com.massoftware.service.contabilidad;

import com.massoftware.service.*;
import com.massoftware.service.contabilidad.AsientoContable;

public class AsientosContablesItemsFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Nº item (desde)
	private Integer numeroFrom;

	// Nº item (hasta)
	private Integer numeroTo;

	// Detalle
	private String detalle;

	// Asiento contable
	private AsientoContable asientoContable;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Nº item (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº item (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº item (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº item (hasta)
	public void setNumeroTo(Integer numeroTo){
		this.numeroTo = numeroTo;
	}

	// GET Detalle
	public String getDetalle() {
		return this.detalle;
	}

	// SET Detalle
	public void setDetalle(String detalle){
		this.detalle = (detalle == null || detalle.trim().length() == 0) ? null : detalle.trim();
	}

	// GET Asiento contable
	public AsientoContable getAsientoContable() {
		return this.asientoContable;
	}

	// SET Asiento contable
	public void setAsientoContable(AsientoContable asientoContable){
		this.asientoContable = asientoContable;
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		AsientosContablesItemsFiltro other = (AsientosContablesItemsFiltro) obj;
		
		
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
		
		if (other.getDetalle() == null && this.getDetalle() != null) {
			return false;
		}
		
		if (other.getDetalle() != null && this.getDetalle() == null) {
			return false;
		}
		
		if (other.getDetalle() != null && this.getDetalle() != null) {
		
			if (other.getDetalle().equals(this.getDetalle()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getAsientoContable() == null && this.getAsientoContable() != null) {
			return false;
		}
		
		if (other.getAsientoContable() != null && this.getAsientoContable() == null) {
			return false;
		}
		
		if (other.getAsientoContable() != null && this.getAsientoContable() != null) {
		
			if (other.getAsientoContable().equals(this.getAsientoContable()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		return true;
		
		// -------------------------------------------------------------------
	}
		
	public AsientosContablesItemsFiltro clone() {
		
		AsientosContablesItemsFiltro other = new AsientosContablesItemsFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		other.setNumeroFrom(this.getNumeroFrom());
		other.setNumeroTo(this.getNumeroTo());
		other.setDetalle(this.getDetalle());
		
		// -------------------------------------------------------------------
		
		if (this.getAsientoContable() != null) {
			other.setAsientoContable(this.getAsientoContable().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------