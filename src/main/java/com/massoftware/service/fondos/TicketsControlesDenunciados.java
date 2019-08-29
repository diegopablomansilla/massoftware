package com.massoftware.service.fondos;

import com.massoftware.service.EntityId;

public class TicketsControlesDenunciados extends EntityId implements Cloneable {

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
		
	public TicketsControlesDenunciados clone() {
		
		TicketsControlesDenunciados other = new TicketsControlesDenunciados();
		
		other.setId(this.getId());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------