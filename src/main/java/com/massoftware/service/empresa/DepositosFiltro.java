package com.massoftware.service.empresa;

import com.massoftware.service.*;
import com.massoftware.service.empresa.Sucursal;

public class DepositosFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Nº depósito (desde)
	private Integer numeroFrom;

	// Nº depósito (hasta)
	private Integer numeroTo;

	// Nombre
	private String nombre;

	// Sucursal
	private Sucursales sucursal;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Nº depósito (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº depósito (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº depósito (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº depósito (hasta)
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

	// GET Sucursal
	public Sucursales getSucursal() {
		return this.sucursal;
	}

	// SET Sucursal
	public void setSucursal(Sucursales sucursal){
		this.sucursal = sucursal;
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		DepositosFiltro other = (DepositosFiltro) obj;
		
		
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
		
		if (other.getSucursal() == null && this.getSucursal() != null) {
			return false;
		}
		
		if (other.getSucursal() != null && this.getSucursal() == null) {
			return false;
		}
		
		if (other.getSucursal() != null && this.getSucursal() != null) {
		
			if (other.getSucursal().equals(this.getSucursal()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		return true;
		
		// -------------------------------------------------------------------
	}
		
	public DepositosFiltro clone() {
		
		DepositosFiltro other = new DepositosFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		other.setNumeroFrom(this.getNumeroFrom());
		other.setNumeroTo(this.getNumeroTo());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		if (this.getSucursal() != null) {
			other.setSucursal(this.getSucursal().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------