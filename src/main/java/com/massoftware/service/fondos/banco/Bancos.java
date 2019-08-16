package com.massoftware.service.fondos.banco;

import com.massoftware.model.EntityId;

public class Bancos extends EntityId {

	private String id;

	// Nº banco
	private Integer numero;

	// Nombre
	private String nombre;

	// CUIT
	private Long cuit;

	// Obsoleto
	private Boolean bloqueado = false;

	// ---------------------------------------------------------------------------------------------------------------------------

	// GET ID
	public String getId() {
		this.id = (id != null && id.trim().length() > 0) ? id.trim() : null;
		return this.id;
	}

	// SET ID
	public void setId(String id) {		
		this.id = (id != null && id.trim().length() > 0) ? id.trim() : null;
	}

	// GET Nº banco
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº banco
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}

	// SET Nombre
	public void setNombre(String nombre) {
		this.nombre = (nombre != null && nombre.trim().length() > 0) ? nombre.trim() : null;
	}

	// GET CUIT
	public Long getCuit() {
		return this.cuit;
	}

	// SET CUIT
	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	// GET Obsoleto
	public Boolean getBloqueado() {
		return this.bloqueado;
	}

	// SET Obsoleto
	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = (bloqueado == null) ? false : bloqueado;
	}
	
	public String toString() {
		if (this.getNumero() != null && this.getNombre() != null) {
			return this.getNumero() + " - " + this.getNombre();
		} else if (this.getNumero() != null && this.getNombre() == null) {
			return this.getNumero().toString();
		} else if (this.getNumero() == null && this.getNombre() != null) {
			return this.getNombre();
		} else {
			return super.toString();
		}
	}

}
