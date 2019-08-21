package com.massoftware.service.clientes;

import com.massoftware.model.EntityId;

public class ClasificacionCliente extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº clasificación
	private Integer numero;

	// Nombre
	private String nombre;

	// Color
	private Integer color;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº clasificación
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº clasificación
	public void setNumero(Integer numero ){
		this.numero = numero;
	}

	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}

	// SET Nombre
	public void setNombre(String nombre ){
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}

	// GET Color
	public Integer getColor() {
		return this.color;
	}

	// SET Color
	public void setColor(Integer color ){
		this.color = color;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNumero() != null && this.getNombre() != null){
			return this.getNumero() + " - " +  this.getNombre();
		} else if(this.getNumero() != null && this.getNombre() == null){
			return this.getNumero().toString();
		} else if(this.getNumero() == null && this.getNombre() != null){
			return this.getNombre();
		} else {
			return super.toString();
		}
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------