package com.massoftware.service.contabilidad;

import com.massoftware.service.*;
import com.massoftware.service.contabilidad.AsientoModelo;

public class AsientosModelosItemsFiltro extends AbstractFilter {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Asiento modelo
	private AsientoModelo asientoModelo;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Asiento modelo
	public AsientoModelo getAsientoModelo() {
		return this.asientoModelo;
	}

	// SET Asiento modelo
	public void setAsientoModelo(AsientoModelo asientoModelo){
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

} // END CLASS ----------------------------------------------------------------------------------------------------------