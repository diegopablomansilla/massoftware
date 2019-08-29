package com.massoftware.service.empresa;

import com.massoftware.service.*;

public class SucursalesFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Tipo sucursal
	private TiposSucursales tipoSucursal;

	// Nº sucursal (desde)
	private Integer numeroFrom;

	// Nº sucursal (hasta)
	private Integer numeroTo;

	// Abreviatura
	private String abreviatura;

	// Nombre
	private String nombre;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Tipo sucursal
	public TiposSucursales getTipoSucursal() {
		return this.tipoSucursal;
	}

	// SET Tipo sucursal
	public void setTipoSucursal(TiposSucursales tipoSucursal){
		this.tipoSucursal = tipoSucursal;
	}

	// GET Nº sucursal (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº sucursal (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº sucursal (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº sucursal (hasta)
	public void setNumeroTo(Integer numeroTo){
		this.numeroTo = numeroTo;
	}

	// GET Abreviatura
	public String getAbreviatura() {
		return this.abreviatura;
	}

	// SET Abreviatura
	public void setAbreviatura(String abreviatura){
		this.abreviatura = (abreviatura == null || abreviatura.trim().length() == 0) ? null : abreviatura.trim();
	}

	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}

	// SET Nombre
	public void setNombre(String nombre){
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		SucursalesFiltro other = (SucursalesFiltro) obj;
		
		
		// -------------------------------------------------------------------
		
		if (other.getTipoSucursal() == null && this.getTipoSucursal() != null) {
			return false;
		}
		
		if (other.getTipoSucursal() != null && this.getTipoSucursal() == null) {
			return false;
		}
		
		if (other.getTipoSucursal() != null && this.getTipoSucursal() != null) {
		
			if (other.getTipoSucursal().equals(this.getTipoSucursal()) == false) {
				return false;
			}
		
		}
		
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
		
		if (other.getAbreviatura() == null && this.getAbreviatura() != null) {
			return false;
		}
		
		if (other.getAbreviatura() != null && this.getAbreviatura() == null) {
			return false;
		}
		
		if (other.getAbreviatura() != null && this.getAbreviatura() != null) {
		
			if (other.getAbreviatura().equals(this.getAbreviatura()) == false) {
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
		
		return true;
		
		// -------------------------------------------------------------------
	}
		
	public SucursalesFiltro clone() {
		
		SucursalesFiltro other = new SucursalesFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		
		// -------------------------------------------------------------------
		
		if (this.getTipoSucursal() != null) {
			other.setTipoSucursal(this.getTipoSucursal().clone());
		}
		other.setNumeroFrom(this.getNumeroFrom());
		other.setNumeroTo(this.getNumeroTo());
		other.setAbreviatura(this.getAbreviatura());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------