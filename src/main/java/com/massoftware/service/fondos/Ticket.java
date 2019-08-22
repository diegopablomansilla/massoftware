package com.massoftware.service.fondos;

import com.massoftware.service.EntityId;
import com.massoftware.service.fondos.TicketControlDenunciados;

public class Ticket extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº ticket
	private Integer numero;

	// Nombre
	private String nombre;

	// Fecha actualización
	private java.util.Date fechaActualizacion;

	// Cantidad por lotes
	private Integer cantidadPorLotes;

	// Control denunciados
	private TicketControlDenunciados ticketControlDenunciados;

	// Valor máximo
	private java.math.BigDecimal valorMaximo;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº ticket
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº ticket
	public void setNumero(Integer numero ){
		this.numero = numero;
	}

	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}

	// SET Nombre
	public void setNombre(String nombre ){
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}

	// GET Fecha actualización
	public java.util.Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	// SET Fecha actualización
	public void setFechaActualizacion(java.util.Date fechaActualizacion ){
		this.fechaActualizacion = fechaActualizacion;
	}

	// GET Cantidad por lotes
	public Integer getCantidadPorLotes() {
		return this.cantidadPorLotes;
	}

	// SET Cantidad por lotes
	public void setCantidadPorLotes(Integer cantidadPorLotes ){
		this.cantidadPorLotes = cantidadPorLotes;
	}

	// GET Control denunciados
	public TicketControlDenunciados getTicketControlDenunciados() {
		return this.ticketControlDenunciados;
	}

	// SET Control denunciados
	public void setTicketControlDenunciados(TicketControlDenunciados ticketControlDenunciados ){
		this.ticketControlDenunciados = ticketControlDenunciados;
	}

	// GET Valor máximo
	public java.math.BigDecimal getValorMaximo() {
		return this.valorMaximo;
	}

	// SET Valor máximo
	public void setValorMaximo(java.math.BigDecimal valorMaximo ){
		this.valorMaximo = valorMaximo;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNumero() != null && this.getNombre() != null){
			return this.getNumero() + " - " +  this.getNombre();
		} else if(this.getNumero() != null && this.getNombre() == null){
			return this.getNumero().toString();
		} else if(this.getNumero() == null && this.getNombre() != null){
			return this.getNombre();
		} else {
			return super.toString();
		}
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------