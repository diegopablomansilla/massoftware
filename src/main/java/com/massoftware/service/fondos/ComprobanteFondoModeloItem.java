package com.massoftware.service.fondos;

import com.massoftware.service.EntityId;
import com.massoftware.service.fondos.ComprobanteFondoModelo;
import com.massoftware.service.fondos.CuentaFondo;

public class ComprobanteFondoModeloItem extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº modelo
	private Integer numero;

	// Debe
	private Boolean debe;

	// Modelo
	private ComprobanteFondoModelo comprobanteFondoModelo;

	// Cuenta fondo
	private CuentaFondo cuentaFondo;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº modelo
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº modelo
	public void setNumero(Integer numero ){
		this.numero = numero;
	}

	// GET Debe
	public Boolean getDebe() {
		return this.debe;
	}

	// SET Debe
	public void setDebe(Boolean debe ){
		this.debe = (debe == null) ? false : debe;
	}

	// GET Modelo
	public ComprobanteFondoModelo getComprobanteFondoModelo() {
		return this.comprobanteFondoModelo;
	}

	// SET Modelo
	public void setComprobanteFondoModelo(ComprobanteFondoModelo comprobanteFondoModelo ){
		this.comprobanteFondoModelo = comprobanteFondoModelo;
	}

	// GET Cuenta fondo
	public CuentaFondo getCuentaFondo() {
		return this.cuentaFondo;
	}

	// SET Cuenta fondo
	public void setCuentaFondo(CuentaFondo cuentaFondo ){
		this.cuentaFondo = cuentaFondo;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNumero() != null && this.getDebe() != null){
			return this.getNumero() + " - " +  this.getDebe();
		} else if(this.getNumero() != null && this.getDebe() == null){
			return this.getNumero().toString();
		} else if(this.getNumero() == null && this.getDebe() != null){
			return this.getDebe().toString();
		} else {
			return super.toString();
		}
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------