package com.massoftware.service.empresa;

import com.massoftware.service.EntityId;
import com.massoftware.service.empresa.Sucursal;
import com.massoftware.service.empresa.DepositoModulo;
import com.massoftware.service.seguridad.SeguridadPuerta;
import com.massoftware.service.seguridad.SeguridadPuerta;

public class Deposito extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº depósito
	private Integer numero;

	// Nombre
	private String nombre;

	// Abreviatura
	private String abreviatura;

	// Sucursal
	private Sucursal sucursal;

	// Módulo
	private DepositoModulo depositoModulo;

	// Puerta operativo
	private SeguridadPuerta puertaOperativo;

	// Puerta consulta
	private SeguridadPuerta puertaConsulta;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº depósito
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº depósito
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

	// GET Abreviatura
	public String getAbreviatura() {
		return this.abreviatura;
	}

	// SET Abreviatura
	public void setAbreviatura(String abreviatura ){
		this.abreviatura = (abreviatura == null || abreviatura.trim().length() == 0) ? null : abreviatura.trim();
	}

	// GET Sucursal
	public Sucursal getSucursal() {
		return this.sucursal;
	}

	// SET Sucursal
	public void setSucursal(Sucursal sucursal ){
		this.sucursal = sucursal;
	}

	// GET Módulo
	public DepositoModulo getDepositoModulo() {
		return this.depositoModulo;
	}

	// SET Módulo
	public void setDepositoModulo(DepositoModulo depositoModulo ){
		this.depositoModulo = depositoModulo;
	}

	// GET Puerta operativo
	public SeguridadPuerta getPuertaOperativo() {
		return this.puertaOperativo;
	}

	// SET Puerta operativo
	public void setPuertaOperativo(SeguridadPuerta puertaOperativo ){
		this.puertaOperativo = puertaOperativo;
	}

	// GET Puerta consulta
	public SeguridadPuerta getPuertaConsulta() {
		return this.puertaConsulta;
	}

	// SET Puerta consulta
	public void setPuertaConsulta(SeguridadPuerta puertaConsulta ){
		this.puertaConsulta = puertaConsulta;
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
		
	public Deposito clone() {
		
		Deposito other = (Deposito) super.clone();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		other.setNombre(this.getNombre());
		other.setAbreviatura(this.getAbreviatura());
		
		// -------------------------------------------------------------------
		
		if (this.getSucursal() != null) {
			other.setSucursal(this.getSucursal().clone());
		}
		
		// -------------------------------------------------------------------
		
		if (this.getDepositoModulo() != null) {
			other.setDepositoModulo(this.getDepositoModulo().clone());
		}
		
		// -------------------------------------------------------------------
		
		if (this.getPuertaOperativo() != null) {
			other.setPuertaOperativo(this.getPuertaOperativo().clone());
		}
		
		// -------------------------------------------------------------------
		
		if (this.getPuertaConsulta() != null) {
			other.setPuertaConsulta(this.getPuertaConsulta().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------