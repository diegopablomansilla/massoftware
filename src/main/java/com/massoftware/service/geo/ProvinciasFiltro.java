package com.massoftware.service.geo;

import com.massoftware.service.*;

public class ProvinciasFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// País
	private Paises pais;

	// Nº provincia (desde)
	private Integer numeroFrom;

	// Nº provincia (hasta)
	private Integer numeroTo;

	// Abreviatura
	private String abreviatura;

	// Nombre
	private String nombre;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET País
	public Paises getPais() {
		return this.pais;
	}

	// SET País
	public void setPais(Paises pais){
		this.pais = pais;
	}

	// GET Nº provincia (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº provincia (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº provincia (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº provincia (hasta)
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
		
		ProvinciasFiltro other = (ProvinciasFiltro) obj;
		
		
		// -------------------------------------------------------------------
		
		if (other.getPais() == null && this.getPais() != null) {
			return false;
		}
		
		if (other.getPais() != null && this.getPais() == null) {
			return false;
		}
		
		if (other.getPais() != null && this.getPais() != null) {
		
			if (other.getPais().equals(this.getPais()) == false) {
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
		
	public ProvinciasFiltro clone() {
		
		ProvinciasFiltro other = new ProvinciasFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		
		// -------------------------------------------------------------------
		
		if (this.getPais() != null) {
			other.setPais(this.getPais().clone());
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