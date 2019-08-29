package com.massoftware.service.contabilidad;

import com.massoftware.service.EntityId;

public class AsientosModelos extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
			return super.toString();
	}
		
	public AsientosModelos clone() {
		
		AsientosModelos other = new AsientosModelos();
		
		other.setId(this.getId());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------