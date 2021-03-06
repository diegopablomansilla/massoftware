package com.massoftware.service.geo;

import com.massoftware.service.*;

public class CiudadesFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// País
	private Paises pais;

	// Provincia
	private Provincias provincia;

	// Nº ciudad (desde)
	private Integer numeroFrom;

	// Nº ciudad (hasta)
	private Integer numeroTo;

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

	// GET Provincia
	public Provincias getProvincia() {
		return this.provincia;
	}

	// SET Provincia
	public void setProvincia(Provincias provincia){
		this.provincia = provincia;
	}

	// GET Nº ciudad (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº ciudad (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº ciudad (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº ciudad (hasta)
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
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		CiudadesFiltro other = (CiudadesFiltro) obj;
		
		
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
		
		if (other.getProvincia() == null && this.getProvincia() != null) {
			return false;
		}
		
		if (other.getProvincia() != null && this.getProvincia() == null) {
			return false;
		}
		
		if (other.getProvincia() != null && this.getProvincia() != null) {
		
			if (other.getProvincia().equals(this.getProvincia()) == false) {
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
		
	public CiudadesFiltro clone() {
		
		CiudadesFiltro other = new CiudadesFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		
		// -------------------------------------------------------------------
		
		if (this.getPais() != null) {
			other.setPais(this.getPais().clone());
		}
		
		// -------------------------------------------------------------------
		
		if (this.getProvincia() != null) {
			other.setProvincia(this.getProvincia().clone());
		}
		other.setNumeroFrom(this.getNumeroFrom());
		other.setNumeroTo(this.getNumeroTo());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------