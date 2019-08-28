package com.massoftware.service.contabilidad;

import com.massoftware.service.*;

public class AsientosModelosItemsFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Asiento modelo
	private AsientosModelos asientoModelo;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Asiento modelo
	public AsientosModelos getAsientoModelo() {
		return this.asientoModelo;
	}

	// SET Asiento modelo
	public void setAsientoModelo(AsientosModelos asientoModelo){
		this.asientoModelo = asientoModelo;
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		AsientosModelosItemsFiltro other = (AsientosModelosItemsFiltro) obj;
		
		
		// -------------------------------------------------------------------
		
		if (other.getAsientoModelo() == null && this.getAsientoModelo() != null) {
			return false;
		}
		
		if (other.getAsientoModelo() != null && this.getAsientoModelo() == null) {
			return false;
		}
		
		if (other.getAsientoModelo() != null && this.getAsientoModelo() != null) {
		
			if (other.getAsientoModelo().equals(this.getAsientoModelo()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		return true;
		
		// -------------------------------------------------------------------
	}
		
	public AsientosModelosItemsFiltro clone() {
		
		AsientosModelosItemsFiltro other = new AsientosModelosItemsFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		
		// -------------------------------------------------------------------
		
		if (this.getAsientoModelo() != null) {
			other.setAsientoModelo(this.getAsientoModelo().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------