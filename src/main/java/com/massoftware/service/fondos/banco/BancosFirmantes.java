package com.massoftware.service.fondos.banco;

import com.massoftware.model.EntityId;

public class BancosFirmantes extends EntityId {

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

} // END CLASS ----------------------------------------------------------------------------------------------------------