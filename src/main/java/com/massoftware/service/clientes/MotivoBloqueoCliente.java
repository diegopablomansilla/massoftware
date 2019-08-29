package com.massoftware.service.clientes;

import com.massoftware.service.EntityId;
import com.massoftware.service.clientes.ClasificacionCliente;

public class MotivoBloqueoCliente extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº motivo
	private Integer numero;

	// Nombre
	private String nombre;

	// Clasificación de cliente
	private ClasificacionCliente clasificacionCliente;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
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

	// GET Clasificación de cliente
	public ClasificacionCliente getClasificacionCliente() {
		return this.clasificacionCliente;
	}

	// SET Clasificación de cliente
	public void setClasificacionCliente(ClasificacionCliente clasificacionCliente ){
		this.clasificacionCliente = clasificacionCliente;
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
		
	public MotivoBloqueoCliente clone() {
		
		MotivoBloqueoCliente other = new MotivoBloqueoCliente();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
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