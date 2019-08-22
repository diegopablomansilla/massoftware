package com.massoftware.service.contabilidad;

import com.massoftware.service.EntityId;
import com.massoftware.service.contabilidad.TipoPuntoEquilibrio;
import com.massoftware.service.contabilidad.EjercicioContable;

public class PuntoEquilibrio extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº cc
	private Integer numero;

	// Nombre
	private String nombre;

	// Tipo
	private TipoPuntoEquilibrio tipoPuntoEquilibrio;

	// Ejercicio
	private EjercicioContable ejercicioContable;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº cc
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº cc
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

	// GET Tipo
	public TipoPuntoEquilibrio getTipoPuntoEquilibrio() {
		return this.tipoPuntoEquilibrio;
	}

	// SET Tipo
	public void setTipoPuntoEquilibrio(TipoPuntoEquilibrio tipoPuntoEquilibrio ){
		this.tipoPuntoEquilibrio = tipoPuntoEquilibrio;
	}

	// GET Ejercicio
	public EjercicioContable getEjercicioContable() {
		return this.ejercicioContable;
	}

	// SET Ejercicio
	public void setEjercicioContable(EjercicioContable ejercicioContable ){
		this.ejercicioContable = ejercicioContable;
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