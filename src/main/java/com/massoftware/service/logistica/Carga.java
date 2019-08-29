package com.massoftware.service.logistica;

import com.massoftware.service.EntityId;
import com.massoftware.service.logistica.Transporte;

public class Carga extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº carga
	private Integer numero;

	// Nombre
	private String nombre;

	// Transporte
	private Transporte transporte;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº carga
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº carga
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

	// GET Transporte
	public Transporte getTransporte() {
		return this.transporte;
	}

	// SET Transporte
	public void setTransporte(Transporte transporte ){
		this.transporte = transporte;
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
		
	public Carga clone() {
		
		Carga other = new Carga();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		if (this.getTransporte() != null) {
			other.setTransporte(this.getTransporte().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------