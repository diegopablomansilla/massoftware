package com.massoftware.service.geo;

import com.massoftware.service.EntityId;

public class Zona extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Código
	private String codigo;

	// Nombre
	private String nombre;

	// Bonificación
	private Double bonificacion;

	// Recargo
	private Double recargo;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Código
	public String getCodigo() {
		return this.codigo;
	}

	// SET Código
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

	// GET Bonificación
	public Double getBonificacion() {
		return this.bonificacion;
	}

	// SET Bonificación
	public void setBonificacion(Double bonificacion ){
		this.bonificacion = bonificacion;
	}

	// GET Recargo
	public Double getRecargo() {
		return this.recargo;
	}

	// SET Recargo
	public void setRecargo(Double recargo ){
		this.recargo = recargo;
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
		
	public Zona clone() {
		
		Zona other = (Zona) super.clone();
		
		other.setId(this.getId());
		other.setCodigo(this.getCodigo());
		other.setNombre(this.getNombre());
		other.setBonificacion(this.getBonificacion());
		other.setRecargo(this.getRecargo());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------