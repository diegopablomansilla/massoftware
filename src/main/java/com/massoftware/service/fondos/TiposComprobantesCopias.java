package com.massoftware.service.fondos;

import com.massoftware.service.EntityId;

public class TiposComprobantesCopias extends EntityId implements Cloneable {

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
		
	public TiposComprobantesCopias clone() {
		
		TiposComprobantesCopias other = new TiposComprobantesCopias();
		
		other.setId(this.getId());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------