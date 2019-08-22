package com.massoftware.service.fondos.banco;

import com.massoftware.service.*;

public class BancosFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Nº banco (desde)
	private Integer numeroFrom;

	// Nº banco (hasta)
	private Integer numeroTo;

	// Vigente
	private Boolean vigente;
	private FBoolean vigenteX;

	// Nombre
	private String nombre;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Nº banco (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº banco (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº banco (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº banco (hasta)
	public void setNumeroTo(Integer numeroTo){
		this.numeroTo = numeroTo;
	}

	// GET Vigente
	public Boolean getVigente() {
		return this.vigente;
	}

	// GET Vigente
	public FBoolean getVigenteX() {
		return this.vigenteX;
	}

	// SET Vigente
	public void setVigente(Boolean vigente ){
		this.vigente = vigente;
		this.vigenteX = new FBoolean(vigente);
	}

	// SET Vigente
	public void setVigenteX(FBoolean vigenteX){
		this.vigenteX = vigenteX;
		this.vigente = (this.vigenteX == null) ? null : this.vigenteX.getValue();
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
		
		BancosFiltro other = (BancosFiltro) obj;
		
		
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
		
		if (other.getVigente() == null && this.getVigente() != null) {
			return false;
		}
		
		if (other.getVigente() != null && this.getVigente() == null) {
			return false;
		}
		
		if (other.getVigente() != null && this.getVigente() != null) {
		
			if (other.getVigente().equals(this.getVigente()) == false) {
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
		
	public BancosFiltro clone() {
		
		BancosFiltro other = new BancosFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		other.setNumeroFrom(this.getNumeroFrom());
		other.setNumeroTo(this.getNumeroTo());
		other.setVigente(this.getVigente());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------