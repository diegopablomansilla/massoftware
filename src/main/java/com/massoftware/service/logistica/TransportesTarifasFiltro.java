package com.massoftware.service.logistica;

import com.massoftware.service.*;

public class TransportesTarifasFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Transporte
	private Transportes transporte;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Transporte
	public Transportes getTransporte() {
		return this.transporte;
	}

	// SET Transporte
	public void setTransporte(Transportes transporte){
		this.transporte = transporte;
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		TransportesTarifasFiltro other = (TransportesTarifasFiltro) obj;
		
		
		// -------------------------------------------------------------------
		
		if (other.getTransporte() == null && this.getTransporte() != null) {
			return false;
		}
		
		if (other.getTransporte() != null && this.getTransporte() == null) {
			return false;
		}
		
		if (other.getTransporte() != null && this.getTransporte() != null) {
		
			if (other.getTransporte().equals(this.getTransporte()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		return true;
		
		// -------------------------------------------------------------------
	}
		
	public TransportesTarifasFiltro clone() {
		
		TransportesTarifasFiltro other = new TransportesTarifasFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		
		// -------------------------------------------------------------------
		
		if (this.getTransporte() != null) {
			other.setTransporte(this.getTransporte().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------