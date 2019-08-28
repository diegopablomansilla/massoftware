package com.massoftware.service.fondos;

import com.massoftware.service.*;

public class TicketsModelosFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Nº modelo (desde)
	private Integer numeroFrom;

	// Nº modelo (hasta)
	private Integer numeroTo;

	// Nombre
	private String nombre;

	// ticket
	private Tickets ticket;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Nº modelo (desde)
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}

	// SET Nº modelo (desde)
	public void setNumeroFrom(Integer numeroFrom){
		this.numeroFrom = numeroFrom;
	}

	// GET Nº modelo (hasta)
	public Integer getNumeroTo() {
		return this.numeroTo;
	}

	// SET Nº modelo (hasta)
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

	// GET ticket
	public Tickets getTicket() {
		return this.ticket;
	}

	// SET ticket
	public void setTicket(Tickets ticket){
		this.ticket = ticket;
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		TicketsModelosFiltro other = (TicketsModelosFiltro) obj;
		
		
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
		
		if (other.getTicket() == null && this.getTicket() != null) {
			return false;
		}
		
		if (other.getTicket() != null && this.getTicket() == null) {
			return false;
		}
		
		if (other.getTicket() != null && this.getTicket() != null) {
		
			if (other.getTicket().equals(this.getTicket()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		return true;
		
		// -------------------------------------------------------------------
	}
		
	public TicketsModelosFiltro clone() {
		
		TicketsModelosFiltro other = new TicketsModelosFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		other.setNumeroFrom(this.getNumeroFrom());
		other.setNumeroTo(this.getNumeroTo());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		if (this.getTicket() != null) {
			other.setTicket(this.getTicket().clone());
		}
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------