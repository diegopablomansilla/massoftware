package com.massoftware.service.fondos;

import com.massoftware.service.EntityId;

public class TalonarioControladorFizcal extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº controlador
	private String codigo;

	// Nombre
	private String nombre;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº controlador
	public String getCodigo() {
		return this.codigo;
	}

	// SET Nº controlador
	public void setCodigo(String codigo ){
		this.codigo = (codigo == null || codigo.trim().length() == 0) ? null : codigo.trim();
	}

	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}

	// SET Nombre
	public void setNombre(String nombre ){
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getCodigo() != null && this.getNombre() != null){
			return this.getCodigo() + " - " +  this.getNombre();
		} else if(this.getCodigo() != null && this.getNombre() == null){
			return this.getCodigo();
		} else if(this.getCodigo() == null && this.getNombre() != null){
			return this.getNombre();
		} else {
			return super.toString();
		}
	}
		
	public TalonarioControladorFizcal clone() {
		
		TalonarioControladorFizcal other = (TalonarioControladorFizcal) super.clone();
		
		other.setId(this.getId());
		other.setCodigo(this.getCodigo());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------