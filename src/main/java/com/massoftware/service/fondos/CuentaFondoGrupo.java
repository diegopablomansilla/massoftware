package com.massoftware.service.fondos;

import com.massoftware.service.EntityId;
import com.massoftware.service.fondos.CuentaFondoRubro;

public class CuentaFondoGrupo extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº grupo
	private Integer numero;

	// Nombre
	private String nombre;

	// Rubro
	private CuentaFondoRubro cuentaFondoRubro;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº grupo
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº grupo
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

	// GET Rubro
	public CuentaFondoRubro getCuentaFondoRubro() {
		return this.cuentaFondoRubro;
	}

	// SET Rubro
	public void setCuentaFondoRubro(CuentaFondoRubro cuentaFondoRubro ){
		this.cuentaFondoRubro = cuentaFondoRubro;
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
		
	public CuentaFondoGrupo clone() {
		
		CuentaFondoGrupo other = (CuentaFondoGrupo) super.clone();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		if (this.getCuentaFondoRubro() != null) {
			other.setCuentaFondoRubro(this.getCuentaFondoRubro().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------