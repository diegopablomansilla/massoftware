package com.massoftware.service.geo;

import com.massoftware.service.*;
import com.massoftware.service.geo.Pais;
import com.massoftware.service.geo.Provincia;
import com.massoftware.service.geo.Ciudad;

public class CodigosPostalesFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Código
	private String codigo;

	// Secuencia (desde)
	private Integer numeroFrom;

	// Secuencia (hasta)
	private Integer numeroTo;

	// País
	private Pais pais;

	// Provincia
	private Provincia provincia;

	// Ciudad
	private Ciudad ciudad;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Código
	public String getCodigo() {
		return this.codigo;
	}

	// SET Código
	public void setCodigo(String codigo){
		this.codigo = (codigo == null || codigo.trim().length() == 0) ? null : codigo.trim();
	}

	// GET Secuencia (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Secuencia (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Secuencia (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Secuencia (hasta)
	public void setNumeroTo(Integer numeroTo){
		this.numeroTo = numeroTo;
	}

	// GET País
	public Pais getPais() {
		return this.pais;
	}

	// SET País
	public void setPais(Pais pais){
		this.pais = pais;
	}

	// GET Provincia
	public Provincia getProvincia() {
		return this.provincia;
	}

	// SET Provincia
	public void setProvincia(Provincia provincia){
		this.provincia = provincia;
	}

	// GET Ciudad
	public Ciudad getCiudad() {
		return this.ciudad;
	}

	// SET Ciudad
	public void setCiudad(Ciudad ciudad){
		this.ciudad = ciudad;
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		CodigosPostalesFiltro other = (CodigosPostalesFiltro) obj;
		
		
		// -------------------------------------------------------------------
		
		if (other.getCodigo() == null && this.getCodigo() != null) {
			return false;
		}
		
		if (other.getCodigo() != null && this.getCodigo() == null) {
			return false;
		}
		
		if (other.getCodigo() != null && this.getCodigo() != null) {
		
			if (other.getCodigo().equals(this.getCodigo()) == false) {
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
		
		if (other.getCiudad() == null && this.getCiudad() != null) {
			return false;
		}
		
		if (other.getCiudad() != null && this.getCiudad() == null) {
			return false;
		}
		
		if (other.getCiudad() != null && this.getCiudad() != null) {
		
			if (other.getCiudad().equals(this.getCiudad()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		return true;
		
		// -------------------------------------------------------------------
	}
		
	public CodigosPostalesFiltro clone() {
		
		CodigosPostalesFiltro other = new CodigosPostalesFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		other.setCodigo(this.getCodigo());
		other.setNumeroFrom(this.getNumeroFrom());
		other.setNumeroTo(this.getNumeroTo());
		
		// -------------------------------------------------------------------
		
		if (this.getPais() != null) {
			other.setPais(this.getPais().clone());
		}
		
		// -------------------------------------------------------------------
		
		if (this.getProvincia() != null) {
			other.setProvincia(this.getProvincia().clone());
		}
		
		// -------------------------------------------------------------------
		
		if (this.getCiudad() != null) {
			other.setCiudad(this.getCiudad().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------