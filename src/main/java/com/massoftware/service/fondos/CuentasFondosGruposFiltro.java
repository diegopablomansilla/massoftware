package com.massoftware.service.fondos;

import com.massoftware.service.*;

public class CuentasFondosGruposFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Nº grupo (desde)
	private Integer numeroFrom;

	// Nº grupo (hasta)
	private Integer numeroTo;

	// Nombre
	private String nombre;

	// Rubro
	private CuentasFondosRubros cuentaFondoRubro;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Nº grupo (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº grupo (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº grupo (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº grupo (hasta)
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

	// GET Rubro
	public CuentasFondosRubros getCuentaFondoRubro() {
		return this.cuentaFondoRubro;
	}

	// SET Rubro
	public void setCuentaFondoRubro(CuentasFondosRubros cuentaFondoRubro){
		this.cuentaFondoRubro = cuentaFondoRubro;
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		CuentasFondosGruposFiltro other = (CuentasFondosGruposFiltro) obj;
		
		
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
		
		if (other.getCuentaFondoRubro() == null && this.getCuentaFondoRubro() != null) {
			return false;
		}
		
		if (other.getCuentaFondoRubro() != null && this.getCuentaFondoRubro() == null) {
			return false;
		}
		
		if (other.getCuentaFondoRubro() != null && this.getCuentaFondoRubro() != null) {
		
			if (other.getCuentaFondoRubro().equals(this.getCuentaFondoRubro()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		return true;
		
		// -------------------------------------------------------------------
	}
		
	public CuentasFondosGruposFiltro clone() {
		
		CuentasFondosGruposFiltro other = new CuentasFondosGruposFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		other.setNumeroFrom(this.getNumeroFrom());
		other.setNumeroTo(this.getNumeroTo());
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