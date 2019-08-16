package com.massoftware.service.fondos.banco;

import com.massoftware.service.AbstractFilter;

public class BancosFiltro extends AbstractFilter {

	// ---------------------------------------------------------------------------------------------------------------------------

	// Nº banco (desde)
	private Integer numeroFrom;

	// Nº banco (hasta)
	private Integer numeroTo;

	// Nombre
	private String nombre;

	// Obsoleto
	private Boolean bloqueado = false;

	private Integer bloqueadoInt = 0;

	// ---------------------------------------------------------------------------------------------------------------------------

	// GET Nº banco (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº banco (desde)
	public void setNumeroFrom(Integer numeroFrom) {
		this.numeroFrom = numeroFrom;
	}

	// GET Nº banco (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº banco (hasta)
	public void setNumeroTo(Integer numeroTo) {
		this.numeroTo = numeroTo;
	}

	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}

	// SET Nombre
	public void setNombre(String nombre) {
		this.nombre = (nombre != null && nombre.trim().length() == 0) ? null : nombre;
	}

	// GET Obsoleto
	public Boolean getBloqueado() {
		return this.bloqueado;
	}

	// GET Obsoleto
	public Integer getBloqueadoInt() {
		return this.bloqueadoInt;
	}

	// SET Obsoleto
	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
		this.bloqueadoInt = ((this.bloqueado == null) ? null : ((this.bloqueado == false) ? 0 : 1));
	}

	// SET Obsoleto
	public void setBloqueadoInt(Integer bloqueadoInt) {
		this.bloqueadoInt = bloqueadoInt;
		this.bloqueado = ((this.bloqueadoInt == null || bloqueadoInt == 2) ? null
				: ((this.bloqueadoInt == 0) ? false : true));
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

		if (other.getBloqueado() == null && this.getBloqueado() != null) {
			return false;
		}

		if (other.getBloqueado() != null && this.getBloqueado() == null) {
			return false;
		}

		if (other.getBloqueado() != null && this.getBloqueado() != null) {

			if (other.getBloqueado().equals(this.getBloqueado()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		return true;

		// -------------------------------------------------------------------
	}

} // END CLASS	