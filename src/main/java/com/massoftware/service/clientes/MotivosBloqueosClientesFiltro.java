package com.massoftware.service.clientes;

import com.massoftware.service.*;
import com.massoftware.service.clientes.ClasificacionCliente;

public class MotivosBloqueosClientesFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Nº motivo (desde)
	private Integer numeroFrom;

	// Nº motivo (hasta)
	private Integer numeroTo;

	// Nombre
	private String nombre;

	// Clasificación de cliente
	private ClasificacionCliente clasificacionCliente;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Nº motivo (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº motivo (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº motivo (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº motivo (hasta)
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

	// GET Clasificación de cliente
	public ClasificacionCliente getClasificacionCliente() {
		return this.clasificacionCliente;
	}

	// SET Clasificación de cliente
	public void setClasificacionCliente(ClasificacionCliente clasificacionCliente){
		this.clasificacionCliente = clasificacionCliente;
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		MotivosBloqueosClientesFiltro other = (MotivosBloqueosClientesFiltro) obj;
		
		
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
		
		if (other.getClasificacionCliente() == null && this.getClasificacionCliente() != null) {
			return false;
		}
		
		if (other.getClasificacionCliente() != null && this.getClasificacionCliente() == null) {
			return false;
		}
		
		if (other.getClasificacionCliente() != null && this.getClasificacionCliente() != null) {
		
			if (other.getClasificacionCliente().equals(this.getClasificacionCliente()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		return true;
		
		// -------------------------------------------------------------------
	}
		
	public MotivosBloqueosClientesFiltro clone() {
		
		MotivosBloqueosClientesFiltro other = new MotivosBloqueosClientesFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		other.setNumeroFrom(this.getNumeroFrom());
		other.setNumeroTo(this.getNumeroTo());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		if (this.getClasificacionCliente() != null) {
			other.setClasificacionCliente(this.getClasificacionCliente().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------