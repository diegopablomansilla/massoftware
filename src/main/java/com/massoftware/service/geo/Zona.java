package com.massoftware.service.geo;

import com.massoftware.model.EntityId;

public class Zona extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Código
	private String codigo;

	// Nombre
	private String nombre;

	// Bonificación
	private java.math.BigDecimal bonificacion;

	// Recargo
	private java.math.BigDecimal recargo;

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
	public java.math.BigDecimal getBonificacion() {
		return this.bonificacion;
	}

	// SET Bonificación
	public void setBonificacion(java.math.BigDecimal bonificacion ){
		this.bonificacion = bonificacion;
	}

	// GET Recargo
	public java.math.BigDecimal getRecargo() {
		return this.recargo;
	}

	// SET Recargo
	public void setRecargo(java.math.BigDecimal recargo ){
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

} // END CLASS ----------------------------------------------------------------------------------------------------------