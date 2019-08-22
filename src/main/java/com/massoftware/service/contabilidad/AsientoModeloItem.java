package com.massoftware.service.contabilidad;

import com.massoftware.service.EntityId;
import com.massoftware.service.contabilidad.AsientoModelo;
import com.massoftware.service.contabilidad.CuentaContable;

public class AsientoModeloItem extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº item
	private Integer numero;

	// Asiento modelo
	private AsientoModelo asientoModelo;

	// Cuenta contable
	private CuentaContable cuentaContable;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº item
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº item
	public void setNumero(Integer numero ){
		this.numero = numero;
	}

	// GET Asiento modelo
	public AsientoModelo getAsientoModelo() {
		return this.asientoModelo;
	}

	// SET Asiento modelo
	public void setAsientoModelo(AsientoModelo asientoModelo ){
		this.asientoModelo = asientoModelo;
	}

	// GET Cuenta contable
	public CuentaContable getCuentaContable() {
		return this.cuentaContable;
	}

	// SET Cuenta contable
	public void setCuentaContable(CuentaContable cuentaContable ){
		this.cuentaContable = cuentaContable;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNumero() != null && this.getAsientoModelo() != null){
			return this.getNumero() + " - " +  this.getAsientoModelo();
		} else if(this.getNumero() != null && this.getAsientoModelo() == null){
			return this.getNumero().toString();
		} else if(this.getNumero() == null && this.getAsientoModelo() != null){
			return this.getAsientoModelo().toString();
		} else {
			return super.toString();
		}
	}
		
	public AsientoModeloItem clone() {
		
		AsientoModeloItem other = (AsientoModeloItem) super.clone();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		
		// -------------------------------------------------------------------
		
		if (this.getAsientoModelo() != null) {
			other.setAsientoModelo(this.getAsientoModelo().clone());
		}
		
		// -------------------------------------------------------------------
		
		if (this.getCuentaContable() != null) {
			other.setCuentaContable(this.getCuentaContable().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------