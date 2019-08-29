package com.massoftware.service.clientes;

import com.massoftware.service.EntityId;

public class MotivosBloqueosClientes extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Clasificación de cliente
	private String nombreClasificacionCliente;

	// Nº motivo
	private Integer numero;

	// Nombre
	private String nombre;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Clasificación de cliente
	public String getNombreClasificacionCliente() {
		return this.nombreClasificacionCliente;
	}

	// SET Clasificación de cliente
	public void setNombreClasificacionCliente(String nombreClasificacionCliente ){
		this.nombreClasificacionCliente = (nombreClasificacionCliente == null || nombreClasificacionCliente.trim().length() == 0) ? null : nombreClasificacionCliente.trim();
	}

	// GET Nº motivo
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº motivo
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

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNombreClasificacionCliente() != null && this.getNumero() != null){
			return this.getNombreClasificacionCliente() + " - " +  this.getNumero();
		} else if(this.getNombreClasificacionCliente() != null && this.getNumero() == null){
			return this.getNombreClasificacionCliente();
		} else if(this.getNombreClasificacionCliente() == null && this.getNumero() != null){
			return this.getNumero().toString();
		} else {
			return super.toString();
		}
	}
		
	public MotivosBloqueosClientes clone() {
		
		MotivosBloqueosClientes other = new MotivosBloqueosClientes();
		
		other.setId(this.getId());
		other.setNombreClasificacionCliente(this.getNombreClasificacionCliente());
		other.setNumero(this.getNumero());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------