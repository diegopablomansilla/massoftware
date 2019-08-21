package com.massoftware.service.fondos.banco;

import com.massoftware.model.EntityId;

public class BancoFirmante extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº firmante
	private Integer numero;

	// Nombre
	private String nombre;

	// Cargo
	private String cargo;

	// Obsoleto
	private Boolean bloqueado;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº firmante
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº firmante
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

	// GET Cargo
	public String getCargo() {
		return this.cargo;
	}

	// SET Cargo
	public void setCargo(String cargo ){
		this.cargo = (cargo == null || cargo.trim().length() == 0) ? null : cargo.trim();
	}

	// GET Obsoleto
	public Boolean getBloqueado() {
		return this.bloqueado;
	}

	// SET Obsoleto
	public void setBloqueado(Boolean bloqueado ){
		this.bloqueado = (bloqueado == null) ? false : bloqueado;
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