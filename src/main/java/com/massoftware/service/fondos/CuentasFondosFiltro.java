package com.massoftware.service.fondos;

import com.massoftware.service.*;
import com.massoftware.service.fondos.banco.Bancos;

public class CuentasFondosFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Nº cuenta (desde)
	private Integer numeroFrom;

	// Nº cuenta (hasta)
	private Integer numeroTo;

	// Nombre
	private String nombre;

	// banco
	private Bancos banco;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Nº cuenta (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº cuenta (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº cuenta (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº cuenta (hasta)
	public void setNumeroTo(Integer numeroTo){
		this.numeroTo = numeroTo;
	}

	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}

	// SET Nombre
	public void setNombre(String nombre){
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}

	// GET banco
	public Bancos getBanco() {
		return this.banco;
	}

	// SET banco
	public void setBanco(Bancos banco){
		this.banco = banco;
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		CuentasFondosFiltro other = (CuentasFondosFiltro) obj;
		
		
		// -------------------------------------------------------------------
		
		if (other.getNumeroFrom() == null && this.getNumeroFrom() != null) {
			return false;
		}
		
		if (other.getNumeroFrom() != null && this.getNumeroFrom() == null) {
			return false;
		}
		
		if (other.getNumeroFrom() != null && this.getNumeroFrom() != null) {
		
			if (other.getNumeroFrom().equals(this.getNumeroFrom()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getNumeroTo() == null && this.getNumeroTo() != null) {
			return false;
		}
		
		if (other.getNumeroTo() != null && this.getNumeroTo() == null) {
			return false;
		}
		
		if (other.getNumeroTo() != null && this.getNumeroTo() != null) {
		
			if (other.getNumeroTo().equals(this.getNumeroTo()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getNombre() == null && this.getNombre() != null) {
			return false;
		}
		
		if (other.getNombre() != null && this.getNombre() == null) {
			return false;
		}
		
		if (other.getNombre() != null && this.getNombre() != null) {
		
			if (other.getNombre().equals(this.getNombre()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getBanco() == null && this.getBanco() != null) {
			return false;
		}
		
		if (other.getBanco() != null && this.getBanco() == null) {
			return false;
		}
		
		if (other.getBanco() != null && this.getBanco() != null) {
		
			if (other.getBanco().equals(this.getBanco()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		return true;
		
		// -------------------------------------------------------------------
	}
		
	public CuentasFondosFiltro clone() {
		
		CuentasFondosFiltro other = new CuentasFondosFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		other.setNumeroFrom(this.getNumeroFrom());
		other.setNumeroTo(this.getNumeroTo());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		if (this.getBanco() != null) {
			other.setBanco(this.getBanco().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------