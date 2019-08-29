package com.massoftware.service.empresa;

import com.massoftware.service.EntityId;

public class Sucursales extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Tipo sucursal
	private String nombreTipoSucursal;

	// Nº sucursal
	private Integer numero;

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

	// GET Tipo sucursal
	public String getNombreTipoSucursal() {
		return this.nombreTipoSucursal;
	}

	// SET Tipo sucursal
	public void setNombreTipoSucursal(String nombreTipoSucursal ){
		this.nombreTipoSucursal = (nombreTipoSucursal == null || nombreTipoSucursal.trim().length() == 0) ? null : nombreTipoSucursal.trim();
	}

	// GET Nº sucursal
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº sucursal
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

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNombreTipoSucursal() != null && this.getNumero() != null){
			return this.getNombreTipoSucursal() + " - " +  this.getNumero();
		} else if(this.getNombreTipoSucursal() != null && this.getNumero() == null){
			return this.getNombreTipoSucursal();
		} else if(this.getNombreTipoSucursal() == null && this.getNumero() != null){
			return this.getNumero().toString();
		} else {
			return super.toString();
		}
	}
		
	public Sucursales clone() {
		
		Sucursales other = new Sucursales();
		
		other.setId(this.getId());
		other.setNombreTipoSucursal(this.getNombreTipoSucursal());
		other.setNumero(this.getNumero());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------